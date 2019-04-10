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
    public static String locateAnimal = "";
    public static boolean found = false;
    public static SaveGame[] AnimalSave = new SaveGame[100];
    private static Scanner scanner = new Scanner(System.in);
    public static BTree initialrootnode;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        initialrootnode = TreeDriver.initial();
        for(;;){
        int choice = introduction();
        if (choice == 1) 
        {
            do{
                
            playGame(initialrootnode);
            
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
        LoadTheGame(initialrootnode);
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
      e.location = AnimalSave[i].location;
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
  
  public static void LoadTheGame(BTree rootnode){
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
      
      System.out.println("Deserialized Animal...");
      System.out.println("New Question: " + e.newQ);
      System.out.println("Correct Animal: " + e.correctA);
      System.out.println("Guess Animal: " + e.guessA);
      System.out.println("Input: " + e.input);
      System.out.println("Location: " + e.location);
      do{
        FindAnimal(rootnode, e.guessA, e.location, e.newQ, e.correctA, e.input);
        }          
        while (input("Shall we play again?"));
        System.out.println("Loaded Data");
  }
    
  public static void playGame(BTree currentNode)
  {
   while (!currentNode.isLeaf())
   {
     if (input(currentNode.getData())){
        currentNode = currentNode.getLeft();
        locateAnimal += "Y";
     }
     else{
           currentNode = currentNode.getRight();
           locateAnimal += "N";
     }
   }
 
   System.out.print("You are a " + currentNode.getData() + ". ");
   if (!input("Am I Correct?"))
     AddAnimal(currentNode);
   else
     System.out.println("I'm just too good!");
  }
  
  public static void FindAnimal(BTree currentNode, String guessA, String location, String newQ, String correctA, String input){
      try {
      String currentLocation = location;
      while (!currentNode.isLeaf() && found == false)
      {
          String s = "";
          char currentChar = currentLocation.charAt(0);
          String strChar = String.valueOf(currentChar);
          if (strChar.equals("Y")){
              currentNode = currentNode.getLeft();
              s = currentNode.getData();
              currentLocation = currentLocation.substring(1);
          }
          else{
              currentNode = currentNode.getRight();
              s = currentNode.getData();
              currentLocation = currentLocation.substring(1);
          }
          if (s.equals(guessA))
          {
              LoadAnimal(currentNode, guessA, correctA, newQ, input);
          }
      }
      }
      catch (Exception e) {
         System.out.println("Already Loaded Save." + "\r\n");
      }
  }
  
  public static void LoadAnimal(BTree current, String guessAnimal, String newAnimal, String newQuestion, String input){
   String guessA = guessAnimal;   
   String correctA = newAnimal; 
   String newQ = newQuestion;   
   
   System.out.println(current);
   guessA = current.getData();
   System.out.println("Loading Data....");
   
   current.setData(newQ);
   if (input.equals("Y"))
   {
     current.setLeft(new BTree(correctA, null, null));
     current.setRight(new BTree(guessA, null, null));
     found = true;
   }
   else
   {
     current.setLeft(new BTree(guessA, null, null));
     current.setRight(new BTree(correctA, null, null));
     found = true;
   }
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
     AnimalSave[saveSlot] = new SaveGame(newQ, correctA, guessA, "Y", locateAnimal);
   }
   else
   {
     current.setLeft(new BTree(guessA, null, null));
     current.setRight(new BTree(correctA, null, null));
     AnimalSave[saveSlot] = new SaveGame(newQ, guessA, correctA, "N", locateAnimal);
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
