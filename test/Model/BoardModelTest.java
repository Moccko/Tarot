/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author mzeferino
 */
public class BoardModelTest {

   /**
    * Test of getInitial_deck method, of class BoardModel.
    */
   @Test
   public void testGetInitial_deck () {
      System.out.println("getInitial_deck");
      BoardModel instance = new BoardModel();
      DeckModel expResult = null;
      DeckModel result = instance.getInitial_deck();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getDog method, of class BoardModel.
    */
   @Test
   public void testGetDog () {
      System.out.println("getDog");
      BoardModel instance = new BoardModel();
      DeckModel expResult = null;
      DeckModel result = instance.getDog();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getPlayer_1 method, of class BoardModel.
    */
   @Test
   public void testGetPlayer_1 () {
      System.out.println("getPlayer_1");
      BoardModel instance = new BoardModel();
      DeckModel expResult = null;
      DeckModel result = instance.getPlayer_1();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getPlayer_2 method, of class BoardModel.
    */
   @Test
   public void testGetPlayer_2 () {
      System.out.println("getPlayer_2");
      BoardModel instance = new BoardModel();
      DeckModel expResult = null;
      DeckModel result = instance.getPlayer_2();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getPlayer_3 method, of class BoardModel.
    */
   @Test
   public void testGetPlayer_3 () {
      System.out.println("getPlayer_3");
      BoardModel instance = new BoardModel();
      DeckModel expResult = null;
      DeckModel result = instance.getPlayer_3();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getPlayer_4 method, of class BoardModel.
    */
   @Test
   public void testGetPlayer_4 () {
      System.out.println("getPlayer_4");
      BoardModel instance = new BoardModel();
      DeckModel expResult = null;
      DeckModel result = instance.getPlayer_4();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

}
