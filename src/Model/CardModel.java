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
   private Boolean _visible;
   private static int _nb_cards = 0;
   private final int _order;

   public CardModel ( COLOR _color, int _value ) {
      super();
      this._color = _color;
      this._value = _value;
      _visible = false;
      _order = _nb_cards++;
   }

   public CardModel () {
      this._color = EXCUSE;
      _value = 0;
      _order = _nb_cards++;
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

   @Override
   public int compareTo ( CardModel o ) {
      return Integer.compare(this._order, o.getOrder());
   }

}
