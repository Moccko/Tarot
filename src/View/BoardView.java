/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controler.*;
import Model.*;
import java.util.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author Roman
 */
public class BoardView extends Application implements Observer {

   private final String CARDS_DIRECTORY = "./resources/";
   private final String WALLPAPER_DIRECTORY = ".resources/wallpaper.jpg";

   private DeckView _initial, _dog, _player_1, _player_2, _player_3, _player_4;
   private AnchorPane _layout;

   @Override
   public void start ( Stage primaryStage ) {
      BoardModel _model = new BoardModel();
      BoardControler _controler = new BoardControler(_model);
      _model.addObserver(this);

      Image _img_wlp = new Image("file:" + WALLPAPER_DIRECTORY);
      ImageView _wallpaper = new ImageView(_img_wlp);

      _initial = new DeckView(_model.getInitial_deck(), _controler.getInitial_deck(), CARDS_DIRECTORY, ORIENTATION.VERTICAL);
      _dog = new DeckView(_model.getDog(), _controler.getDog(), CARDS_DIRECTORY, ORIENTATION.VERTICAL);
      _player_1 = new DeckView(_model.getPlayer_1(), _controler.getPlayer_1(), CARDS_DIRECTORY, ORIENTATION.VERTICAL);
      _player_2 = new DeckView(_model.getPlayer_2(), _controler.getPlayer_2(), CARDS_DIRECTORY, ORIENTATION.HORIZONTAL);
      _player_3 = new DeckView(_model.getPlayer_3(), _controler.getPlayer_3(), CARDS_DIRECTORY, ORIENTATION.VERTICAL);
      _player_4 = new DeckView(_model.getPlayer_4(), _controler.getPlayer_4(), CARDS_DIRECTORY, ORIENTATION.HORIZONTAL);

      Button btn = new Button();
      btn.setText("Say 'Hello World'");
      btn.setOnAction(( ActionEvent event ) -> {
	 System.out.println("Hello World!");
      });

      StackPane root = new StackPane();
      Group _board = new Group();

      _layout = new AnchorPane();

      AnchorPane.setBottomAnchor(_player_1, 10.0d);
      AnchorPane.setLeftAnchor(_player_2, 10.0d);
      AnchorPane.setTopAnchor(_player_3, 10.0d);
      AnchorPane.setTopAnchor(_initial, 10.0d);
      AnchorPane.setRightAnchor(_player_4, 10.0d);
      AnchorPane.setRightAnchor(_initial, 10.0d);
      _layout.getChildren().add(_initial);
      _layout.getChildren().add(_player_1);
      _layout.getChildren().add(_player_2);
      _layout.getChildren().add(_player_3);
      _layout.getChildren().add(_player_4);

      _board.getChildren().add(btn);
//      _board.getChildren().add(_initial);
//      _board.getChildren().add(_dog);
//      _board.getChildren().add(_player_1);
//      _board.getChildren().add(_player_2);
//      _board.getChildren().add(_player_3);
//      _board.getChildren().add(_player_4);
      root.getChildren().add(_layout);

//      CardModel cartemodele = new CardModel(COLOR.CLUB, 5);
//      try {
//	 CardView carte = new CardView(cartemodele, CARDS_DIRECTORY);
//	 _board.getChildren().add(carte);
//      } catch (NoCards ex) {
//	 Logger.getLogger(BoardView.class.getName()).log(Level.SEVERE, null, ex);
//      }
      root.getChildren().add(_board);
      Scene scene = new Scene(root, 800, 600);

      primaryStage.setTitle("Hello World!");
      primaryStage.setScene(scene);
      primaryStage.sizeToScene();
      scene.getStylesheets().add(BoardView.class.getResource("style.css").toExternalForm());
      _initial.flip();
      distribute();
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
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   public void distribute () {
      while (!_initial.getChildren().isEmpty()) {
	 for (int i = 1; i < 5; i++) {
	    DeckView deck = (DeckView) _layout.getChildren().get(i);
	    for (int c = 0; c < 3; c++) {
	       _initial.give(_initial.getChild(1), deck);
	    }
	 }
	 _initial.give(_initial.getChild(1), _dog);
      }
   }
}
