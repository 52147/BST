package binarytree;

import java.util.NoSuchElementException;

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
 *     - A quick summary:
 *       - The stack contains node that we have traversed but not yet completed.
 *       - When a node is pushed onto the stack, the counter is 1, 2, 3 as follows:
 *         
 *         1. If we are about to process the node's left subtree.
 *         2. If we are about to process the node's right subtree.
 *         3. If we are about to process the node itself.     
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
 *    and its right child, d, is pushed onto the stack.
 *  - The next pop produces d for the first time, and d is pushed back onto the stack.
 *  - No other push is performed because d has no left child.
 *  - Thus d is popped for the second time and is pushed back, but as it has no right child,
 *    nothing else is pushed.
 *  - Therefore the next pop yields d for the third time, and d is marked as a visited node.
 *  
 *  - The next node popped is b, and as this pop is b's third, it is marked visited.
 *  
 *  - Then a is popped for the second time, and it is pushed back onto the stack along with its right child, c.
 *  - Next, c is popped for the first time, so it is pushed back, along with its left child, e.
 *  - Now e is popped, pushed, popped, pushed, and finally popped for the third time(typical for lead nodes).
 *  - Thus e is marked as a visited node.
 *  - Next, c is popped for the second time and is pushed back onto the stack.
 *  - However, it has no right child, so it is immediately popped for the third time and marked as visited.
 *  
 *  - Finally, a is popped for the third time and marked as visited.
 *  - At this point, the stack is empty and the postorder traversal terminates.
 *  
 *  Algorithm:
 *  
 *  - The PostOrder class implemented directly from the algorithm described previously and is show.
 *  
 *  - The StNode nested class represents the objects placed on the stack.
 *  - It contains a reference to a node and an integer that stores the number of times the items has been popped from the stack.
 *  - An StNode object is always initialized to reflect the fact that it has not yet been popped from the stack.
 *    
 *  - The PostOrder class is derived form TreeIterator and adds an internal stack to the inherited data members.
 *  - The PostOrder class initialized by initializing the TreeIterator data members and then pushing the root onto the stack.
 *  - This process is illustrated in the constructor.
 *  - Then first is implemented by clearing the stack, pushing the root, and calling advance.
 *  
 *  - It follows the outline almost verbatim.
 *  - 
 *  
 *    
 *    
 *    
 *  
 *      
 *    Stack states during postorder traversal:
 *      
 *            a 
 *            /\
 *           b  c
 *           \  /
 *           d  e
 *           
 *           
 *     1.  a 0
 *     
 *     2.  b 0
 *         a 1
 *     
 *     3.  b 1
 *         a 1
 *         
 *     4.  d 0
 *         b 2
 *         a 1
 *     
 *     5.  d 1
 *         b 2
 *         a 1
 *     
 *     6.  d 1
 *         b 2
 *         a 1
 *     
 *     7.  d 2
 *         b 2                       
 *         a 1                
 *     
 *     8.  b 2
 *         a 1
 *         
 *     9.  b 2
 *         a 1
 *          d
 *    
 *    10.  a 1
 *          b
 *     
 *    11.  c 0
 *         a 2
 *         
 *    12.  e 0
 *         c 1
 *         a 2
 *    
 *    13.  e 2           
 *         c 1
 *         a 2
 *    
 *    14.  c 1
 *         a 2
 *          e
 *          
 *    15.  c 2
 *         a 2
 *    
 *    16.  a 2
 *          c
 *          
 *    17.   a               
 *    
 *      
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
class PostOrder<AnyType> extends TreeIterator<AnyType>
{
    /**
     * Construct the iterator.
     * The current position is set to null.
     * @param theTree the tree to which the iterator is
     *     permanently bound.
     */
    public PostOrder( BinaryTree<AnyType> theTree )
    {
        super( theTree );
        s = new ArrayStack<StNode<AnyType>>( );
        s.push( new StNode<AnyType>( t.getRoot( ) ) );
    }

    /**
     * Set the current position to the first item, according
     * to the postorder traversal scheme.
     */
    public void first( )
    {
        s.makeEmpty( );
        if( t.getRoot( ) != null )
        {
            s.push( new StNode<AnyType>( t.getRoot( ) ) );
            advance( );
        }
    }

    /**
     * Advance the current position to the next node in the tree,
     *     according to the postorder traversal scheme.
     * @throws NoSuchElementException if iteration has
     *     been exhausted prior to the call.
     */
    public void advance( )
    {
        if( s.isEmpty( ) )
        {
            if( current == null )
                throw new NoSuchElementException( "PostOrder Advance" );
            current = null;
            return;
        }

        StNode<AnyType> cnode;

        for( ; ; )
        {
            cnode = s.topAndPop( );

            if( ++cnode.timesPopped == 3 )
            {
                current = cnode.node;
                return;
            }

            s.push( cnode );
            if( cnode.timesPopped == 1 )
            {
                if( cnode.node.getLeft( ) != null )
                    s.push( new StNode<AnyType>( cnode.node.getLeft( ) ) );
            }
            else  // cnode.timesPopped == 2
            {
                if( cnode.node.getRight( ) != null )
                    s.push( new StNode<AnyType>( cnode.node.getRight( ) ) );
            }
        }
    }

      // An internal class for tree iterators
    protected static class StNode<AnyType>
    {
        BinaryNode<AnyType> node;
        int timesPopped;

        StNode( BinaryNode<AnyType> n )
        {
           node = n;
           timesPopped = 0;
        }
    }
    
   /** An internal stack if visited nodes. */
    protected Stack<StNode<AnyType>> s;    // The stack of StNode objects
}
