package com.DSCE.dsa;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FrontEnd {
	
	
	
	
    @FXML
    private AnchorPane new_id;

    @FXML
    private HBox supply;

    @FXML
    private HBox product;

    @FXML
    private HBox payment;

    @FXML
    private HBox prdetails;

    
    @FXML
    private ImageView exit;

	
	public void screenDestroy(Event e)
	{
		Stage primstage = (Stage) exit.getScene().getWindow();
		primstage.close();
	}
	
	public void open_Product(Event e)
	{
		System.out.println("das");
		try {
			Stage primaryStage = new Stage();
			Parent root=FXMLLoader.load(getClass().getResource("Product.fxml"));
			Screen screen = Screen.getPrimary();
			//BorderPane root = new BorderPane();
			
			
			Rectangle2D screenBounds = Screen.getPrimary().getBounds();
			//Scene scene = new Scene(root,screenBounds.getWidth()/2, screenBounds.getHeight()/2);
			int width = (int) screenBounds.getWidth();
			width = (width/100)*70;

			int height = (int) screenBounds.getWidth();
			 height = (height/100)*50;
			 primaryStage.initStyle(StageStyle.UNDECORATED);

			Scene scene = new Scene(root,width,height);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Product Detail");
			primaryStage.show();
		} catch(Exception et) {
			et.printStackTrace();
		}
	}
	
	public void open_Supply(Event e)
	{
		try {
			Stage primaryStage = new Stage();
			Parent root=FXMLLoader.load(getClass().getResource("Supply.fxml"));
			Screen screen = Screen.getPrimary();
			//BorderPane root = new BorderPane();
			
			
			Rectangle2D screenBounds = Screen.getPrimary().getBounds();
			Scene scene = new Scene(root,screenBounds.getWidth()/2, screenBounds.getHeight()/2);
			primaryStage.setMaximized(true);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Supply List");
			primaryStage.show();
		} catch(Exception et) {
			et.printStackTrace();
		}
	}
	
	
	public void open_payment(Event e)
	{
		try {
			Stage primaryStage = new Stage();
			Parent root=FXMLLoader.load(getClass().getResource("History.fxml"));
			Screen screen = Screen.getPrimary();
			//BorderPane root = new BorderPane();
			
			
			Rectangle2D screenBounds = Screen.getPrimary().getBounds();
			Scene scene = new Scene(root,screenBounds.getWidth()/2, screenBounds.getHeight()/2);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setMaximized(true);
			primaryStage.setScene(scene);
			primaryStage.setTitle("History");
			primaryStage.show();
		} catch(Exception et) {
			et.printStackTrace();
		}
	}
	
	public void open_new(Event e)
	{
		try {
			Stage primaryStage = new Stage();
			Parent root=FXMLLoader.load(getClass().getResource("ProductDetails.fxml"));
			Screen screen = Screen.getPrimary();
			//BorderPane root = new BorderPane();
			
			
			Rectangle2D screenBounds = Screen.getPrimary().getBounds();
			Scene scene = new Scene(root,screenBounds.getWidth()/2, screenBounds.getHeight()/2);
			primaryStage.setMaximized(true);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Product Details");
			primaryStage.show();
		} catch(Exception et) {
			et.printStackTrace();
		}
	}
	
	public void openLabs(Event e)
	{
		try {
			Stage primaryStage = new Stage();
			Parent root=FXMLLoader.load(getClass().getResource("History.fxml"));
			Screen screen = Screen.getPrimary();
			//BorderPane root = new BorderPane();
			
			
			Rectangle2D screenBounds = Screen.getPrimary().getBounds();
			//Scene scene = new Scene(root,screenBounds.getWidth()/2, screenBounds.getHeight()/2);
			//Screen screen = Screen.getPrimary();
			int width = (int) screenBounds.getWidth();
			width = (width/100)*60;

			int height = (int) screenBounds.getWidth();
			 height = (height/100)*50;
			 primaryStage.initStyle(StageStyle.UNDECORATED);

			Scene scene = new Scene(root,width,height);

			primaryStage.setMaximized(true);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("History");
			primaryStage.show();
		} catch(Exception et) {
			et.printStackTrace();
		}
	}
}