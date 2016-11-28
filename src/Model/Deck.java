/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.*;

/**
 *
 * @author Roman
 */
public class Deck extends Observable {

   private LinkedList<Card> _cards;
   private final int _x, _y;

   public Deck ( int x, int y ) {
      super();
      _cards = new LinkedList<>();
      _x = x;
      _y = x;
   }

   public Deck ( Collection<Card> c, int x, int y ) {
      _cards = new LinkedList<>(c);
      _x = x;
      _y = y;
   }

   public Boolean giveCard ( Card toGive, Deck d ) {
      if (_cards.remove(toGive)) {
	 return (d.getCards().add(toGive));
      } else {
	 return false;
      }
   }

   public int getX () {
      return _x;
   }

   public int getY () {
      return _y;
   }

   public LinkedList<Card> getCards () {
      return _cards;
   }

   void add ( Card card ) {
      _cards.add(card);
   }
}
