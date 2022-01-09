package binarytree;

/**
 * = postorder traversal =
 * 
 * - The postorder traversal is implemented by using to store the current state.
 * - The top of the stack will represent the node that we are visiting at some instant in the postorder traversal.
 * - However, we may be at one of three places in the algorithm:
 * 
 *     1. About to make a recursive call to the left subtree
 *     2. About to male a recursive call to the right subtree
 *     3. About to process the current node
 *     
 *     - Consequently, each node is placed on the stack 3 times during the course of the traversal.
 *     - If a node is popped from the stack a third time, we can mark it as the current node to be visited.
 *     
 *     - Otherwise, the node is being popped for either the first time or the second time.
 *     - In this case, it is not yet ready to be visited, so we push it back onto the stack
 *       and simulate a recursive call.
 *     - If the node was popped for a first time, we need to push the left child(if it exists) onto the stack.
 *     - Otherwise, the node was popped for as second time, ams we  push the right child(if it exists) onto the stak.
 *     - In any event, we then pop the stack, applying the same set. 
 *     - Note that, when we pop the stack, we are simulating the recursive call to the appropriate child.
 *     
 *     - If the child does not exist and thus was never pushed onto the stack,
 *       when we pop the stack we pop the original node again.
 *       
 *     - Eventually, either the process pops a node for the third time or the stack empties.
 *     - In the latter case, we have iterated over the entire tree.
 *     - We initialize the algorithm by pushing a reference to the root onto the stack.
 *       
 *       
 *       
 *     
 *     
 *   
 *  - Let us trace through the postorder traversal.
 *  - We initialize the traversal by pushing root a onto the stack.
 *  - The first pop visits a.
 *  - This is a's first pop, so it is placed back on the stack, and we push its left child, b, onto the stack.
 *  
 *  - Next b is popped.
 *  - It is b's first pop, so its is placed back on the stack.
 *  - Normally, b's left child would the be pushed, but b has no left child, so nothing is pushed.
 *  - Thus the next pop reveals b for the second time, b is placed back on the stack,   
 *     
 * 
 */

// PostOrder class; maintains "current position"
// according to a postorder traversal
// Construction: with tree to which iterator is bound
//
// Public Operations:
// 1. boolean isValid()
// 2. AnyType retrieve()
// 3. void first()
// 4. void advance()
// Errors:
// Exceptions thrown for illegal access or advance
//
public class PostOrder<AnyType> extends TreeIterator<AnyType> {
	
	protected Stack<StNode<AnyType>> s; // The stack StNode objects
	
	protected static class StNode<AnyType>{
		
		StNode(BinaryNode<AnyType> n ){
			node = n;
			timesPopped = 0;
		}
		BinaryNode<AnyType> node;
		int timesPopped;
		
	}
	
	

}
