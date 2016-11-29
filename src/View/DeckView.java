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
public class DeckView extends LinkedList<CardView> {

   private final DeckModel _deck;

   public DeckView ( DeckModel _deck, String path ) {
      super();
      this._deck = _deck;
      for (CardModel card : _deck.getCards()) {
	 add(new CardView(card, path));
      }
   }

}
