/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controler.Controler;
import Model.Board;
import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.*;
import com.sun.javafx.sg.prism.NGNode;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Roman
 */
public class View extends Application implements Observer {

   private final String CARDS_DIRECTORY = "../Images/cards/";
   private final String WALLPAPER_DIRECTORY = "../Images/wallpaper.jpg";
   private final String wallpaper = View.class.getResource("wallpaper.jpg").toExternalForm();

   @Override
   public void start ( Stage primaryStage ) {
      Board _model = new Board();
      Controler _controler = new Controler(_model);
      _model.addObserver(this);

      Image _img_wlp = new Image("file:" + WALLPAPER_DIRECTORY);
      ImageView _wallpaper = new ImageView(_img_wlp);

      Button btn = new Button();
      btn.setText("Say 'Hello World'");
      btn.setOnAction(new EventHandler<ActionEvent>() {

	 @Override
	 public void handle ( ActionEvent event ) {
	    System.out.println("Hello World!");
	 }
      });

      StackPane root = new StackPane();
      Group _board = new Group();

      _board.getChildren().add(btn);
      root.getChildren().add(_board);
      //root.setStyle("-fx-background-image: url(\"" + wallpaper + "\"); -fx-background-repeat: stretch;");
      Scene scene = new Scene(root, 300, 250);

      primaryStage.setTitle("Hello World!");
      primaryStage.setScene(scene);
      scene.getStylesheets().add(View.class.getResource("style.css").toExternalForm());
      primaryStage.show();
   }

   /**
    * @param args the command line arguments
    */
   public static void main ( String[] args ) {
      launch(args);
   }

   @Override
   public void update ( Observable o, Object arg ) {
      
   }
}
