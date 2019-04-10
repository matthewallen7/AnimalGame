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
public class BTree implements java.io.Serializable{

    /**
     *
     */
    public String data;

    /**
     *
     */
    public BTree left;

    /**
     *
     */
    public BTree right;
    
    /**
     *
     * @param data
     * @param left
     * @param right
     */
    
    //variables for the Binary tree.
    public BTree(String data, BTree left, BTree right){
    this.data = data;
    this.left = left;
    this.right = right;
    }   

    /**
     *
     * @param data
     */
    
    //data contructor and set the left and right node null.
    public BTree(String data) {
        this.data = data;
        left = right = null;
    }

    /**
     *
     * @return
     */
    
    //return the data of the node.
    public String getData() {
        return data;
    }

    /**
     *
     * @param data
     */
    
    //set the data of the current node.
    public void setData(String data) {
        this.data = data;
    }

    /**
     *
     * @return
     */
    
    //get the left node.
    public BTree getLeft() {
        return left;
    }

    /**
     *
     * @param left
     */
    
    //set the left node.
    public void setLeft(BTree left) {
        if (this.left==null) 
            this.left = left;
    }

    /**
     *
     * @return
     */
    
    //get the data of the right node.
    public BTree getRight() {        
        return right;
    }

    /**
     *
     * @param right
     */
    
    //set the right node.
    public void setRight(BTree right) {
        if (this.right==null)
            this.right = right;
    }
    
    /**
     *
     * @return
     */
    
    //if the node is a leaf.
    public boolean isLeaf( )
    {
     return (left == null) && (right == null);                                               
    } 
    
 
    //print the binary tree.
    void printPreorder(BTree node) {
        if (node==null) 
            return;
        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }
    
    void printPostorder(BTree node) {
        if (node==null) 
            return;        
        printPreorder(node.left);
        printPreorder(node.right);
        System.out.print(node.data + " ");
    }
    
    void printInorder(BTree node) {
        if (node==null) 
            return;        
        printPreorder(node.left);
        System.out.print(node.data + " ");
        printPreorder(node.right);
        
    }
    
    /**
     *
     * @return
     */
    public String print() {
        return print("", true, "");
    }
    
    /**
     *
     * @param prefix
     * @param isTail
     * @param sb
     * @return
     */
    public String print(String prefix, boolean isTail, String sb) {
        if (right!=null) {
            right.print(prefix + (isTail?"|   ":"   "), false, sb);
        }
        System.out.println(prefix + (isTail?"\\-- ":"/-- ") + data);
        if (left!=null) {
            left.print(prefix + (isTail?"    ":"|   "), true, sb);
        }
        return sb;
    }
}
