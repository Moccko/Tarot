/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Roman
 */
public class NoCards extends Exception {

   /**
    * Creates a new instance of <code>NoCards</code> without detail message.
    */
   public NoCards () {
   }

   /**
    * Constructs an instance of <code>NoCards</code> with the specified detail
    * message.
    *
    * @param msg the detail message.
    */
   public NoCards ( String msg ) {
      super(msg);
   }
}
