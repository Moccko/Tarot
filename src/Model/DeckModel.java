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
public class DeckModel extends Observable {

   private LinkedList<CardModel> _cards;
   private final int _x, _y;
   private Boolean _spread;

   public DeckModel ( int x, int y ) {
      super();
      _cards = new LinkedList<>();
      _x = x;
      _y = x;
      _spread = false;
   }

   public DeckModel ( Collection<CardModel> c, int x, int y ) {
      super();
      _cards = new LinkedList<>(c);
      Collections.shuffle(_cards);
      _x = x;
      _y = y;
   }

   public void giveCard ( CardModel toGive, DeckModel deck ) {
      deck.getCards().add(toGive);
      setChanged();
      notifyObservers();
   }

   public int getX () {
      return _x;
   }

   public int getY () {
      return _y;
   }

   public LinkedList<CardModel> getCards () {
      return _cards;
   }

   void add ( CardModel card ) {
      _cards.add(card);
   }

   void setSpread () {
      _spread = true;
      setChanged();
      notifyObservers();
   }

   void spread () {
//      @TODO
   }
}
