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
    public String newQ;
    public String correctA;
    public String guessA;
    public String input;

    SaveGame(String newQ, String correctA, String guessA, String input) {
    this.newQ = newQ;
    this.correctA = correctA;
    this.guessA = guessA;
    this.input = input;
    }
    
    public SaveGame(){}    
}
