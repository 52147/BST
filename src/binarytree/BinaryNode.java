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
 * = tree traversal =
 * 
 * - we have shown how recursion can be used to implement the binary tree methods.
 * - When recursion is applied, we compute information about not only a node
 *   but also all its descendants.
 * - We say then that we are traversing the tree.
 * - Two popular traversals are preorder and postorder traversals.
 * 
 * 
 * preorder:(root - left - right)
 * 
 * - In a preorder traversal, the node processed and then its children are processed recursively.
 * - The duplicate routine is an example of a preorder traversal
 *   because the root is created first.
 * - Then a left subtree is copied recursively, followed by copying the right subtree.
 * 
 * 
 * postorder:(left - right - root)
 * 
 * - In a postorder traversal, the node is processed after both children are processed recursively.
 * - Two examples are the methods size and height.
 * - In both cases, information about a node(e.g., its size or height)
 *   can be obtained only after the corresponding information is known for its children.
 *   
 * inorder:(left - root - right)
 * 
 * - A third common recursive traversal is the inorder traversal, 
 *   in which the left child is recursively processed, the current node is processed,
 *   and the right child is recursively processed.
 * - This mechanism is used to generate an algebraic expression corresponding 
 *   to an expression tree.
 *   - for example,
 *     the inorder traversal yields (a+((b-c)*d))
 *     
 *     (a) Preorder visitation routes
 *           
 *           1
 *           /\
 *          2  3
 *             /\
 *            4  6
 *            \  /
 *            5 7
 *            
 *       (b) postorder visitation routes
 *            
 *           7
 *           /\
 *          1  6
 *             /\
 *            3  5
 *            \  /
 *            2 4
 *            
 *       (c) inorder visitation routes
 *       
 *           2
 *           /\
 *          1  5
 *             /\
 *            3  7
 *            \  /
 *            4 6
 *           
 *     
 *     
 * - The code below illustrates routines that print the nodes in a binary tree
 *   using each of the 3 recursive tree traversal algorithms.
 *     
 * Time complexity:
 *     
 * - The running time of each algorithm is linear.
 * - In every case, each node is output only once.
 * - Consequently, the total cost of an output statement over any traversal is O(N).    
 *      
 * - As a result, each if statement is also executed at most once per node,
 *   for a total cost of O(N).      
 * 
 * - The total number of method calls made 
 *   (which involves the constant work of internal run-time stack pushes and pops)
 *   is likewise once per node, or O(N).
 * - Thus the total running time is O(N).     
 *                         
 *
 */

// BinaryNode class; stores a node in a tree.
//
// Construction: with no parameters, or an Object, left child, and right child.
//
// Public Operations:
// int size()              -> Return size of subtree at node
// int height()            -> Return height of a subtree at node
// void printPostOrder()   -> Print a postorder tree traversal
// void printInOrder()     -> Print an inorder tree traversal
// void printPreOrder()    -> Print a preorder tree traversal
// BinaryNode duplicate()  -> Return a duplicate tree 

/**
 * Binary node class with recursive routines to compute size and height.
 * 
 *
 * @param <T>
 */
final class BinaryNode<T> {
	
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
	// post order: left -> right -> root
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
	// post order: left -> right -> root
	public static <T> int height(BinaryNode<T> t) {
		
		if (t == null)
			return -1;
		else
			return 1 + Math.max(height(t.left), height(t.right));
	}
	
	// preorder: root -> left -> right
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
	
	// Print tree rooted at current node using preorder traversal.
	public void printPreOrder() {
		System.out.println(element); // Node
		if(left != null)
			left.printPreOrder();    // Left
		if(right != null) 
			right.printPreOrder();   // Right
		
	}
	// Print tree rooted at current node using postorder traversal.
	public void printPostOrder() {
		if(left != null)     
			left.printPostOrder();      // Left
		if(right != null)
			right.printPostOrder();     // Right
		System.out.println(element);    // Node
	}
	// Print tree rooted at current node using inorder traversal.
	public void printInOrder() {
		if(left != null)
			left.printInOrder();      // Left
		System.out.println(element);  // Node
		if(right != null)
			right.printInOrder();     // Right
	}

}
