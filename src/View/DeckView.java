/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.*;
import java.util.*;

/**
 *
 * @author Roman
 */
public class DeckView extends LinkedList<CardView> implements Observer {

   private final DeckModel _model;
   private final String _path;
   private final ORIENTATION _orientation;

   public DeckView ( DeckModel deck, String path, ORIENTATION orientation ) {
      super();
      _model = deck;
      _path = path;
      _orientation = orientation;
      deck.getCards().forEach(( card ) -> {
	 add(new CardView(card, path));
      });
      deck.addObserver(this);
   }

   @Override
   public void update ( Observable o, Object arg ) {
      _model.getCards().forEach(( card ) -> {
	 add(new CardView(card, _path));
      });
   }

   public void spread () {
      switch (_orientation) {
	 case VERTICAL:
	    break;
	 case HORIZONTAL:
	    break;
      }
   }
}
