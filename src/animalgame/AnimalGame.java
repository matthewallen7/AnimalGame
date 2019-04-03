/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalgame;

import java.util.Scanner;

/**
 *
 * @author matth
 */
public class AnimalGame {

    /**
     * @param args the command line arguments
     */
    private static Scanner scanner = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BTree<String> rootnode;
        introduction();
        rootnode = TreeDriver.initial();
        do{
            playGame(rootnode);
        }
        while (input("Shall we play again?"));
        System.out.println("Thank you for playing!");
    }
      
    //Introduction for the game
    public static void introduction()
    {
     System.out.println("Think of an animal.");
     System.out.println("Ok. I will ask a series of yes / no questions to guess what you are");
    }
    
  public static void playGame(BTree<String> currentGame)
  {
   while (!currentGame.isLeaf())
   {
     if (input(currentGame.getData()))
      currentGame = currentGame.getLeft();
     else
      currentGame = currentGame.getRight();
   }
 
   System.out.print("You are a " + currentGame.getData() + ". ");
   if (!input("Am I Correct?"))
     AddAnimal(currentGame);
   else
     System.out.println("I'm just too good!");
  }
  
  public static void AddAnimal(BTree<String> current)
  {
   String guessA;   
   String correctA; 
   String newQ;   
   
   guessA = current.getData( );
   System.out.println("I give up. What are you? ");
   correctA = scanner.nextLine( );
   System.out.println("Writer a yes/no question that will tell me the difference");
   System.out.println(correctA + " from a " + guessA + ".");
   newQ = scanner.nextLine( );
   
   current.setData(newQ);
   System.out.println("As a " + correctA + ", " + newQ);
   if (input("Please answer"))
   {
     current.setLeft(new BTree<String>(correctA, null, null));
     current.setRight(new BTree<String>(guessA, null, null));
   }
   else
   {
     current.setLeft(new BTree<String>(guessA, null, null));
     current.setRight(new BTree<String>(correctA, null, null));
   }         
  }
 
  public static boolean input(String message)
  {
   String answer;
 
   System.out.print(message + " [Y / N]: ");
   answer = scanner.nextLine().toUpperCase();
   while (!answer.startsWith("Y") && !answer.startsWith("N"))
   {
  System.out.print("Please type Y / N ");
  answer = scanner.nextLine().toUpperCase();
   }
   return answer.startsWith("Y");
  }
}
