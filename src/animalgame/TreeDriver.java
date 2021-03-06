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
    
    /**
     *
     * @return
     */
    public static BTree initial( )   
  {
   //make nodes for binary tree.
   BTree root;
   BTree child1;
   BTree child2;
   BTree child3;
   BTree child4;
   BTree child5;
   BTree child6;
   BTree child7;
 
   //Questions for the user.
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
  
   // Create the root node with the question.
   root = new BTree(ROOT_QUESTION, null, null);
 
   // Create and attach the left subtree.
   child1 = new BTree(LEFTQ1, null, null);
   child1.setLeft(new BTree(Horse, null, null));
   root.setLeft(child1);
   
   child7 = new BTree(LEFTQ2, null, null);
   child7.setLeft(new BTree(Lion, null, null));
   child1.setRight(child7);
   
   // Create and attach the right subtree.
   child2 = new BTree(RIGHTQ1, null, null);
   child2.setLeft(new BTree(Goldfish, null, null));
   root.setRight(child2);
   
   child3 = new BTree(RIGHTQ2, null, null);
   child3.setLeft(new BTree(Spider, null, null));
   child2.setRight(child3);
   
   child4 = new BTree(RIGHTQ3, null, null);
   child4.setLeft(new BTree(Owl, null, null));
   child3.setRight(child4);
   
   child5 = new BTree(RIGHTQ4, null, null);
   child5.setLeft(new BTree(Duck, null, null));
   child4.setRight(child5);  
   
   child6 = new BTree(RIGHTQ5, null, null);
   child6.setLeft(new BTree(Penquin, null, null));
   child5.setRight(child6);
 
   return root;
  }
}
