/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.CardModel;
import static View.ORIENTATION.*;
import java.util.*;
import javafx.animation.*;
import javafx.geometry.Point3D;
import javafx.scene.image.*;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author Roman
 */
public class CardView extends ImageView implements Observer {

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
	 setRotate(90);
      }

      setCache(true);
      _model.addObserver(this);
   }

   @Override
   public void update ( Observable o, Object arg ) {
      flip();
   }

   public void flip () {

      this.setRotationAxis(Rotate.X_AXIS);
      Timeline tl = new Timeline(
	      new KeyFrame(new Duration(1000), new KeyValue(this.rotateProperty(), 90)),
	      new KeyFrame(new Duration(1000), new KeyValue(this.imageProperty(), _image_front)),
	      new KeyFrame(new Duration(2000), new KeyValue(this.rotateProperty(), 0)));

      tl.play();
   }

   public void rotate ( ORIENTATION orientation ) {
      if (orientation != _orientation) {

	 this.setRotationAxis(Rotate.Z_AXIS);
	 Timeline tl = new Timeline(new KeyFrame(new Duration(500), new KeyValue(this.rotateProperty(), 90)));

	 tl.play();

	 _orientation = orientation;
	 setRotate(90.0d);
      }
   }

   public CardModel getModel () {
      return _model;
   }

   public Image getImage_front () {
      return _image_front;
   }

   @Override
   public String toString () {
      return _model.getColor() + String.valueOf(_model.getValue()) + ", _orientation=" + _orientation + '}';
   }

}
