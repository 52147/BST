package binarysearchtree;
/**
 *  The BinarySearchTree class
 *  
 *  - The only data member is the reference to the root of the tree, root.
 *  - If the tree is empty, root is null
 *  
 *  - The public method have implementations that call the hidden methods.
 *  - The constructor merely sets root to null.
 *  
 * 
 *  - We have several methods that operate a node passed as parameter.
 *  - The idea is that the publicly visible class routines call these hidden routines
 *    and pass root as a parameter.
 *  - These hidden routines do all the work.
 *  - In a few places, we use protected rather than private because we derive another class from BinarySerchTree.
 *  
 *  insert()
 *  - The insert method add x to the current tree by calling the hidden insert with root as an additional parameter.
 *  - This action fails if x is already in the tree; in that case, a DuplicateItemException would be thrown.
 *  
 *  
 *  - Here we use recursion to simplify the code.
 *  - A nonrecursive implementation is also possible.
 *  - If the tree is empty, we can create a one node tree.
 *  - Notice carefully that, as before, local changes to t are lost.
 *  - Thus we return the new root, t.
 *  
 *  
 *  - If the tree is not already empty, we have three possibilities.
 *    
 *    1.
 *    - First, if the item to be inserted is smaller that the item in node t, we call insert recursively on the left subtree.
 *    2.
 *    - Second, if the item is larger than the item in node t, we call insert recursively on the right subtree.
 *    3.
 *    - Third, if the item to insert matched the item in t, we throw an exception. 
 *  
 *  findMin()
 *  findMax()
 *  find()
 *  - The findMin, findMax, and find operations return the minimum, maximum, or named item from the tree.
 *  - If the item is not found because the tree is empty or the named item is not present,
 *    then null is returned.
 *  - So long as a null link has not been reached, we either have a match or need to branch left or right.
 *  
 *  - Note the order of the tests.
 *  - The test against null must be performed first; otherwise,
 *    the access t.element would be illegal.
 *  - The remaining tests are arranges with the least likely case last.
 *  - A recursive implementation is possible, but we use a loop instead;
 *    we use recursion in the insert and remove methods.   
 *    
 *    
 *  - Statements such as t = t.left may seen to change the root of the tree.
 *  - That is not the case, however, because t is passed by value.
 *  - In the initial call, t is simply a copy of root.
 *  - Although t changes, root does not.
 *  - The call to findMin and findMax are even simpler because branching is unconditionally in one direction.
 *  - Note how the case of an empty tree is handled.
 * 
 *    
 *    
 *  removeMin()
 *  - The removeMin operation removes the minimum item from the tree;
 *    it throws an exception if the tree is empty.
 *    
 *  - The removeMin operation is simple because the minimum node has no left child.
 *  - Thus the removed node merely needs to be bypassed, which appears to require us to keep track of the parent of the current node
 *    as we descend the tree.
 *  - We can avoid the explicit use of a parent link by using recursion.
 *  
 *  - If the tree t is empty, removeMin fails.
 *  - Otherwise, if t has a left child, we recursively remove the minimum item in the left subtree
 *    via the recursive call.
 *  - We know that we are currently at the minimum node, and thus t is the root of a subtree that has no left child.
 *  
 *  - If we set t to t.right, t is now the root of a subtree that is missing its former minimum element.
 *  - But doesn't that disconnect the tree?
 *  - The answer again is no.
 *  - If t was root, the new t is returned and assigned to root in the public method.
 *  - If t was not root, it is p.left, where p is t's parent at the time of the recursive call.
 *  
 *  
 *  
 *  remove()
 *  - The remove operation removes a named item x from the tree;
 *    it throws an exception if warranted.
 *    
 *  - The method that has p as a parameter(in other words, the method that called the current method)
 *    changes p.left to the new t.
 *  - All in all, it is a nifty maneuver, we have maintained the parent in the recursion stack rather than
 *    explicitly kept track of it in an iterative loop. 
 *    
 *  - If the tree is empty, the remove is unsuccessful and we can throw an exception.
 *  - If we do not have a match, we can recursively call remove for either the left or right subtree.
 *  - Otherwise, we have found the node that needs to be removed.
 *  
 *  - if there are two children, we replace the node with the minimum element in the right subtree
 *    and then remove the right subtree's minimum.
 *  - Otherwise, we have either one or zero children.
 *  - If there is a left child, we set t equal to its left child, as we would do in removeMax.
 *  - Otherwise, we know that there is no left child and that we can set t equal to its right child.
 *  - This procedure also covers the leaf case.
 *      
 *    
 *    
 *    
 *    
 *  
 *  
 * 
 *
 */

// BinarySearchTree class 
// Construction: with no initializer
//
// Public Operations:
// void insert(x)       -> Insert x
// void remove(x)       -> Remove x
// void removeMin()     -> Remove minimum item
// Comparable find(x)   -> Return item that matches x
// Comparable findMin() -> Return smallest item
// Comparable findMax() -> Return largest item
// boolean isEmpty()    -> Return true if empty; else false
// void makeEmpty()     -> Remove all items
// Errors:
// Exception are thrown by insert, remove, and removeMin if warranted


// E can be any type of generic data, it can be replaced with T or AnyType.
// BinarySearchTree <E extends Comparable<? super E>>
// it is saying that the comparable's generic type has to be a superclass of T.
public class BinarySearchTree <AnyType extends Comparable<? super AnyType>>{
	
	protected BinaryNode<AnyType> root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public void insert( AnyType x )
    {
        root = insert( x, root );
    }
	
	public void remove(AnyType x) {
		root = remove(x, root);
	}
	
	public void removeMin() {
		root = removeMin(root);
	}
	
	public AnyType findMin() {
		return elementAt(findMin(root));
		
	}
	
	public AnyType findMax() {
		return elementAt(findMax(root));
		}
	
	public AnyType find(AnyType x) {
		return elementAt(find(x, root));
		}
	
	public void makeEmpty() {
		root = null;
		
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	
	
	// Internal method------------------------------------------
	
	/**
	 * Internal method to get element field.
	 * @param t the node
	 * @return the element field or null if t is null.
	 */
	private AnyType elementAt(BinaryNode<AnyType> t) {
		return t == null ? null : t.element;
		
	}
	/**
	 * Internal method to find an item in a subtree.
	 * @param x is item to search for.
	 * @param t the node that roots the tree.
	 * @return node containing the matched item.
	 */
	private BinaryNode<AnyType> find(AnyType x, BinaryNode<AnyType> t){
		
		while(t != null) {
			
			if(x.compareTo(t.element)<0)
				t = t.left;
			else if(x.compareTo(t.element)>0)
				t = t.right;
			else
				return t; // Match
		}
		return null;   // Not found
		
	}
	/**
	 * Internal method to find the smallest item in a subtree.
	 * @param t the node that roots the tree.
	 * @return node containing the smallest item
	 */
	protected BinaryNode<AnyType> findMin(BinaryNode<AnyType> t){
		if( t != null)
			while(t.left != null)
				t = t.left; // Because of call by value, the actual argument(root) is not changed.
		return t;
	}
	
	/**
	 * Internal method to find the largest item in a subtree.
	 * @param t the node that roots the tree.
	 * @return node containing the largest item.
	 */
	private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t){
		if(t != null)
			while(t.right != null)
				t = t.right;
		return t;
	}
	
	/**
	 * Internal recursive method to insert into a subtree.
	 * @param x the item to insert.
	 * @param t the node that roots the tree.
	 * @return the new root.
	 * @throws DuplicateItemException if x is already present
	 */
	protected BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t){
		if (t == null)
			t = new BinaryNode<AnyType>(x);
		else if(x.compareTo(t.element)<0)
			t.left = insert(x, t.left); // recursive insert
		else if(x.compareTo(t.element)>0)
			t.right = insert(x, t.right); // recursive insert
		else
			throw new DuplicateItemException(x.toString()); // Duplicate
		return t;
		
	}
	/**
	 * Internal method to remove minimum item from a subtree.
	 * @param t the node that roots the tree.
 	 * @return the new root.
 	 * @throws ItemNotFoundException if t is empty.
	 */
	protected BinaryNode<AnyType> removeMin(BinaryNode<AnyType> t){
		if (t == null)
			throw new ItemNotFoundException();
		else if(t.left != null) {
			t.left = removeMin(t.left);
			return t;
		}
		else
			return t.right;
		
	}
	
	/**
	 * Internal method to remove from a subtree.
	 * @param x the item to remove.
	 * @param t the node that roots the tree.
	 * @return the new root.
	 * @throws ItemNotFoundException if x is not found.
	 */
	protected BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t){
		
		if(t == null)
			throw new ItemNotFoundException(x.toString());
		if(x.compareTo(t.element)<0)
			t.left = remove(x, t.left);
		else if(x.compareTo(t.element)>0)
			t.right = remove(x, t.right);
		else if(t.left != null && t.right != null) {
			t.element = findMin(t.right).element; // Two children
			t.right = removeMin(t.right);
		}
		else
			t = (t.left != null) ? t.left : t.right;
		return t;
		
	}
	
	
	

	
}
