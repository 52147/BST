package binarytree;

import java.util.NoSuchElementException;

/**
 * = preorder traversal =
 * 
 * - The preorder traversal is the same as the inorder traversal,
 *   except that a node is declared visited after it has been popped the first time.
 * - Prior to returning, the iterator pushes the right child onto the stack and then pushed the left child.
 * - Note the order:
 *   - We want the left child to be processed before the right child,
 *     so we must push the right child first and the left child second.
 *     
 * - We could derive the PreOrder class from the InOrder or PostOrder class,
 *   but doing so would be wasteful because the stack no longer needs to maintain 
 *   a count of the number of times an object has been popped.
 * - Consequently, the PreOrder class is derived directly from TreeIterator.
 * - The resulting class with implementations of the constructor and first method is shown below.   
 * 
 *
 * - We added a stack of tree nodes to the TreeIterator data fields.
 * - The constructor and first methods are similar to those already presented.
 * - advance is simpler:
 *   - We no longer need a for loop.
 *   - As soon as a node is popped, it becomes the current node.
 *   - We then push the right child and the left child, if they exist.
 *   
 * 
 */

// PreOrder class; maintains "current position"
//
// Construction: with tree to which iterator is bound
//
// Public Operations:
// boolean isValid()   -----> True if at valid position in tree
// AnyType retrieve()  -----> Return item in current position
// void first()        -----> Set current position to first
// void advance()      -----> Advance(prefix)
// Errors:
// Exceptions thrown for illegal access or advance
public class PreOrder<AnyType> extends TreeIterator<AnyType> {
	
	/**An internal stack of visted nodes.*/
	private Stack<BinaryNode<AnyType>> s; // Stack of BinaryNode objects
	
	/**
	 * Construct the iterator.
	 * The current position is set to null.
	 */
	public PreOrder(BinaryTree<AnyType> theTree) {
		super(theTree);
		s = new ArrayStack<BinaryNode<AnyType>>();
		s.push(t.getRoot());
	}
	
	/**
	 * Set the current position to the first item,
	 * according to the preorder traversal scheme.
	 */
	public void first() {
		s.makeEmpty();
		if(t.getRoot() != null) {
			s.push(t.getRoot());
			advance();
		}
	}
	
	/**
	 * Advance the current position to the next node in the tree,
	 * according to the preorder traversal scheme.
	 * @throws NoSuchElementException if iteration has been exhausted prior to the call.
	 */
	public void advance() {
		
		if(s.isEmpty()) {
			if(current == null)
				throw new NoSuchElementException("PreOrder Advance");
			current = null;
			return;
		}
		
		current = s.topAndPop();
		
		if(current.getRight() != null)
			s.push(current.getRight());
		if(current.getLeft() != null)
			s.push(current.getLeft());
		
	}

}
