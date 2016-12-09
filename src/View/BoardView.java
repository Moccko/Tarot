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
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.*;

/**
 *
 * @author Roman
 */
public class BoardView extends Application implements Observer {

   private Group _root, _board;
   private double _width;
   private DeckView _initial, _dog, _player_1, _player_2, _player_3, _player_4;
   private ArrayList<DeckView> _decks;
   private BorderPane _layout;

   private CardView _try_card;

   @Override
   public void start ( Stage primaryStage ) throws InterruptedException {

      _root = new Group();
      _board = new Group();
      Scene scene = new Scene(_board, 1200, 650);

      BoardModel _model = new BoardModel();
      BoardController _controller = new BoardController(_model);
      _model.addObserver(this);

      _width = primaryStage.getWidth();

      _initial = new DeckView(_model.getInitial_deck(), _controller.getInitial_deck(), 200, 100, _width, ORIENTATION.VERTICAL);
      _dog = new DeckView(_model.getDog(), _controller.getDog(), 550, 250, _width, ORIENTATION.VERTICAL);
      _player_1 = new DeckView(_model.getPlayer_1(), _controller.getPlayer_1(), 550, 500, _width, ORIENTATION.VERTICAL);
      _player_2 = new DeckView(_model.getPlayer_2(), _controller.getPlayer_2(), 0, 250, _width, ORIENTATION.HORIZONTAL);
      _player_3 = new DeckView(_model.getPlayer_3(), _controller.getPlayer_3(), 550, 0, _width, ORIENTATION.VERTICAL);
      _player_4 = new DeckView(_model.getPlayer_4(), _controller.getPlayer_4(), 1100, 250, _width, ORIENTATION.HORIZONTAL);

      _decks = new ArrayList<>();
      _decks.add(_player_1);
      _decks.add(_player_2);
      _decks.add(_player_3);
      _decks.add(_player_4);

      Button _distribute = new Button("Distribute !");
      _distribute.setOnAction(( ActionEvent event ) -> {
	 _initial.distribute(_decks, _dog);
      });

//      Button _flip = new Button("Flip !");
//      _flip.setOnAction(( event ) -> {
//	 _player_1.flip();
//	 _dog.flip();
//	 _try_card.flip();
//      });
      _initial.setRoot(_board);
      _board.getChildren().add(_distribute);
//      _root.getChildren().add(_flip);

      primaryStage.setTitle("Tarot Rieunier Zeferino S3A");
      primaryStage.setScene(scene);
      primaryStage.sizeToScene();
      scene.getStylesheets().add(BoardView.class.getResource("style.css").toExternalForm());
      primaryStage.show();
   }

   public static void main ( String[] args ) {
      launch(args);
   }

   @Override
   public void update ( Observable o, Object arg ) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

}
