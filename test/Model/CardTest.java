/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import static Model.COLOR.*;

/**
 *
 * @author mzeferino
 */
public class CardTest {
    
    public CardTest() {
    }
    
   
    /**
     * Test of getColor method, of class Card.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        Card instance = new Card(COLOR.SPADE,2);
        COLOR expResult = COLOR.SPADE;
        COLOR result = instance.getColor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValue method, of class Card.
     */
    @Test
    public void testGetValue() {
         System.out.println("getValue");
        Card instance = new Card(COLOR.SPADE,2);
        int expResult = 2;
        int result = instance.getValue();
        assertEquals(expResult, result);
    }
    
}
