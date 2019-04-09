/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalgame;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
/**
 *
 * @author matth
 */
public class AnimalGame {
    /**
     * @param args the command line arguments
     */
    SaveGame[] AnimalSave = new SaveGame[100];
    private static Scanner scanner = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BTree rootnode;
        rootnode = TreeDriver.initial();
        for(;;){
        int choice = introduction();
        if (choice == 1) 
        {
            do{
                
            playGame(rootnode);
            
            }          
            while (input("Shall we play again?"));
            System.out.println("Thank you for playing!");
        }
        }
    }
      
    //Introduction for the game
    public static int introduction()
    {
     System.out.println(" 1: Play the game " + " 2: Save game data " +  " 3: Load game data " +  " 4: Exit. ");  
     String choice = scanner.nextLine();
        if (choice.equals("1")) {
            System.out.println("Think of an animal.");
            System.out.println("Ok. I will ask a series of yes / no questions to guess what you are");
        }
        if (choice.equals("2")) {
            //Save data
        }
        //Fix Deserialize
        if (choice.equals("3")) {
            //Load data
        }
        if (choice.equals("4")) {
            System.exit(0);
        }
        return Integer.valueOf(choice);
    }
    
  public static void playGame(BTree currentGame)
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
  
  public static void AddAnimal(BTree current)
  {
   String guessA;   
   String correctA; 
   String newQ;   
   
   guessA = current.getData( );
   System.out.println("I give up. What are you? ");
   correctA = scanner.nextLine( );
   System.out.println("Write a yes/no question that will tell me the difference between a");
   System.out.println(correctA + " from a " + guessA + ".");
   newQ = scanner.nextLine( );
   
   current.setData(newQ);
   System.out.println("As a " + correctA + ", " + newQ);
   if (input("Please answer"))
   {
     current.setLeft(new BTree(correctA, null, null));
     current.setRight(new BTree(guessA, null, null));
   }
   else
   {
     current.setLeft(new BTree(guessA, null, null));
     current.setRight(new BTree(correctA, null, null));
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
