/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controler.DeckController;
import Model.*;
import java.util.*;
import javafx.animation.TranslateTransition;
import javafx.scene.*;
import javafx.util.Duration;

/**
 *
 * @author Roman
 */
public class DeckView extends Group implements Observer {

   private final DeckModel _model;

   private final DeckController _controller;
   private final String _path;
   private final ORIENTATION _orientation;

   public DeckView ( DeckModel deck, DeckController controller, String path, ORIENTATION orientation ) {
      super();
      _model = deck;
      _controller = controller;
      _path = path;
      _orientation = orientation;
//      getChildren().clear();
      _model.getCards().forEach(( card ) -> {
	 getChildren().add(new CardView(card, path, orientation));
      }
      );
      deck.addObserver(this);
   }

   @Override
   public void update ( Observable o, Object arg ) {
//      DeckModel model = (DeckModel) o;
//      if (arg != null) {
//	 switch (model.getRole()) {
//	    case RECEIVER:
//	       getChildren().add(new CardView((CardModel) arg, _path, _orientation));
//	       model.setRole(ROLE.NONE);
//	       break;
//	    case SENDER:
//	       for (int i = 0; i < getChildren().size() - 1; i++) {
//		  if (getChild(i).getModel() == (CardModel) arg) {
//		     getChildren().remove((CardView) getChild(i));
//		  }
//	       }
//	       model.setRole(ROLE.NONE);
//	       break;
//	    default:
//	       break;
//	 }
//      }

//      getChildren().clear();
//      _model.getCards().forEach(( card ) -> {
//	 // we check that a CardView child corresponds to a CardModel in the DeckModel
//
//	 getChildren().add(new CardView(card, _path, _orientation));
//      });
   }

   public DeckModel getModel () {
      return _model;
   }

   public void spread () {
      int cpt = -360;
      switch (_orientation) {
	 case VERTICAL:
	    for (Node card : getChildren()) {
	       CardView cardview = (CardView) card;
	       TranslateTransition tt = new TranslateTransition(Duration.seconds(1), cardview);
	       tt.setToX(cpt);
	       tt.play();
	       cpt += 40;
	    }
	    break;
	 case HORIZONTAL:
	    for (Node card : getChildren()) {
	       CardView cardview = (CardView) card;
	       TranslateTransition tt = new TranslateTransition(Duration.seconds(1), cardview);
	       tt.setToY(cpt);
	       tt.play();
	       cpt += 10;
	    }
	    break;
      }
   }

   public void shuffle () {
      _controller.shuffle();
   }

   public void sort () {
      _controller.sort();
   }

   public void flip () {
      getChildren().forEach(( card ) -> {
	 CardView carte = (CardView) card;
//	 carte.toFront();
	 carte.flip();
      });
   }

   public void give ( CardView card, DeckView deck ) {
      _controller.give(card.getModel(), deck.getModel());
      card.rotate(deck.getOrientation());

      TranslateTransition move = new TranslateTransition(Duration.millis(500), card);
      move.setToX(deck.getLayoutX());
      move.play();

      deck.getChildren().add(card);
      getChildren().remove(card);
   }

   public CardView getChild ( int i ) {
      return (CardView) getChildren().get(i);
   }

   public CardView getLastChild () {
      return getChild(getChildren().size() - 1);
   }

   public ORIENTATION getOrientation () {
      return _orientation;
   }
}
