package binarytree;
/**
 * 
 * Binary Tree class:
 * 
 * 
 * - The BinaryNode class is implemented separately, instead of as a nested class.
 * - The BinaryTree class routines are short because they call BinaryNode methods.
 * - The only data member - a reference to the root node.
 *
 * 
 *  - Two basic constructors are provided.
 *  - The one creates an empty tree, and the other create a one-node tree.
 *  
 *  
 *  printPreOrder(), printInOrder(), printPostOrder()
 *  - Routines to traverse the tree. PreOrder, InOrder, PostOrder
 *  - They apply a BinaryNode method to the root, after verifying that the tree is not empty.
 *  - An alternative traversal strategy that can be implemented is level-order traversal.
 *  
 *  
 *  makeEmpty()
 *  isEmpty()
 *  - Routines to make an empty tree and test for emptiness are given,
 *    with their inline implementations
 *  
 *  size()
 *  height()
 *  - routines to compute the tree's size and height.
 *  - Note that, as size and height are static methods in BinaryNode,
 *    we can call them by simply using BinaryNode.size and BinaryNode.height
 *    
 *  merge()
 *  - The merge routine, which uses 2 trees - t1 and t2 - and an element to create a new tree,
 *    with the element at the root and the 2 existing trees as left and right subtrees.
 *  - In principle, it is a one-liner:
 *    
 *    root = new BinaryNode<T>(rootItem, t1.root, t2.root);
 *    
 *    - But, there are a host of complications.
 *    - Figure below shows the result of the simple one-line merge.
 *    - A problem become apparent:
 *      - Nodes in t1 and t2's trees are now in 2 trees(their original trees and the merged result).
 *      - This sharing is a problem if we want to remove or otherwise alter subtrees
 *        (because multiple subtrees may be removed or altered unintentionally).
 *    - result of a naive merge operation:
 *    
 *    Subtrees are shared.
 *    
 *            root
 *            /\
 *         ...  x
 *              /\
 *      t1.root   t2.root
 *              
 *      - The solution is simple.
 *      - We can ensure that nodes do not appear in 2 trees by setting t.root and t2.root to null after the merge.
 *  
 *        
 *      - Complications ensue when we consider some possible calls that contain aliasing:
 *        
 *          t1.merge(x, t1, t2);
 *          t2.merge(x, t1, t2);
 *          t1.merge(x, t3, t3);
 *          
 *      - The first 2 cases are similar, so we consider only the first one.
 *      - A diagram of the situation is shown below.
 *      - Because t1 is an alias for the current object, t1.root and root are aliases.
 *      - Thus, after the call to new, if we execute t1.root = null,
 *        we change root to the null reference, too.
 *      - Consequently, we need to be very careful with the aliases for these cases.
 *      
 *          Aliasing problems in the merge operation; t1 is also the current object.
 *          
 *                                  x  -> root  and t1.root
 *                                  /\
 *     old root and old t1.root<- /\  /\ -> t2.root
 *     
 *  
 *      - The third case must be disallowed because it would place all the nodes that are in tree t3
 *        in two places in t1. 
 *      - However, if t3 represents an empty tree, the third case should be allowed.
 *        
 *      
 *  
 *      
 *      
 *
 */
// BinaryTree class; stores a binary tree.
//
// Construction: 
// with(a) no parameters or
//     (b) an object to be placed in the root of a one-element tree.
// Public Operation:
// Various tree traversals, size, height, isEmpty, makeEmpty.
// Also, the following tricky method:
// void merge(Object root, BinaryTree t1, Binary t2)
// --> Construct a new tree
// Errors:
// Error message printed for illegal merges.

public class BinaryTree<T> {
	
	private BinaryNode<T> root;
	
	public BinaryTree() {
		root = null;
	}
	
	public BinaryTree(T rootItem) {
		root = new BinaryNode<T>(rootItem, null, null);
	}
	
	public BinaryNode<T> getRoot(){
		return root;
	}
	
	public int size() {
		return BinaryNode.size(root);
	}
	
	public int height() {
		return BinaryNode.height(root);
	}
	
	public void printPreOrder() {
		if(root != null)
			root.printPreOrder();
	}
	
	public void printInOrder() {
		if(root != null)
			root.printInOrder();
	}
	
	public void printPostOrder() {
		if(root != null)
			root.printPostOrder();
	}
	
	public void makeEmpty() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	/**
	 * Merge routine for BinaryTree class.
	 * Forms a new tree from rootItem, t1 and t2.
	 * Does not allow t1 and t2 to be the same.
	 * Correctly handles other aliasing conditions.
	 * @param rootItem 
	 * @param t1
	 * @param t2
	 */
	public void merge(T rootItem, BinaryTree<T> t1, BinaryTree<T> t2) {
		
		if(t1.root == t2.root && t1.root != null)
			throw new IllegalArgumentException();
		
		// Allocate new node
		root = new BinaryNode<T> (rootItem, t1.root, t2.root);
		
		// Ensure that every node is in one tree
		if(this != t1)
			t1.root = null;
		if(this != t2)
			t2.root = null;
	}
	
	

}
