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
     * Test of getData method, of class BTree.
     */
    @Test
    public void testGetData() {
        BTree node = new BTree();
        String actual = "testData";     
        node.setData(actual);   
        
        String expected = node.getData();
        
        assertEquals(actual, expected);
    }

    /**
     * Test of setData method, of class BTree.
     */
    @Test
    public void testSetData() {
        BTree node = new BTree();
        String actual = "testData";     
        node.setData(actual);   
        
        String expected = node.getData();
        
        assertEquals(actual, expected);
    }

    /**
     * Test of getLeft method, of class BTree.
     */
    @Test
    public void testGetLeft() {
        BTree node = new BTree();
        BTree left = new BTree();
        
        String actual = "testData";  
        
        left.data = actual;
        node.setLeft(left);   
        
        String expected = left.getData();
        
        assertEquals(actual, expected);
    }

    /**
     * Test of setLeft method, of class BTree.
     */
    @Test
    public void testSetLeft() {
        BTree node = new BTree();
        BTree left = new BTree();
        
        String actual = "testData";  
        
        left.data = actual;
        node.setLeft(left);   
        
        String expected = left.getData();
        
        assertEquals(actual, expected);
    }

    /**
     * Test of getRight method, of class BTree.
     */
    @Test
    public void testGetRight() {
        BTree node = new BTree();
        BTree right = new BTree();
        
        String actual = "testData";  
        
        right.data = actual;
        node.setRight(right);   
        
        String expected = right.getData();
        
        assertEquals(actual, expected);
    }

    /**
     * Test of setRight method, of class BTree.
     */
    @Test
    public void testSetRight() {
        BTree node = new BTree();
        BTree right = new BTree();
        
        String actual = "testData";  
        
        right.data = actual;
        node.setRight(right);   
        
        String expected = right.getData();
        
        assertEquals(actual, expected);
    }

    /**
     * Test of isLeaf method, of class BTree.
     */
    @Test
    public void testIsLeaf() {
        BTree t = new BTree();
        
        boolean actual = t.isLeaf();
        
        boolean expected = true;
        
        assertEquals(actual, expected);
              
    }  
}
