package animalgame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matth
 */
public class SaveGame implements java.io.Serializable{

    //class variables
    /**
     *
     */
    public String newQ;

    /**
     *
     */
    public String correctA;

    /**
     *
     */
    public String guessA;

    /**
     *
     */
    public String input;

    /**
     *
     */
    public String location;

    //contructor for the array.
    SaveGame(String newQ, String correctA, String guessA, String input, String location) {
    this.newQ = newQ;
    this.correctA = correctA;
    this.guessA = guessA;
    this.input = input;
    this.location = location;
    }
    
    /**
     *
     */
    public SaveGame(){}    
}
