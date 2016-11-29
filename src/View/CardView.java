/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.CardModel;
import javafx.scene.image.*;

/**
 *
 * @author Roman
 */
public class CardView {

   private Image _image_front, _image_back;
   private ImageView _card_view;
   private CardModel _card;

   public CardView ( CardModel card, String path ) {
      this._card = card;
      _image_front = new Image("file:" + path + card.getColor() + "_" + card.getValue() + ".jpg");
      _image_back = new Image("file:" + path + "BACK.jpg");
      _card_view = new ImageView(_image_front);
   }

}
