/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalgame;

/**
 *
 * @author matth
 */
public class TreeDriver {
    
  public static BTree<String> initial( )   
  {
   BTree<String> root;
   BTree<String> child1;
   BTree<String> child2;
   BTree<String> child3;
   BTree<String> child4;
 
   final String ROOT_QUESTION = "Are you a mammal?";
   final String LEFT_QUESTION = "Are you well known for racing?";
   final String RIGHT_QUESTION = "Do you live underwater?";
   final String RIGHT_QUESTION1 = "Are you an Arachnid?";
   final String RIGHT_QUESTION3 = "Do you have big eyes?";
   final String ANIMAL1 = "Horse";
   final String ANIMAL2 = "Lion";
   final String ANIMAL3 = "Goldfish";
   final String ANIMAL4 = "Frog";
   final String ANIMAL5 = "Spider";
   final String ANIMAL6 = "Duck";
   final String ANIMAL7 = "Owl";
   final String ANIMAL8 = "Penquin";
  
   // Create the root node with the question ?Are you a mammal??
   root = new BTree<String>(ROOT_QUESTION, null, null);
 
   // Create and attach the left subtree.
   child1 = new BTree<String>(LEFT_QUESTION, null, null);
   child1.setLeft(new BTree<String>(ANIMAL1, null, null));
   child1.setRight(new BTree<String>(ANIMAL2, null, null));
   root.setLeft(child1);
 
   // Create and attach the right subtree.
   child2 = new BTree<String>(RIGHT_QUESTION, null, null);
   child2.setLeft(new BTree<String>(ANIMAL3, null, null));
   child2.setRight(new BTree<String>(ANIMAL4, null, null));
   root.setRight(child2);
   
   child3 = new BTree<String>(RIGHT_QUESTION1, null, null);
   child3.setLeft(new BTree<String>(ANIMAL5, null, null));
   child3.setRight(new BTree<String>(ANIMAL6, null, null));
   child2.setRight(child3);
   
   child4 = new BTree<String>(RIGHT_QUESTION3, null, null);
   child4.setLeft(new BTree<String>(ANIMAL7, null, null));
   child4.setRight(new BTree<String>(ANIMAL8, null, null));
   child3.setRight(child4);
 
   return root;
  }
}
