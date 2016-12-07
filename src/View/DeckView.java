/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controler.DeckController;
import Model.*;
import java.util.*;
import javafx.animation.*;
import javafx.event.*;
import javafx.scene.Group;
import javafx.util.Duration;

/**
 *
 * @author Roman
 */
public class DeckView extends ArrayList<CardView> implements Observer {

   private final DeckModel _model;
   private final DeckController _controller;
   private final double _x, _y;
   private final ORIENTATION _orientation;
   private boolean _finished;

   public DeckView ( DeckModel deck, DeckController controller, double x, double y, ORIENTATION orientation ) {
      super();
      _model = deck;
      _controller = controller;
      _x = x;
      _y = y;
      _orientation = orientation;
//      getChildren().clear();
      _model.getCards().forEach(( card ) -> {
	 add(new CardView(card, orientation));
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
      switch (_orientation) {
	 case VERTICAL:
	    int cpt = -360;
	    for (CardView card : this) {
	       TranslateTransition tt = new TranslateTransition(Duration.seconds(1), card);
	       tt.setToX(getX() + cpt);
	       cpt += 40;
	       tt.play();
	    }
	    break;
	 case HORIZONTAL:
	    cpt = -90;
	    for (CardView card : this) {
	       TranslateTransition tt = new TranslateTransition(Duration.seconds(1), card);
	       tt.setToY(getY() + cpt);
	       cpt += 10;
	       tt.play();
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
      SequentialTransition st = new SequentialTransition();
      this.forEach(( card ) -> {
//	 carte.toFront();
	 st.getChildren().add(card.flip());
      });
      st.setCycleCount(1);
      st.play();
   }

   public TranslateTransition give ( CardView card, DeckView deck ) {
      _controller.give(card.getModel(), deck.getModel());
      card.rotate(deck.getOrientation());
      this.remove(card);

      TranslateTransition tt = new TranslateTransition(new Duration(100), card);
      tt.setToX(deck.getX());
      tt.setToY(deck.getY());
      deck.add(card);
      return tt;
   }

   public CardView getChild ( int i ) {
      return get(i);
   }

   public CardView getLastChild () {
      return getChild(this.size() - 1);
   }

   public ORIENTATION getOrientation () {
      return _orientation;
   }

   public double getX () {
      return _x;
   }

   public double getY () {
      return _y;
   }

   public void setRoot ( Group stack ) {
      this.forEach(( card ) -> {
	 stack.getChildren().add(card);
      });
   }

   public void setFinished ( boolean _finished ) {
      this._finished = _finished;
   }

   public synchronized void distribute ( Collection<DeckView> decks, DeckView dog ) {
      SequentialTransition st = new SequentialTransition();
      while (!this.isEmpty()) {
	 decks.forEach(( deck ) -> {
	    for (int c = 0; c < 3; c++) {
	       st.getChildren().add(this.give(this.get(0), deck));
	    }
	 });
	 st.getChildren().add(this.give(this.get(0), dog));
      }
      st.play();
      st.setOnFinished(( ActionEvent event ) -> {
	 decks.forEach(( deck ) -> {
	    deck.spread();
	 });
      });
   }
}
