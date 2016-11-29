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
public class CardModel extends Observable {

   private final COLOR _color;
   private int _value;
   private Boolean _visible;

   public CardModel ( COLOR _color, int _value ) {
      super();
      this._color = _color;
      this._value = _value;
      _visible = false;
   }

   public CardModel () {
      this._color = EXCUSE;
   }

   public COLOR getColor () {
      return _color;
   }

   public int getValue () {
      return _value;
   }

   public void setVisible () {
      _visible = true;
      setChanged();
      notifyObservers();
   }

}
