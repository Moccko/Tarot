/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.CardModel;
import static View.ORIENTATION.*;
import java.util.*;
import javafx.scene.image.*;

/**
 *
 * @author Roman
 */
public class CardView extends ImageView implements Observer {

   static private int count = 1;
   private final Image _image_front;
   private CardModel _model;
   private ORIENTATION _orientation;

   public CardView ( CardModel card, String path, ORIENTATION orientation ) {
//      super(new Image());
      Image img = new Image("file:" + path + "BACK.jpg");
      setImage(img);
      this._model = card;
      _image_front = new Image("file:" + path + card.getColor() + "_" + card.getValue() + ".jpg");
      _orientation = orientation;
      if (orientation == HORIZONTAL) {
	 setRotate(90.0d);
      }

      setCache(true);
      _model.addObserver(this);
      count++;
   }

   @Override
   public void update ( Observable o, Object arg ) {
      flip();
   }

   public void flip () {
      setImage(_image_front);
   }

   private void rotate ( ORIENTATION orientation ) {
      if (orientation != _orientation) {
	 _orientation = orientation;
	 setRotate(90.0d);
      }
   }

   public CardModel getModel () {
      return _model;
   }
}
