/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Card;
import javafx.scene.image.*;

/**
 *
 * @author Roman
 */
public class CardView {

   private final Image _image_front, _image_back;
   private ImageView _card_front, _card_back;
   private final Card card;

   public CardView ( Card card, String path ) {
      this.card = card;
      _image_front = new Image("file:" + path + card.getColor() + "_" + card.getValue() + ".jpg");
      _image_back = new Image("file:" + path + "BACK.jpg");
      _card_front.setImage(_image_front);
      _card_back.setImage(_image_back);
   }

}
