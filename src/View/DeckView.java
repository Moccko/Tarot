/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controler.DeckControler;
import Model.*;
import java.util.*;
import javafx.scene.*;

/**
 *
 * @author Roman
 */
public class DeckView extends Group implements Observer {

   private final DeckModel _model;

   private final DeckControler _controler;
   private final String _path;
   private final ORIENTATION _orientation;

   public DeckView ( DeckModel deck, DeckControler controler, String path, ORIENTATION orientation ) {
      super();
      _model = deck;
      _controler = controler;
      _path = path;
      _orientation = orientation;
      getChildren().clear();
      deck.getCards().forEach(( card ) -> {
	 getChildren().add(new CardView(card, path, orientation));
      }
      );
      deck.addObserver(this);
   }

   @Override
   public void update ( Observable o, Object arg ) {
      _model.getCards().forEach(( card ) -> {
	 getChildren().clear();
	 getChildren().addAll(_model.getCards());
      });
   }

   public DeckModel getModel () {
      return _model;
   }

   public void spread () {
      switch (_orientation) {
	 case VERTICAL:
	    break;
	 case HORIZONTAL:
	    break;
      }
   }

   public void flip () {
      getChildren().forEach(( card ) -> {
	 CardView carte = (CardView) card;
	 carte.flip();
      });
   }

   public void give ( CardView card, DeckView deck ) {
      _controler.give(card.getModel(), deck.getModel());
   }

   public CardView getChild ( int i ) {
      return (CardView) getChildren().get(i);
   }
}
