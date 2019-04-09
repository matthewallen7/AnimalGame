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
public class BTree {
    public String data;
    public BTree left;
    public BTree right;
    
    public BTree(String data, BTree left, BTree right){
    this.data = data;
    this.left = left;
    this.right = right;
    }

    public BTree(String data) {
        this.data = data;
        left = right = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public BTree getLeft() {
        return left;
    }

    public void setLeft(BTree left) {
        if (this.left==null) 
            this.left = left;
    }

    public BTree getRight() {        
        return right;
    }

    public void setRight(BTree right) {
        if (this.right==null)
            this.right = right;
    }
    
    public boolean isLeaf( )
    {
     return (left == null) && (right == null);                                               
    } 
 
    
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
    
    public String print() {
        return print("", true, "");
    }
    
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
