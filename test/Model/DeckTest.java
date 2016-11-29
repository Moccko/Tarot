/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.LinkedList.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mzeferino
 */
public class DeckTest {
    
    public DeckTest() {
    }
    
 
    /**
     * Test of giveCard method, of class Deck.
     */
    @Test
    public void testGiveCard() {
        System.out.println("giveCard");
        Card toGive = null;
        Deck d = null;
        Deck instance = null;
        Boolean expResult = null;
        Boolean result = instance.giveCard(toGive, d);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getX method, of class Deck.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Deck instance = null;
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getY method, of class Deck.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Deck instance = null;
        int expResult = 0;
        int result = instance.getY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCards method, of class Deck.
     */
  /*  @Test
    public void testGetCards() {
        System.out.println("getCards");
        Deck instance = null;
        LinkedList<Card> expResult = null;
        LinkedList<Card> result = instance.getCards();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Deck.
     */
    /*@Test
    public void testAdd() {
        System.out.println("add");
        Card card = new Card(COLOR.SPADE, 2);
        Card cardexp = null;
        Deck instance = new Deck (0,0);
        instance.add(card);
        assertEquals (instance._cards.getLast(), cardexp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
}
