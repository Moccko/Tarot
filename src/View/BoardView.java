/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controler.*;
import Model.*;
import java.util.*;
import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Roman
 */
public class BoardView extends Application implements Observer {

   private Group _root;
   private DeckView _initial, _dog, _player_1, _player_2, _player_3, _player_4;
   private ArrayList<DeckView> _decks;
   private BorderPane _layout;

   private CardView _try_card;

   @Override
   public void start ( Stage primaryStage ) throws InterruptedException {
      BoardModel _model = new BoardModel();
      BoardController _controller = new BoardController(_model);
      _model.addObserver(this);

      _initial = new DeckView(_model.getInitial_deck(), _controller.getInitial_deck(), 200, 100, ORIENTATION.VERTICAL);
      _dog = new DeckView(_model.getDog(), _controller.getDog(), 400, 300, ORIENTATION.VERTICAL);
      _player_1 = new DeckView(_model.getPlayer_1(), _controller.getPlayer_1(), 400, 450, ORIENTATION.VERTICAL);
      _player_2 = new DeckView(_model.getPlayer_2(), _controller.getPlayer_2(), 0, 300, ORIENTATION.HORIZONTAL);
      _player_3 = new DeckView(_model.getPlayer_3(), _controller.getPlayer_3(), 400, 0, ORIENTATION.VERTICAL);
      _player_4 = new DeckView(_model.getPlayer_4(), _controller.getPlayer_4(), 800, 300, ORIENTATION.HORIZONTAL);

      _decks = new ArrayList<>();
      _decks.add(_player_1);
      _decks.add(_player_2);
      _decks.add(_player_3);
      _decks.add(_player_4);

      Button _distribute = new Button("Distribute !");
      _distribute.setOnAction(( ActionEvent event ) -> {
	 _initial.distribute(_decks, _dog);
      });

      Button _flip = new Button("Flip !");
      _flip.setOnAction(( event ) -> {
	 _decks.forEach(deck -> {
	    deck.spread();
	 });
	 _dog.spread();
	 _player_1.flip();
	 _dog.flip();
	 _try_card.flip();
      });

      _root = new Group();
      _initial.setRoot(_root);

//      _layout = new BorderPane(_dog);
//
//      _layout.getChildren().add(_initial);
//      _layout.setBottom(_player_1);
//      _layout.setLeft(_player_2);
//      _layout.setTop(_player_3);
//      _layout.setRight(_player_4);
//
//      BorderPane.setAlignment(_player_1, Pos.BOTTOM_CENTER);
//      BorderPane.setAlignment(_player_2, Pos.CENTER_LEFT);
//      BorderPane.setAlignment(_player_3, Pos.TOP_CENTER);
//      BorderPane.setAlignment(_player_4, Pos.CENTER_RIGHT);
      _root.getChildren().add(_distribute);
      _root.getChildren().add(_flip);
//      root.getChildren().add(_layout);

      CardModel cartemodele = new CardModel(COLOR.CLUB, 5);
      _try_card = new CardView(cartemodele, ORIENTATION.VERTICAL);
//      _root.getChildren().add(_try_card);
//      _try_card.flip();

//BorderPane border = new BorderPane();
//      carte.setRotationAxis(Rotate.X_AXIS);
//      Timeline tl = new Timeline(
//	      new KeyFrame(new Duration(1000), new KeyValue(carte.rotateProperty(), 90)),
//	      new KeyFrame(new Duration(1000), new KeyValue(carte.imageProperty(), carte.getImage_front())),
//	      new KeyFrame(new Duration(2000), new KeyValue(carte.rotateProperty(), 0)),
//	      new KeyFrame(new Duration(2000), new KeyValue(carte.rotationAxisProperty(), Rotate.Z_AXIS)),
//	      new KeyFrame(new Duration(2500), new KeyValue(border.getAlignment(carte), Pos.CENTER_RIGHT)),
//	      new KeyFrame(new Duration(3000), new KeyValue(carte.rotateProperty(), 90)));
//      tl.play();
      Scene scene = new Scene(_root, 800, 600);

      primaryStage.setTitle("Hello World!");
      primaryStage.setScene(scene);
      primaryStage.sizeToScene();
      scene.getStylesheets().add(BoardView.class.getResource("style.css").toExternalForm());
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

}
