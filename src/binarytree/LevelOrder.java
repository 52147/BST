package binarytree;
/**
 * = level-order traversals =
 * 
 * - We close by implementing a level-order traversal,
 *   which processes nodes starting at the root and going from top to bottom, left to right.
 * - The name is derived from the fact that we output level 0 nodes(the root),
 *   level 1 nodes(root's children), level 2 nodes(grandchildren of the root), and so on.
 * 
 * - A level-order traversal is implemented by using a queue instead of a stack.
 * - The queue stores nodes that are yet to be visited.
 * - When a node is visited, its children are placed at the end of the queue
 *   where they are visited after the nodes that are already in the queue have been visited.
 * - This procedure guarantees that nodes are visited in level order.
 * 
 * - The LevelOrder class shown below looks very much like the PreOrder class.
 * - The only differences are that we use a queue instead of a stack 
 *   and that we enqueue the left child and then the right child, rather than vice versa.
 * 
 * - Note that the queue can get very large.
 * - In the worst case, all the nodes on the last level(possibly N/2)
 *   could be in the queue simultaneously.
 *   
 * - The level-order traversal implements a more general technique known as breadth-first search.  
 *
 */

import java.util.NoSuchElementException;

// LevelOrder class; maintains "current position"
// according to a level-order traversal
// 
// Construction: with tree to which iterator is bound
//
// Public Operations:
// boolean isValid()   -----> True if at valid position in tree
// AnyType retrieve()  -----> Return item in the current position
// void first()        -----> Set current position to first
// void advance()      -----> Advance (prefix)
// Errors:
// Exceptions thrown for illegal access or advance

/**
 * 
 * Level-order iterator class.
 *
 * @param <AnyType>
 */
public class LevelOrder<AnyType> extends TreeIterator<AnyType> {
	
	/**An internal queue of visited nodes*/
	private Queue<BinaryNode<AnyType>> q; // Queue of BinaryNode objects.
	
	/**
	 * Construct the iterator.
	 * The current position is set to null.
	 * @param theTree the tree to which the iterator is permanently bound.
	 */
	public LevelOrder(BinaryTree<AnyType> theTree) {
		super(theTree);
		q = new ArrayQueue<BinaryNode<AnyType>>();
		q.enqueue(t.getRoot());
	}
	
	/**
	 * Set the current position to the first item.
	 * according to the level-order traversal scheme.
	 */
	public void first() {
		q.makeEmpty();
		if(t.getRoot() != null) {
			q.enqueue(t.getRoot());
			advance();
		}
	}
	
	/**
	 * Advance the current position to the next node in the tree,
	 * according to the level-order traversal scheme.
	 * @throws NoSuchElementException if iteration has been exhausted prior to the call.
	 */
	public void advance() {
		if(q.isEmpty()) {
			if(current == null)
				throw new NoSuchElementException("LevelOrder advance");
			current = null;
			return;
		}
		
		current = q.dequeue();
		
		if(current.getLeft() != null)
			q.enqueue(current.getLeft());
		if(current.getRight() != null)
			q.enqueue(current.getRight());
		
	}

}
