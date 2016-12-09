/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.COLOR.EXCUSE;
import java.util.Observable;

/**
 *
 * @author Roman
 */
public class CardModel extends Observable implements Comparable<CardModel> {

   private final COLOR _color;
   private final Integer _value;
   private final int _order;
   private Boolean _visible;
   private static int _nb_cards = 0;
   private int _index;

   /**
    * Constructs a card with a specified value and a position in the deck
    *
    * @param _color : the color in the COLOR enum
    * @param _value : the value of the card (between 1 (ace) and 14 (king))
    * @param index  : the position in the deck
    */
   public CardModel ( COLOR _color, int _value, int index ) {
      super();
      this._color = _color;
      this._value = _value;
      _visible = false;
      _order = _nb_cards++; // to sort the cards an order is created because the cards are initialized in a good order
      _index = index;
   }

   /**
    * Constructs the card of the Excuse (the 22nd trump)
    *
    * @param index : the position in the deck
    */
   public CardModel ( int index ) {
      this._color = EXCUSE;
      _value = 0;
      _order = _nb_cards++;
      _index = index;
   }

   public COLOR getColor () {
      return _color;
   }

   public int getValue () {
      return _value;
   }

   public final int getOrder () {
      return _order;
   }

   public void setVisible () {
      _visible = true;
      setChanged();
      notifyObservers();
   }

   public int getIndex () {
      return _index;
   }

   public void setIndex ( int _index ) {
      this._index = _index;
   }

   /**
    * This method makes the cards sortable
    *
    * @param o : the card compared with this card
    *
    * @return : an order
    */
   @Override
   public int compareTo ( CardModel o ) {
      return Integer.compare(this._order, o.getOrder());
   }

}
