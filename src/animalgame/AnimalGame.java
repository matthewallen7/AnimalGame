/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalgame;
import java.io.ByteArrayOutputStream;
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
    public static int saveSlot = 0;
    public static SaveGame[] AnimalSave = new SaveGame[100];
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
            if (saveSlot > 0) 
            {
                SaveTheGame();
            }
            else{
            System.out.print("No current save data! " + "\r\n");
            }
        }
        //Fix Deserialize
        if (choice.equals("3")) {
            //Load data
        LoadTheGame();
        }
        if (choice.equals("4")) {
            System.exit(0);
        }
        return Integer.valueOf(choice);
    }
    
  public static void SaveTheGame(){
      SaveGame e = new SaveGame();
      for (int i = 0; i < saveSlot; i++) {
      e.newQ = AnimalSave[i].newQ;
      e.correctA = AnimalSave[i].correctA;
      e.guessA = AnimalSave[i].guessA;
      e.input = AnimalSave[i].input;
    try {
        FileOutputStream fileOut =
        new FileOutputStream("SaveData.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(e);
        out.close();
        fileOut.close();
      } catch (IOException z) {
         z.printStackTrace();
      }
      }
      System.out.printf("Serialized data is saved in SaveData.ser " + "\r\n");
  }
  
  public static void LoadTheGame(){
      SaveGame e = null;
      try {
         FileInputStream fileIn = new FileInputStream("SaveData.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         e = (SaveGame) in.readObject();
         in.close();
         fileIn.close();
      } catch (IOException i) {
         i.printStackTrace();
         return;
      } catch (ClassNotFoundException c) {
         System.out.println("Node class not found");
         c.printStackTrace();
         return;
      }
      
      System.out.println("Deserialized Employee...");
      System.out.println("New Question: " + e.newQ);
      System.out.println("Correct Animal: " + e.correctA);
      System.out.println("Guess Animal: " + e.guessA);
      System.out.println("Input: " + e.input);
  }
    
  public static void playGame(BTree currentNode)
  {
   while (!currentNode.isLeaf())
   {
     if (input(currentNode.getData()))
      currentNode = currentNode.getLeft();
     else
      currentNode = currentNode.getRight();
   }
 
   System.out.print("You are a " + currentNode.getData() + ". ");
   if (!input("Am I Correct?"))
     AddAnimal(currentNode);
   else
     System.out.println("I'm just too good!");
  }
  
  public static void AddAnimal(BTree current)
  {
   String guessA;   
   String correctA; 
   String newQ;   
   
   System.out.println(current);
   guessA = current.getData();
   System.out.println("I give up. What are you? ");
   correctA = scanner.nextLine();
   System.out.println("Write a yes/no question that will tell me the difference between a");
   System.out.println(correctA + " from a " + guessA + ".");
   newQ = scanner.nextLine();
   
   current.setData(newQ);
   System.out.println("As a " + correctA + ", " + newQ);
   if (input("Please answer"))
   {
     current.setLeft(new BTree(correctA, null, null));
     current.setRight(new BTree(guessA, null, null));
     AnimalSave[saveSlot] = new SaveGame(newQ, correctA, guessA, "Y");
   }
   else
   {
     current.setLeft(new BTree(guessA, null, null));
     current.setRight(new BTree(correctA, null, null));
     AnimalSave[saveSlot] = new SaveGame(newQ, guessA, correctA, "N");
   }       
   saveSlot++;
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
