package application;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.WeakEventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;



public class Main extends Application {
	
	private double mouseDragDeltaX = 0;
    private double mouseDragDeltaY = 0;
    private EventHandler<MouseEvent> mousePressedHandler;
    private EventHandler<MouseEvent> mouseDraggedHandler;
    private WeakEventHandler<MouseEvent> weakMousePressedHandler;
    private WeakEventHandler<MouseEvent> weakMouseDraggedHandler;
 
	@FXML
	private ImageView myIMG;
	
	@SuppressWarnings("deprecation")
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader myloader = new FXMLLoader(getClass().getResource("MyMainWindow.fxml"));
			myloader.setController(new EventHandlingController());
			AnchorPane root = myloader.load();
			HBox hb = (HBox) root.getChildren().get(1);
			
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.setScene(scene);
			primaryStage.setResizable(true);
//			primaryStage.sizeToScene();
			
			mousePressedHandler = (MouseEvent event) -> {
	            mouseDragDeltaX = hb.getLayoutX() - event.getSceneX();
	            mouseDragDeltaY = hb.getLayoutY() - event.getSceneY();
	        };
	        weakMousePressedHandler = new WeakEventHandler<>(mousePressedHandler);
	        hb.setOnMousePressed(weakMousePressedHandler);
	 
	        mouseDraggedHandler = (MouseEvent event) -> {
	            primaryStage.setX(event.getScreenX() + mouseDragDeltaX);
	            primaryStage.setY(event.getScreenY() + mouseDragDeltaY);
	        };
	        weakMouseDraggedHandler = new WeakEventHandler<>(mouseDraggedHandler);
	        hb.setOnMouseDragged(weakMouseDraggedHandler);

			primaryStage.show();
			primaryStage.setHeight(500);
			primaryStage.setWidth(1000);
			primaryStage.centerOnScreen();
			
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
