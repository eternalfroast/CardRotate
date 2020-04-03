
/**
@author:Saurav Pradhan



Program Description:

It is a Java program using JavaFX that displays five playing cards. In the first row display 
three playing cards (randomly selected from the first 52 cards). In the second and third rows display two different cards 
compared to the first row at 45 degree and 90 degree angles respectively.



*/

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.*;

import java.io.*;


public class CardDisplay extends Application{
	
	//creating the method to shuffle the card to  ensure that the card is unique and is not repeated.
	public ArrayList<Integer> uniqueSelection(){
		ArrayList<Integer> selection = new ArrayList<Integer>();
		for (int i = 0; i<53; i ++){
			selection.add(i+1);
		}
		Collections.shuffle(selection);
		return (selection);
	}
	
	public void start(Stage primaryStage) throws Exception{
		ArrayList<Integer> selection = uniqueSelection();

		//Creating a pane and setting its properties
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(10,10,10,10));
		pane.setHgap(15.0); //defining the horizontal gap width
		pane.setVgap(15.0); //defining the vertical gap width


		//placing nodes in the pane
		for (int i = 0; i<3; i++){
			Image cards = new Image("cards/" + selection.get(i)+".png");
			pane.add(new ImageView(cards), i, 0); //displaying the cards in the first row of the grid
		}

		Image card4 = new Image("cards/"+ selection.get(3) + ".png");
		ImageView imageView4 = new ImageView(card4);
		imageView4.setRotate(45);//rotating the card to 4 degree
		pane.add(imageView4,1,1); // assigning the position of the card

		Image card5 = new Image("cards/"+ selection.get(4) + ".png");
		ImageView imageView5 = new ImageView(card5);
		imageView5.setRotate(90); // rotating the image to 90 degree
		pane.add(imageView5,1,2); // assigning the position of the card


		//creating a scene and palce it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Card Display"); //setting the title of stage
		primaryStage.setScene(scene);//placing the scene in the stage
		primaryStage.show(); // displaying the stage

	}

    
}