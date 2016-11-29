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
public class CardView implements Observer {

   private Image _image_front, _image_back;
   private ImageView _card_view;
   private CardModel _model;

   public CardView ( CardModel card, String path ) {
      this._model = card;
      _image_front = new Image("file:" + path + card.getColor() + "_" + card.getValue() + ".jpg");
      _image_back = new Image("file:" + path + "BACK.jpg");
      _card_view = new ImageView(_image_front);
      _card_view.setCache(true);
      _model.addObserver(this);
   }

   @Override
   public void update ( Observable o, Object arg ) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

}
