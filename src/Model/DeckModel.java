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
   private ROLE _role;

   public DeckModel () {
      super();
      _cards = new ArrayList<>();
      _spread = false;
      _role = NONE;
   }

   public void shuffle () {
      Collections.shuffle(_cards);
      setChanged();
      notifyObservers();
   }
   
   public void sort(){
      Collections.sort(_cards);
      setChanged();
      notifyObservers();
   }

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
