package binarytree;

import java.util.NoSuchElementException;

/**
 * = Inorder traversal =
 * 
 * - The inorder traversal is the same as the postorder traversal,
 *   except that a node is declared visited after it is popped a second time.
 * - Prior to returning, the iterator pushes the right child(if it exists) onto the stack
 *   so that the next call to advance can continue by traversing the right child.
 * - Because this action is so similar to a postorder traversal,
 *   we derive the InOrder class from the PostOrder class(even though an IS-A relationship does not exist).
 * - The only change is the minor alteration to advance.
 * 
 *
 */

// InOrder class; maintains "current position"
// according to an inorder traversal
//
// Construction: with tree to which iterator is bound
//
// Public Operations:
// Same as TreeIterator
// Errors:
// Exceptions thrown for illegal access or advance

public class InOrder<AnyType> extends PostOrder<AnyType> {
	
	/**
	 * Construct the iterator.
	 * The current position is set to null.
	 * @param theTree the tree to which the iterator is permanently bound.
	 */
	public InOrder(BinaryTree<AnyType> theTree) {
		super(theTree);
	}
	
	/**
	 * Advance the current position to the next node in the tree,
	 * according to the inorder traversal scheme.
	 * @throws NoSuchElementException if iteration has been exhausted prior to the call.
	 */
	public void advance() {
		if(s.isEmpty()) {
			if(current == null)
				throw new NoSuchElementException("InOrder advance");
			current = null;
			return;
		}
		
		StNode<AnyType> cnode;
		for(;;) {
			cnode = s.topAndPop();
			
			if(++cnode.timesPopped == 2) {
				current = cnode.node;
				if(cnode.node.getRight()!= null)
					s.push(new StNode<AnyType>(cnode.node.getRight()));
				return;
			}
			
			// First time through
			s.push(cnode);
			
			if(cnode.node.getLeft()!= null)
				s.push(new StNode<AnyType>(cnode.node.getLeft()));
		}
	}

}
