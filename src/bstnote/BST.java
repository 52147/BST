package bstnote;

import binarysearchtree.DuplicateItemException;
import binarysearchtree.ItemNotFoundException;

public class BST<T extends Comparable<? super T>> {
	
	protected Node<T> root;
	
	BST(){
		root = null;
		
	}
	
	// Internal method to get the element field
	private T getElementAt(Node<T> t) {
		return t == null ? null : t.element; 
	}
	
	public void insert(T x) {
		root = insert(x, root);
		
	}
	
	// Internal insert method
	// Use recursive to insert the node
	protected Node<T> insert(T x, Node<T> t) {
		// 1. If the tree is empty, create one node with x element
		if(t == null)
			t = new Node<T>(x);
		// 2. If the x is smaller than t's element(<0), insert to left subtree
		else if(x.compareTo(t.element)<0)
			t.left = insert(x, t.left); // recursive to compare the node of left subtree
		// 3. If the x is bigger than t's element (>0), insert to right subtree
		else if(x.compareTo(t.element)>0)
			t.right = insert(x, t.right);// recursive to keep compare the node of right subtree
		// 4. If insert the duplicate element, throw exception (create a new exception object)
		else
			throw new DuplicateItemException(x.toString());		
		// 5. return the node that insert
		return t;
	}
	
	public T findMin() {
		return getElementAt(findMin(root));
	}
	//  Nested loop:
	//  2 Conditions
	//  condition 1 -> true -> condition 2 -> true -> statement -> condition 2 -> true -> statement (if true loop in condition 2)
	//  -> condition 2-> false -> end loop 2 -> to condition 1 -> false ->end loop 1 -> statement -> stop 	
	
	// Internal method to find the smallest node
	// Use a nested loop to keep check the minimum node in the left subtree
	// return t(the smallest node)
	private Node<T> findMin(Node<T> t){
		if(t!= null)
			while(t.left != null)
				t = t.left; // go on the next left subtree
		return t;
	}
	
	public T findMax() {
		return getElementAt(findMax(root));	
	}
	
	private Node<T> findMax(Node<T> t){
		if(t!= null)
			while(t.right != null)
				t = t.right;
		return t;
	}
	
	// public find method to call
	// find the method in which node
	// return the node's element
	public T find(T x) {
		return getElementAt(findElement(x, root));
	}
	
	// Internal method to find the node.
	// Use a nested loop to find the element.
	// return node that match the element
	// Node t is a pointer, first t is at root node
	private Node<T> findElement(T x, Node<T> t) {
		while(t != null)
			if(x.compareTo(t.element)<0)
				t = t.left;
			else if(x.compareTo(t.element)>0)
				t = t.right;
			else
				return t; // found the x is in t node
				
		return null; // element is not found 
	}
	
	public void removeMin() {
		root = removeMin(root);
	}
	
	
	// protected access modifier: 
	// Internal method use protected modifier
	// Use protected, they are accessible only within the same package 
	// and the direct subclasses of the base class.
	// When to use protected access modifier:
	// when you need to do some internal stuff that is not exposed in public API 
	// but still needs to be overridden by subclasses.
	
	// Internal method to remove the minimum node in the tree.
	// we know the left link value is smaller than right link value.
	// so we keep use root node to recursive the left link
	// to find the minimum element and remove it
	// and when we remove the minimum node, we return a new minimum node of the left
	// if there is no node in the left, we return right
	// if the tree is empty, we throw an Exception	
	protected Node<T> removeMin(Node<T> t) {
		if(t == null)
			throw new ItemNotFoundException(t.toString());
		else if(t.left != null) {
			t.left = removeMin(t.left);
			return t;
		}
		else
			return t.right;		
	}
	
	// give the element, and remove the node that contains that element
	public T remove(T x) {
		return getElementAt(remove(x, root));
	}
	
	// Internal method to remove the element from the subtree, not remove the node.
	// 1. if the root is empty(t == null), throw an Exception
	// 2. if x is smaller that the t -> recursive the remove left tree to find the t
	// 3. if x is bigger than the t -> recursive the remove right tree to find the t
	// 4. if found that node , which element(x compare to t = 1 ), and that node has two children
	//    -> give the node the minimum element of the right subtree and remove that minimum node
	// 5. if that node has only one child. -> set the t the value of that one node(left or right)
	protected Node<T> remove(T x, Node<T> t){
		if(t == null)
			throw new ItemNotFoundException(x.toString());
		else if(x.compareTo(t.element)<0)
			t.left = remove(x, t.left);
		else if(x.compareTo(t.element)>0)
			t.right = remove(x, t.right);
		else if(t.left != null && t.right != null) {
			t.element = findMin(t.right).element;
			t.right = removeMin(t.right);
		}
		else
			t = (t.left!=null) ? t.left: t.right;
		return t;		
		
	}
	
	// Make the tree empty -> root = null
	public void makeEmpty() {
		root = null; // = : make the reference of the root be null
	}
	
	// Use boolean to check the tree is empty or not
	// root == null return true
	public boolean isEmpty() {
		return root == null; //  == : checks if both objects point to the same memory location
	}
	
	
	

}
