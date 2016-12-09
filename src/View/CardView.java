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
import javafx.scene.image.*;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author Roman
 */
public class CardView extends ImageView implements Observer {

   private final Image _image_front;
   private final CardModel _model;
   private ORIENTATION _orientation;

   private final String CARDS_DIRECTORY = "./resources/";

   public CardView ( CardModel card, ORIENTATION orientation ) {
//      super(new Image());
      Image img = new Image("file:" + CARDS_DIRECTORY + "BACK.jpg");
      setImage(img);
      this._model = card;
      _image_front = new Image("file:" + CARDS_DIRECTORY + card.getColor() + "_" + card.getValue() + ".jpg");
      _orientation = orientation;
      if (orientation == HORIZONTAL) {
	 setRotate(90);
      }

      setPreserveRatio(true);
      setFitWidth(100d);
      setCache(true);
      _model.addObserver(this);
   }

   @Override
   public void update ( Observable o, Object arg ) {
      flip();
   }

   public Timeline flip () {
//      RotateTransition rt = new RotateTransition(new Duration(150), this);
//      rt.setAxis(Rotate.X_AXIS);
//      rt.setToAngle(90);
//      this.setImage(_image_front);
//      rt.setToAngle(180);
      Timeline tl = new Timeline();
      this.setRotationAxis(Rotate.X_AXIS);
      tl.getKeyFrames().addAll(
	      new KeyFrame(new Duration(100), new KeyValue(this.rotateProperty(), 90)),
	      new KeyFrame(new Duration(100), new KeyValue(this.imageProperty(), _image_front)),
	      new KeyFrame(new Duration(200), new KeyValue(this.rotateProperty(), 0)));
      return tl;
//      return rt;
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

   public TranslateTransition move ( double x, double y /*
    * double move
    */ ) {
//      Timeline tl;
//      switch (_orientation) {
//	 case VERTICAL:
//	    tl = new Timeline(new KeyFrame(new Duration(100), new KeyValue(xProperty(), getX() + move)));
//	    break;
//	 default:
//	    tl = new Timeline(new KeyFrame(new Duration(100), new KeyValue(yProperty(), getY() + move)));
//	    break;
//      }
//      tl.play();
      TranslateTransition tt = new TranslateTransition(new Duration(50), this);
      tt.setToX(x);
      tt.setToY(y);
      return tt;
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
