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
public class BTreeTest {
    
    public BTreeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setData method, of class BTree.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        String data = "";
        BTree instance = null;
        instance.setData(data);
        fail("Failed");
    }

    /**
     * Test of getLeft method, of class BTree.
     */
    @Test
    public void testGetLeft() {
        System.out.println("getLeft");
        BTree instance = null;
        BTree expResult = null;
        BTree result = instance.getLeft();
        assertEquals(expResult, result);
        fail("Failed");
    }

    /**
     * Test of setLeft method, of class BTree.
     */
    @Test
    public void testSetLeft() {
        System.out.println("setLeft");
        BTree left = null;
        BTree instance = null;
        instance.setLeft(left);
        fail("Failed");
    }

    /**
     * Test of getRight method, of class BTree.
     */
    @Test
    public void testGetRight() {
        System.out.println("getRight");
        BTree instance = null;
        BTree expResult = null;
        BTree result = instance.getRight();
        assertEquals(expResult, result);
        fail("Failed");
    }

    /**
     * Test of setRight method, of class BTree.
     */
    @Test
    public void testSetRight() {
        System.out.println("setRight");
        BTree right = null;
        BTree instance = null;
        instance.setRight(right);
        fail("Failed");
    }

    /**
     * Test of isLeaf method, of class BTree.
     */
    @Test
    public void testIsLeaf() {
        System.out.println("isLeaf");
        BTree instance = null;
        boolean expResult = false;
        boolean result = instance.isLeaf();
        assertEquals(expResult, result);
        fail("Failed");
    }

    /**
     * Test of printPreorder method, of class BTree.
     */
    @Test
    public void testPrintPreorder() {
        System.out.println("printPreorder");
        BTree node = null;
        BTree instance = null;
        instance.printPreorder(node);
        fail("Failed");
    }

    /**
     * Test of printPostorder method, of class BTree.
     */
    @Test
    public void testPrintPostorder() {
        System.out.println("printPostorder");
        BTree node = null;
        BTree instance = null;
        instance.printPostorder(node);
        fail("Failed");
    }

    /**
     * Test of printInorder method, of class BTree.
     */
    @Test
    public void testPrintInorder() {
        System.out.println("printInorder");
        BTree node = null;
        BTree instance = null;
        instance.printInorder(node);
        fail("Failed");
    }

    /**
     * Test of print method, of class BTree.
     */
    @Test
    public void testPrint_0args() {
        System.out.println("print");
        BTree instance = null;
        String expResult = "";
        String result = instance.print();
        assertEquals(expResult, result);
        fail("Failed");
    }

    /**
     * Test of print method, of class BTree.
     */
    @Test
    public void testPrint_3args() {
        System.out.println("print");
        String prefix = "";
        boolean isTail = false;
        String sb = "";
        BTree instance = null;
        String expResult = "";
        String result = instance.print(prefix, isTail, sb);
        assertEquals(expResult, result);
        fail("Failed");
    }
    
}
