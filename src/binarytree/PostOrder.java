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
 * 
 */
public class PostOrder<AnyType> extends TreeIterator<AnyType> {

}
