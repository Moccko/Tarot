/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.ROLE.*;
import java.util.*;

/**
 *
 * @author Roman
 */
public class DeckModel extends Observable {

   private ArrayList<CardModel> _cards;
   private Boolean _spread;
   private final double _x, _y;
   private ROLE _role;

   /**
    * Constructs a deck with a relative position
    *
    * @param x : absciss
    * @param y : ordinate
    */
   public DeckModel ( int x, int y ) {
      super();
      _cards = new ArrayList<>();
      _spread = false;
      _x = x;
      _y = y;
      _role = NONE;
   }

   /**
    * Shuffle the cards that contains the deck
    */
   public void shuffle () {
      Collections.shuffle(_cards);
      setChanged();
      notifyObservers();
   }

   /**
    * Sort the deck and attributes new indexes to each card
    */
   public void sort () {
      Collections.sort(_cards);
      int index = 1;
      for (CardModel card : _cards) {
	 card.setIndex(index++);
      }
      setChanged();
      notifyObservers();
   }

   /**
    * Move a card from the deck to another
    *
    * @param toGive : the card to give
    * @param deck   : the deck which will receive the card
    */
   public void giveCard ( CardModel toGive, DeckModel deck ) {
      deck.getCards().add(toGive);
      _role = SENDER;
      deck.setRole(RECEIVER);
      setChanged();
      notifyObservers(toGive);
   }

   public ROLE getRole () {
      return _role;
   }

   public void setRole ( ROLE _role ) {
      this._role = _role;
   }

   public ArrayList<CardModel> getCards () {
      return _cards;
   }

   /**
    * Add a card to the deck
    *
    * @param card : the card to add
    */
   public void add ( CardModel card ) {
      _cards.add(card);
   }

   public void setSpread () {
      _spread = true;
      setChanged();
      notifyObservers();
   }

   /**
    * Counts the trumps in the deck, the counter is decremented if the deck
    * contains the Petit Sec and incremented if there's a trump other that the
    * Petit Sec. If it's less than 0 that means that the only trump
    * in the deck is the Petit Sec
    *
    * @return wether or not the Petit Sec is the only trump in the deck
    */
   public boolean onlyPetitSec () {
      int cpt = 0;
      for (CardModel card : _cards) {
	 if (card.getColor() == COLOR.TRUMP) {
	    if (card.getValue() == 1) {
	       cpt--;
	    } else {
	       cpt++;
	    }
	 }
      }
      return cpt < 0;
   }

}
