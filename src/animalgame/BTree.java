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
public class BTree <E>{
  private E data;
  private BTree<E> left, right;   

  public BTree(E Data, BTree<E> Left, BTree<E> Right)
  {
   data = Data;
   left = Left;
   right = Right;
  }       
  
  public E getData( )   
  {
    return data;
  }
  
  public BTree<E> getLeft( )
  {
    return left;                                               
  } 
  
  public E getLeftData( )
  {
   if (left == null)
     return data;
   else
     return left.getLeftData( );
  }
   
  public BTree<E> getRight( )
  {
   return right;                                               
  } 
 
  public E getRightData( )
  {
   if (left == null)
     return data;
   else
     return left.getRightData( );
  }
  
  public void printInorder( )
  {
   if (left != null)
     left.printInorder( );
   System.out.println(data);
   if (right != null)
     right.printInorder( );
  }  
 
  public boolean isLeaf( )
  {
   return (left == null) && (right == null);                                               
  } 
 
  public void printPreorder( )
  {
   System.out.println(data);
   if (left != null)
     left.printPreorder( );
   if (right != null)
     right.printPreorder( );
  } 
  
  public void printPostorder( )
  {
   if (left != null)
     left.printPostorder( );
   if (right != null)
     right.printPostorder( );
   System.out.println(data);
  }   
  
  public BTree<E> removeLeftmost( )
  {
   if (left == null)
     return right;
   else
   {
     left = left.removeLeftmost( );
     return this;
   }
  }
 
  public BTree<E> removeRightmost( )
  {
   if (right == null)
     return left;
   else
   {
     right = right.removeRightmost( );
     return this;
   }
  }
    
  public void setData(E newData)   
  {
   data = newData;
  }                                                               
  
  public void setLeft(BTree<E> newLeft)
  {                    
   left = newLeft;
  }
  
  public void setRight(BTree<E> newRight)
  {                    
   right = newRight;
  }  
  
  public static <E> BTree<E> Copy(BTree<E> current)
  {
   BTree<E> leftCopy, rightCopy;
 
   if (current == null)
     return null;
   else
   {
     leftCopy = Copy(current.left);
     rightCopy = Copy(current.right);
     return new BTree<E>(current.data, leftCopy, rightCopy);
   }
  }
  
  public static <E> long treeSize(BTree<E> root)
  {
   if (root == null)
     return 0;
   else
     return 1 + treeSize(root.left) + treeSize(root.right);
  }  
}
