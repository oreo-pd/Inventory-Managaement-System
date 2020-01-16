package com.DSCE.dsa;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView.EditEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.log4j.BasicConfigurator;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Query;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.internal.NonNull;
import com.sun.javafx.tk.Toolkit.Task;

public class App extends Application {
	
	


public void start(Stage primaryStage) {
try {


 BasicConfigurator.configure();
     	FileInputStream serviceAccount=
  new FileInputStream("C:\\Users\\HP\\Downloads\\servkey.json");
  FirebaseOptions options = new FirebaseOptions.Builder()
		  
  
   .setCredentials(GoogleCredentials.fromStream(serviceAccount))
   .setDatabaseUrl("https://dbmsproj-54534.firebaseio.com")
   .build();

  FirebaseApp.initializeApp(options);
  


//String email = "myemail@email.com";
//String password = "mypassword";




  


Parent root1=FXMLLoader.load(getClass().getResource("SignUp.fxml.fxml"));
//	BorderPane root = new BorderPane();
Rectangle2D screenBounds = Screen.getPrimary().getBounds();
Screen screen = Screen.getPrimary();
int width = (int) screenBounds.getWidth();
width = (width/100)*60;

int height = (int) screenBounds.getWidth();
 height = (height/100)*50;
 primaryStage.initStyle(StageStyle.UNDECORATED);

Scene scene = new Scene(root1,width,height);


//Scene scene = new Scene(root1,400,400);
scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
primaryStage.setScene(scene);
primaryStage.show();	} catch(Exception e) {
e.printStackTrace();
}
}


public static void main(String[] args) {
	
	
	
	
launch(args);
}
}







