package binarysearchtree;

/**
 * 
 * = Binary Search tree =
 * 
 *  - The binary search tree satisfies the search order property; that is,
 *     for every node X in the tree, the values of all the keys in the left subtree are smaller than the key in X
 *     and the values of all the keys in the right subtree are larger than the key in X.
 *     
 *     - The tree shown in figure 
 *       (a) is a binary search tree
 *       (b) is not because key 8 does not belong in the left subtree of key 7.
 *       
 *       - Two binary tree:
 *         (a) a search tree      
 *         
 *             7
 *            /\
 *           2  9
 *          /\
 *         1  5
 *            /
 *            3
 *            
 *       (b) not a search tree
 *          
 *                7
 *               /\
 *              2  9
 *             /\
 *            1  5
 *               /\
 *              3  8 -> key 8 does not belong in the left subtree 
 *     
 *     
 *     - The binary search tree property implies that all the items in the tree can be ordered consistently 
 *       (an inorder traversal yields the items in sorted order. )
 *       - This property also does not allow duplicate items.
 *     
 *     - We could easily allow duplicate keys; storing different items having identical keys in a secondary structure is generally better.
 *     - If these items are exact duplicates, having one items keeping a count of the number of duplicates is best.    
 *     
 *     
 * = the operations of binary search tree =
 * 
 *   - The operations on a binary search tree are simple to visualize.
 *   - We can perform a find operation by starting at the root and then repeatedly branching either left of right, 
 *     depending on the result of a comparison.
 *     - For instance
 *       to find 5 in the binary search tree shown in figure (a) below
 *       - we start at 7 and go left.
 *       - This take us to 2, so we go right, which takes us to 5.
 *            
 *       to look for 6, we follow the same path.
 *       - At 5, we would go right and encounter a null link and thus not find 6
 *       - Figure (b) shows that 6 can be inserted at the point at which the unsuccessful search terminated.
 *       
 *       Insert of node 6
 *       (a) before      
 *         
 *             7
 *            /\
 *           2  9
 *          /\
 *         1  5
 *            /
 *            3
 *            
 *       (b) after the insertion of 6
 *          
 *                7
 *               /\
 *              2  9
 *             /\
 *            1  5
 *               /\
 *              3  6 
 *              
 *              
 *              
 *  Method:
 *    
 *   - The binary search tree efficiently supports the findMin and findMax operations.
 *   
 *     FindMin()
 *   
 *     - To perform a findMin, we start at the root and repeatedly branch left as long as there is a left child.
 *     - The stoping point is the smallest element.
 *   
 *     FindMax()
 *   
 *     - The findMax operation is similar, except that branching is to the right.
 *   
 *   Time complexity: logarithm
 *    - Note that the cost of all the operations is proportional to the number of nodes on the search path.
 *    - The cost tends to be logarithmic, but it can be linear in the worst case.
 *   
 *   Remove() 
 *   
 *   - The hardest operation is remove.
 *   - Once we have found the node to be remove, we need to consider several possibilities.
 *   - The problem is that the removal of a node may disconnect parts of the tree.
 *   - If that happens, we must carefully reattach the tree and maintain the binary search tree property.
 *   - We also want to unnecessarily deep because the depth of the tree affects the running time of the tree algorithms.
 *   
 *   
 *   - When we are designing a complex algorithm, solving rhe simplest case first is often easiest,
 *     leaving the most complicated case until last.
 *   - Thus, in examining the various cases, we start with the easiest.
 *   
 *     - If the node is a leaf, its removal does not disconnect the tree, so we delete it immediately.
 *     - If the node has only one child, we can remove the node after adjusting its parent's child link to bypass the node.
 *     - This is illustrated in figure below, with the removal of node 5.
 *     
 *     
 *     Deletion of node 5 with one child
 *       (a) before      
 *         
 *             7
 *            /\
 *           2  9
 *          /\
 *         1  5
 *            /
 *            3
 *            
 *       (b) after
 *          
 *                7
 *               /\
 *              2  9
 *             /\
 *            1  \
 *               /
 *              3               
 *              
 *              
 *    - Note that removeMin and removeMax are not complex because the affected nodes are either leaves or have only one child.
 *    - Note also that the root is special case because it does not have a parent.
 *    - However when the remove method is implemented, the special case is handled automatically.
 *    
 *    - The complicated case deals with a node having 2 children.
 *    - The general strategy is to replace the item in this node with the smallest item in the right subtree,
 *      and then remove that node(which is now logically empty). 
 *      
 *    - The second remove is easy to do because, as just indicated, the minimum node in a tree does not have a left child.
 *    - Figure below shows an initial tree and the result of removing node 2.
 *    - We replace the node with the smallest node 3 in its right subtree and then remove 3 from the right subtree.
 *    
 *    - Note that in all cases removing a node does not make the tree deeper.
 *      (The deletion can, however, increase the average node depth if a shallow node is removed.)
 *      - Many alternatives do make the tree deeper; thus there alternatives are poor options.
 *    
 *       Deletion of node 2 with 2 children:
 *       
 *       (a) before      
 *         
 *             7
 *            /\
 *           2  9
 *          /\
 *         1  5
 *            /
 *           3
 *            \
 *             4
 *            
 *       (b) after
 *          
 *                7
 *               /\
 *              3  9
 *             /\
 *            1  5
 *               /
 *              /
 *             4  
 *             
 *  = Java implementation =
 *  
 *   - To keep the Java features from clogging up the code, we introduce a few simplifications.
 *   
 *   - First, figure below shows the BinaryNode class.
 *   - In the new BinaryNode class, we make everything package-visible.
 *   - More typically, BinaryNode would be a nested class.
 *   - The BinaryNode class contains the usual list of data members(the item and two linkd(left and right)).
 *              
 *              
 *              
 */

// Basic node stored in unbalanced binary search trees.
// Note that this class is not accessible outside this package
public class BinaryNode<AnyType> {
	
	// Date; accessible by other package routines
	AnyType element; // The data in the node
	BinaryNode<AnyType> left; // Left child
	BinaryNode<AnyType> right; // Right child
	
	
	// Constructor
	BinaryNode(AnyType theElement){
		element = theElement;
		left = right = null;
	}
	
	
	

}
