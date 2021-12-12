package binarytree;
/**
 * = Binary Trees =
 * 
 *  - A binary tree is a tree in which no node can have more than 2 children.
 *  - Because there are only 2 children, we can name them left and right.
 *  
 *  - Recursively, a binary tree is either empty or consists of a root, a left tree, and a right tree.
 *  - The left and right trees may themselves be empty; thus a node with one child could have either a left or right child.
 *  
 *  - We use the recursive definition several times in the design on binary tree algorithms.
 *  
 *  
 *  
 *  - Binary trees have many important uses:
 *  
 *    - Uses of a binary trees:
 *    
 *      -(a) an expression tree
 *      
 *       - One use of the binary tree is in the expression tree, which is a central data structure in complier design.
 *       - The leaves of an expression tree are operands, such as constants or variable names; the other nodes contain operators.
 *       
 *       - This tree is binary because all the operations are binary.
 *       - Although this case is the simplest, nodes can have more than 2 children (and in the case of unary operators, only one child).
 *       
 *       - We can evaluate an expression tree T by applying the operator at the root to the values obtained by recursively evaluating the left add right subtrees.
 *       - Doing so yields the expression a + (b - c) * d
 *      
 *      
 *      -(b) a Huffman coding tree
 *       
 *       - which is used to implemented a simple but relatively effective data compression algorithm.
 *       - Each symbol in the alphabet is stored at a leaf.
 *       - Its code is obtained by following the path to it from the root.
 *       - A left link corresponds to a 0 and right link to a 1.
 *       - Thus b is coding as 100.
 *       
 *       
 *       Use of binary trees:
 *       
 *       (a) an expression tree
 *       
 *           +      
 *           /\
 *          a  *
 *             /\
 *            -  d
 *           /\
 *          b  c
 *          
 *       (b) a Huffman coding tree
 *        
 *           ()
 *           /\
 *          a  ()  
 *             /\
 *            () d
 *            /\
 *            b c
 *    
 *      (c) Binary Search Tree 
 *     
 *      - Other uses of the binary tree are in binary search trees, which allow algorithm time insertions and accessing of items
 *        , and priority queues, which support the access and deletion of the minimum in a collection of items.
 *      - Several efficient implementations of priority queus use trees.
 * 
 *    
 *    
 *  BinaryNode class:
 *    
 *  - The code below gives the skeleton for the BinaryNode class.
 *  
 *    - Each node consists of a data item plus 2 links.
 *    - The constructor, initializes all the data members of the BinaryNode class.
 *    - Provide accessors and mutators for each of the data members.
 *   
 *    duplicate()
 *    
 *    - The duplicate method is used to replicate a copy of the tree rooted at the current node.
 *    - The routines's size and height compute the named properties for the node referenced by parameter t.
 *    - We also provide routines that print out the contents of a tree rooted at the current node,
 *      using various recursive traversal strategies.
 *    
 *    - Why do we pass a parameter for size and height and make them static but use the current object 
 *      for the traversals and duplicate?
 *      - There is no particular reason.
 *      - it is a matter of style, and we show both styles here.
 *      
 *       - The implementations show that the difference between then occurs when the required test for an empty tree
 *         (given by a null reference) is performed. 
 *         
 *  
 *     Recursion:
 *  
 *      - Because trees can be defined recursively, many tree routines, 
 *        are most easily implemented by using recursion.
 *      - Recursive routines are used for size and duplicate.
 *    
 *      - We begin with the duplicate method of the BinaryNode class.
 *      - Because it is a BinaryNode method, we are assured that the tree we are duplicating is not empty.
 *    
 *        - The recursive algorithm:
 *          - First, we create a new node with the same data field as the current root.
 *          - Then we attach a left tree by calling duplicate recursively and attach a right tree by calling duplicate recursively.
 *        
 *          - In both cases, we make the recursive call after verifying that there is a tree to copy.    
 *
 *    size()
 *    
 *    - The next method is size routine in the BinaryNode class.
 *    - It returns the size of the tree rooted at a node referenced by t,
 *    - which is passed as a parameter.
 *    - If we draw the tree recursively, we see that the size of a tree 
 *      is the size of the left subtree plus the size of the right subtree plus 1(because the root counts as a node).
 *    
 *    - A recursive routine requires a base case that can be solved without recursion.
 *    - The smallest tree that size might have to handle is the empty tree(if t is null),
 *      and the size of an empty tree is clearly 0.
 *    - We should verify that the recursion produces the correct answer for a tree of size 1.
 *    
 *    
 *    height()
 *    
 *    - Implementing the height recursive routine is difficult to do nonrecursively 
 *      but is trivial recursively, once we have made a drawing.
 *      - Figure below shows a tree viewed recursively.
 *    
 *    
 *                         o
 *                 |       /\        | 
 *                 |   |  /\ /\  |   |
 *              HL+1   HL        HR  HL+1 
 *              
 *     - Suppose that the left subtree has height HL and the right subtree has height HR.
 *     - Any node that is d levels deep with respect to the root of the left subtree d+1 levels deep
 *       with respect to the root of the entire tree. 
 *     - Thus the path length of the deepest node in the original tree is 1 more than its path length
 *       with respect to the root of its subtree.
 *     - If we compute this value for both subtrees, the maximum of these 2 values plus 1 is the answer we want.
 *       
 *                         
 *
 */

// BinaryNode class; stores a node in a tree.
//
// Construction: with no parameters, or an Object, left child, and right child.
//
// Public Operations:
// int size()     -> Return size of subtree at node
// int height()   -> Return height of a subtree at node
// void printPostOrder()   -> Print a postorder tree tracersal
// void orintInOrder()  -> Print an inorder tree traversal
// void printPreOrder()  -> Print a preorder tree traversal
// BinartNode duplicate()  -> Return a duplicate tree 

public class BinaryNode<T> {
	
	private T element;
	private BinaryNode<T> left;
	private BinaryNode<T> right;
	
	
	
	public BinaryNode() {
		this(null, null, null);
	}
	public BinaryNode(T theElement, BinaryNode<T> lt, BinaryNode<T> rt) {
		element = theElement;
		left = lt;
		right = rt;
	}
	
	public T getElement() {
		return element;
	}
	
	public BinaryNode<T> getLeft(){
		return left;
	}
	
	public BinaryNode<T> getRight(){
		return right;
	}
	
	public void setElement(T x) {
		element = x;
	}
	
	public void setLeft(BinaryNode<T> t) {
		left = t;
	}
	
	public void setRight(BinaryNode<T> t) {
		right = t;
	}
	/**
	 * A routine for computing the size of a node
	 * Return the size of the binary tree rooted at t.
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> int size(BinaryNode<T> t) {
		if (t == null)
			return 0;
		else 
			return 1 + size(t.left) + size(t.right);
	}
	
	/**
	 * Return the height of the binary tree rooted at t.
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> int height(BinaryNode<T> t) {
		
		if (t == null)
			return -1;
		else
			return 1 + Math.max(height(t.left), height(t.right));
	}
	
	public BinaryNode<T> duplicate(){
		
		BinaryNode<T> root = new BinaryNode<T> (element, null, null);
		// If there is a left subtree
		if(left != null)
			root.left = left.duplicate(); // Duplicate; attach
		// If there is a right subtree
		if(right != null)
			root.right = right.duplicate(); // Duplicate; attach
		return root; // Return resulting tree
	}
	
	public void printPreOrder() {}
	
	public void printPostOrder() {}
	
	public void printInOrder() {}

}
