package binarytreepractice1;

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
 *        (b) a Huffman coding tree
 *        
 *           ()
 *           /\
 *          a  ()  
 *             /\
 *            () d
 *            /\
 *            b c
 *       
 *    - Other uses of the binary tree are in binary search trees, which allow algorithm time insertions and accessing of items
 *      , and priority queues, which support the access and deletion of the minimum in a collection of items.
 *    - Several efficient implementations of priority queus use trees.
 *       
 * 
 * 
 *
 */

public class FileSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}  ´µ 
