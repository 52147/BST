package bstnote;
/**
 * 
 * = bst note =
 * 
 *  - search order property
 *  - give a value x of node
 *  - try to find the x
 *  - if x is smaller than the root -> go right subtree
 *  - if x is bigger than the root -> go left subtree
 *  - use compareTo method in comparison interface
 *  - use public method to call internal method 
 *  
 *  
 *  Node class
 *  data:
 *  	1. left 
 *  	2. right 
 *  	3. element
 *  
 *  
 *  
 *  
 *  bst class
 *  data
 *  	root
 *  method
 *  public
 *  	1. constructor
 *  	2. insert (recursive)
 *  	3. remove (recursive)
 *  	4. remove min (recursive)
 *  	5. find (nested loop)
 *  	6. find min (nested loop)
 *  	7. find max (nested loop)
 *  	8. isEmpty
 *  	9. makeEmpty
 *  private
 *  
 *  
 * 
 *
 */
public class Node<T> {
	
	Node<T> left;
	Node<T> right;
	T element;
	
	Node(T element){
		left = right = null;
		this.element = element;
	}
	
	
	
	
	

}
