/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mzeferino
 */
public class DeckModelTest {

   /**
    * Test of add method, of class DeckModel, when the cards are the same
    */
   @Test
   public void testAdd () {
      CardModel cardExpected = new CardModel(COLOR.SPADE, 2, 2);
      DeckModel instance = new DeckModel(10, 10);
      instance.add(cardExpected);
      CardModel card = new CardModel(50);
      card = instance.getCards().get(0);
      assertEquals(cardExpected, card);
   }

}
