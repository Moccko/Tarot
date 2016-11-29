/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.CardModel;
import java.util.*;
import javafx.scene.image.*;

/**
 *
 * @author Roman
 */
public class CardView extends ImageView implements Observer {

   private final Image _image_front;
   private CardModel _model;

   public CardView ( CardModel card, String path ) {
      super(new Image("file:" + path + "BACK.jpg"));
      this._model = card;
      _image_front = new Image("file:" + path + card.getColor() + "_" + card.getValue() + ".jpg");
      setCache(true);
      _model.addObserver(this);
   }

   @Override
   public void update ( Observable o, Object arg ) {
      
   }

   private void flip () {
      setImage(_image_front);
   }
}
