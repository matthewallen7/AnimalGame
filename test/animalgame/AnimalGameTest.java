/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalgame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author matth
 */
public class AnimalGameTest {
    
    public AnimalGameTest() {
    }   

    /**
     * Test of main method, of class AnimalGame.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        AnimalGame.main(args);
        fail("Failed");
    }

    /**
     * Test of introduction method, of class AnimalGame.
     */
    @Test
    public void testIntroduction() {
        System.out.println("introduction");
        boolean expResult = false;
        int result = AnimalGame.introduction();
        if (result >= 0) {
            expResult = true;
           assertEquals(expResult, result);
        }
        fail("Please input a valid number");
    }

    @Test
    public void testInput() {
        System.out.println("input");
        String message = "";
        boolean expResult = false;
        boolean result = AnimalGame.input(message);
        assertEquals(expResult, result);
        fail("Failed.");
    }

    /**
     * Test of continueMain method, of class AnimalGame.
     */
    @Test
    public void testContinueMain() {
        System.out.println("continueMain");
        String message = "";
        boolean expResult = false;
        boolean result = AnimalGame.continueMain(message);
        assertEquals(expResult, result);
        fail("Failed.");
    }
    
}
