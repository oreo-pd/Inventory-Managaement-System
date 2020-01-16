package com.DSCE;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
 
/**
 * 
 * @author NawazishMohammad
 *  ImageViewExample demonstrates the various ways of loading an image 
 *  and rendering the same on the JavaFX stage.It also demonstrates the 
 *  various functionalities that ImageView class has to offer for image rendering.
 */
public class ImageViewExample extends Application {
    @Override
    public void start(Stage primaryStage) {
        /**
         * In the following example image is assumed to be present 
         * in a directory on the application class path
         */
        Image image = new Image("C://Users//HP//Desktop//purpleflo.jpg");     
        /**
         * imageView1 takes image and manipulates it size,
         * and preserves its aspect ratio
         */
        ImageView imageView1 = new ImageView(image);
            imageView1.setFitHeight(100);
            imageView1.setPreserveRatio(true);
         
        /**
         * imageView2 manipulates the width of the image, 
         * preserves the aspect ratio and rotates the image by 90 degrees
         */
        ImageView imageView2 = new ImageView(image);
            imageView2.setFitWidth(200);
            imageView2.setPreserveRatio(true);
            imageView2.setRotate(90);
         
        /**
         * We set a viewport on imageView3 creating an illusion of zoom-in effect
         */
        Rectangle2D viewPort = new Rectangle2D(925, 50, 600, 600);
        ImageView imageView3 = new ImageView(image);
            imageView3.setFitWidth(100);
            imageView3.setPreserveRatio(true);
            imageView3.setViewport(viewPort);
         
        /**
         * imageView4 receives its image from a public url
         */
        String flowerImageStr = "https://images.immediate.co.uk/production/volatile/sites/10/2018/02/7dce6028-0e39-4c0a-aa06-2a5b26285f9a-45028f8.jpg?quality=45&crop=13px,20px,2022px,860px&resize=960,640";
        Image flowerImage = new Image(flowerImageStr);  
        ImageView imageView4 = new ImageView(flowerImage);
            imageView4.setFitWidth(200);
            imageView4.setPreserveRatio(true);
         
        /**
         * imageView5 demonstrates setting ImageView.image using the JavaFX's Property API
         */
        ImageView imageView5 = new ImageView();
            imageView5.imageProperty().set(image);
            imageView5.setFitWidth(200);
            imageView5.setPreserveRatio(true);
            imageView5.setRotate(-90);
             
        /**
         * imageView6 directly points to the url of the image-
         * obviating the need for an Image class instantiation
         */
        String imgUrl = "http://www.imgion.com/images/01/Voilet-Flower-.jpg";
        ImageView imageView6 = new ImageView(imgUrl);
            imageView6.setFitWidth(200);
            imageView6.setFitHeight(200);
            imageView6.setPreserveRatio(true);
             
        HBox hbox = new HBox(10);
            hbox.getChildren().addAll(imageView1,imageView2,
                        imageView3,imageView4, 
                        imageView5,imageView6);
             
        Scene scene = new Scene(hbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
     
    public static void main(String[] args) {
        launch(args);
    }
}
