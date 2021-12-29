package binarytree;

import java.util.NoSuchElementException;

/**
 * - Must we use recursion to implement the traversals?
 * 
 * - The answer is clearly no because, recursion is implemented by using a stack.
 * - Thus we could keep our own stack.
 * - We might expect that a somewhat faster program could result
 *   because we can place only the essentials on the stack
 *   rather than have the complier place an entire activation record on the stack.
 *   
 * - The difference in speed between a recursive and nonrecursive algorithm
 *   is very dependent on the platform, and on modern computers may well be negligible.  
 * 
 * - It is possible for instance, that if an array-based stack is used,
 *   the bounds checks that must be performed for all array access
 *   could be significant;
 *   the run-time stack might not be subjected to such tests
 *   if an aggressive optimizing complier proves that a stack underflow is impossible.
 * 
 * - Thus in many cases, the speed improvement does not justify the effort involved in
 *   removing recursion.
 * - Even so, knowing how to do so is worthwhile,
 *   in case your platform is one that would benefit from recursion removal and
 *   also because seeing how a program is implemented nonrecursiively can sometimes 
 *   make the recursion clearer.
 *   
 *   
 * - We write 3 iterator classes, each in the spirit of the linked list.
 * - Each allows us to go to the first node, advance to the next node,
 *   test we have gone past the last node, and access the current node.
 * - The order in which nodes are accessed is determined by the type of traversal.
 * - We also implement a level-order traversal,
 *   which is inherently nonrecursive and in fact uses a queue instead of
 *   a stack and is similar to the preorder traversal.
 *   
 *   
 *   - provides an abstract class for tree iteration.
 *   - Each iterator stores a reference to the tree root and an indication of the current node.
 *     (In these implementations, once the iterators have been constructed,
 *      structurally modifying the tree during an iteration is unsafe because
 *      references may become stale.)
 *   - These are initialized on the constructor.
 *   - They are protected to allow the derived class to access them.
 *   
 *   - Four method:
 *     - The isValid and retrieve methods are invariant over the hierarchy,
 *       so an implementation is provided and they are declared final.  
 *       
 *     - The abstract methods first and advance must be provided by each type of iterator.
 *     - This iterator is similar to the linked list iterator,
 *       expect that here the first method is part of the tree iterator,
 *       whereas in the linked list the first method was part of the list class itself.
 *   
 *
 */

// TreeIterator class; maintains "current position"
//
// Construction: with tree to which iterator is bound
//
// Public Operations:
// first and advance are abstract; others are final
// boolean isValid()  -----> True if at valid position in tree
// AnyType retrieve() -----> Return item in current position
// void first()       ------> Set current position to first
// void advance()     -----> Advance(prefix)
// Errors:
// Exceptions thrown for illegal access or advance    
//
abstract class TreeIterator<T> {	
	
	protected BinaryNode<T> t;  // the tree root
	protected BinaryNode<T> current;  // the current position
	
	/**
	 * Construct the iterator. The current position is set to null.
	 * @param theTree the tree to which the iterator is bound.
	 */
	public TreeIterator(BinaryNode<T> theTree) {
		t = theTree;
		current = null;
	}
	
	/**
	 * Test if current position references a valid tree item.
	 * @return true if the current position is not null; false otherwise.
	 */
	final public boolean isValid() {
		return current != null;
	}
	
	/**
	 * Return the item stored in the current position.
	 * @return the stored item.
	 * @exception NoSuchElementException if the current position is invalid.
	 */
	final public T retrieve() {
		if(current == null)
			throw new NoSuchElementException();
		return current.getElement();
	}
	
	abstract public void first();
	abstract public void advance();
	
	

}
