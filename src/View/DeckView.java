/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DeckController;
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
   private final double _size_max;

   public DeckView ( DeckModel deck, DeckController controller, double x, double y, double w, ORIENTATION orientation ) {
      super();
      _model = deck;
      _controller = controller;
      _x = x;
      _y = y;
      _orientation = orientation;
//      getChildren().clear();
      _model.getCards().forEach(( card ) -> {
	 add(new CardView(card, orientation));
      });
      _size_max = 4 * w / _model.getCards().size(); // the deck occupies 80% of the screen width
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

   public void spread ( int i ) {
//      int height = 0;
      sort();
      ParallelTransition pt = new ParallelTransition();
      int cpt;
//      switch (_orientation) {
//	 case VERTICAL:
      cpt = -(this.size() - 1) / 2 * 60; // we center the cards
      for (CardView card : this) {
	 TranslateTransition tt = new TranslateTransition(Duration.seconds(1), card);
	 tt.setToX(getX() + cpt);
	 cpt += 60;
	 pt.getChildren().add(tt);
	 card.toBack();
      }
//	    break;
//	 case HORIZONTAL:
//	    cpt = -90;
//	    for (CardView card : this) {
//	       TranslateTransition tt = new TranslateTransition(Duration.seconds(1), card);
//	       tt.setToY(getY() + cpt);
//	       cpt += 10;
//	       pt.getChildren().add(tt);
//	       card.toBack();
//	    }
//	    break;
//      }
      if (i == 1) {
	 pt.setOnFinished(( event ) -> {
	    flip();
//	 reset();
	 });
	 pt.play();
      }

   }

   private void shuffle () {
      _controller.shuffle();
   }

   private void sort () {
      this.sort(( CardView o1, CardView o2 ) -> Integer.compare(o1.getModel().getIndex(), o2.getModel().getIndex()));
      _controller.sort();
   }

   private void flip () {
      SequentialTransition st = new SequentialTransition();
      this.forEach(( card ) -> {
//	 carte.toFront();
	 st.getChildren().add(card.flip());
      });
      st.setCycleCount(1);
      st.play();
   }

   private TranslateTransition give ( CardView card, DeckView deck ) {
      _controller.give(card.getModel(), deck.getModel());
      card.rotate(deck.getOrientation());
      this.remove(card);

      TranslateTransition tt = new TranslateTransition(new Duration(100), card);
      tt.setToX(deck.getX());
      tt.setToY(deck.getY());
      deck.add(card);
      return tt;
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

   public void distribute ( ArrayList<DeckView> decks, DeckView dog ) {
      SequentialTransition st = new SequentialTransition();
      while (!this.isEmpty()) {
	 decks.forEach(( deck ) -> {
	    for (int card = 0; card < 3; card++) {
	       st.getChildren().add(this.give(this.get(0), deck));
	    }
	 });
	 st.getChildren().add(this.give(this.get(0), dog));
      }
      st.play();
      st.setOnFinished(( event ) -> {
	 int c = 1;
	 for (DeckView deck : decks) {
	    deck.spread(c++);
	 }
	 dog.spread(1);
	 decks.get(0).activateDragnDrop(true);
	 dog.activateDragnDrop(false);

      });
   }

   public void reset () {
      this.sort(( CardView o1, CardView o2 ) -> Integer.compare(o1.getModel().getIndex(), o2.getModel().getIndex()));
//      fastSort(1, this.size() - 1);
//      int cpt = -1 * (this.size() / 2);
//      switch (_orientation) {
//	 case VERTICAL:
//	    for (CardView card : this) {
//	       Timeline tl = new Timeline(new KeyFrame(new Duration(100), new KeyValue(card.xProperty(), this._x + cpt * 50)));
//	       tl.play();
//	       cpt++;
//	    }
//	    break;
//	 case HORIZONTAL:
//	    for (CardView card : this) {
//	       Timeline tl = new Timeline(new KeyFrame(new Duration(50), new KeyValue(card.yProperty(), this._y + cpt * 50)));
//	       tl.play();
//	       cpt++;
//	    }
//	    break;
//      }
   }

   public void activateDragnDrop ( boolean player ) {

      this.forEach(( card ) -> {
	 System.out.println(card.getModel().getValue());
	 if (!player || (player && (card.getModel().getColor() != COLOR.EXCUSE || card.getModel().getValue() != 14))) { // the player can't give the excuse or a king
	    card.setOnMousePressed(( event ) -> {
	       card.setX(event.getX() - 50);
	       card.setY(event.getY() - 50);
	    });
	    card.setOnMouseDragged(( event ) -> {
	       card.setX(event.getX() - 50);
	       card.setY(event.getY() - 50);
	    });

	    card.setOnMouseReleased(( event ) -> {
	       /*
	        * if (card.get)>10)
	        * {
	        * //reset();
	        * }
	        */
	    });
	 }
      });
   }

}
