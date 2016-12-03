/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controler.*;
import Model.*;
import java.util.*;
import java.util.logging.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
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
   private ArrayList<DeckView> _decks;
   private BorderPane _layout;

   @Override
   public void start ( Stage primaryStage ) throws InterruptedException {
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

      _decks = new ArrayList<>();
      _decks.add(_player_1);
      _decks.add(_player_2);
      _decks.add(_player_3);
      _decks.add(_player_4);

      Button btn = new Button();
      btn.setText("Say 'Hello World'");
      btn.setOnAction(( ActionEvent event ) -> {
	 distribute();
      });

      StackPane root = new StackPane();
      Group _board = new Group();

      _layout = new BorderPane(_dog);

      _layout.getChildren().add(_initial);
      _layout.setBottom(_player_1);
      _layout.setLeft(_player_2);
      _layout.setTop(_player_3);
      _layout.setRight(_player_4);

      BorderPane.setAlignment(_player_1, Pos.BOTTOM_CENTER);
      BorderPane.setAlignment(_player_2, Pos.CENTER_LEFT);
      BorderPane.setAlignment(_player_3, Pos.TOP_CENTER);
      BorderPane.setAlignment(_player_4, Pos.CENTER_RIGHT);

      _board.getChildren().add(btn);
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
      int cpt = 0;
      while (!_initial.getChildren().isEmpty()) {
	 for (DeckView deck : _decks) {
	    for (int c = 0; c < 3; c++) {
	       _initial.give(_initial.getChild(0), deck);
	       cpt++;
	       System.out.println(deck.getLastChild());
	    }
	 }
	 _initial.give(_initial.getChild(0), _dog);
	 cpt++;
	 System.out.println(_dog.getLastChild());

      }
   }
}
