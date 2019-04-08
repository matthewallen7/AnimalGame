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
   BTree<String> child5;
   BTree<String> child6;
   BTree<String> child7;
 
   final String ROOT_QUESTION = "Are you a mammal?";
   final String LEFTQ1 = "Are you well known for racing?";
   final String LEFTQ2 = "Do you have big teeth?";
   final String RIGHTQ1 = "Do you live underwater?";
   final String RIGHTQ2 = "Are you an Arachnid?";
   final String RIGHTQ3 = "Do you have big eyes?";
   final String RIGHTQ4 = "Do you quack?";
   final String RIGHTQ5 = "Do you live in the cold?";
   final String Horse = "Horse";
   final String Goldfish = "Goldfish";
   final String Spider = "Spider";
   final String Duck = "Duck";
   final String Owl = "Owl";
   final String Lion = "Lion";
   final String Penquin = "Penquin";
   final String Frog = "Frog";
  
   // Create the root node with the question ?Are you a mammal??
   root = new BTree<String>(ROOT_QUESTION, null, null);
 
   // Create and attach the left subtree.
   child1 = new BTree<String>(LEFTQ1, null, null);
   child1.setLeft(new BTree<String>(Horse, null, null));
   root.setLeft(child1);
   
   child7 = new BTree<String>(LEFTQ2, null, null);
   child7.setLeft(new BTree<String>(Lion, null, null));
   child1.setRight(child7);
   
   // Create and attach the right subtree.
   child2 = new BTree<String>(RIGHTQ1, null, null);
   child2.setLeft(new BTree<String>(Goldfish, null, null));
   root.setRight(child2);
   
   child3 = new BTree<String>(RIGHTQ2, null, null);
   child3.setLeft(new BTree<String>(Spider, null, null));
   child2.setRight(child3);
   
   child4 = new BTree<String>(RIGHTQ3, null, null);
   child4.setLeft(new BTree<String>(Owl, null, null));
   child3.setRight(child4);
   
   child5 = new BTree<String>(RIGHTQ4, null, null);
   child5.setLeft(new BTree<String>(Duck, null, null));
   child4.setRight(child5);  
   
   child6 = new BTree<String>(RIGHTQ5, null, null);
   child6.setLeft(new BTree<String>(Penquin, null, null));
   child5.setRight(child6);
 
   return root;
  }
}
