package overview;
/**
 * 
 * = Binary Search Tree =
 * 
 * - Introduction:
 * 
 *   - A Binary Search Tree is a special form of a binary tree.
 *   - The value in each node must be greater than(or equal to) any values in its left subtree 
 *     but less than(or equal to) any values in its right subtree.
 *     
 *   - The goal of this card is to:
 *   
 *     1. Understand the properties of a binary tree
 *     2. Be able to do basic operations in a binary search tree
 *     3. Understand the concept of a height-balanced binary search tree.
 *     
 *     
 * = Definition of the Binary Search Tree =
 * 
 * - A binary search tree (BST), a special form of a binary tree, satisfies the binary search property:
 *   1. The value in each node must be greater than (or equal to) any values stored in its left subtree.
 *   2. The value in each node must be less than(or equal to) any values stored in its right subtree.
 *   
 *   
 * - We have exercises for you to validate a BST.
 * - You can use the property we mentioned above to determine whether a binary tree is a BST or not.
 * - The recursive thinking we have introduced in the previous chapter might help you with this problem.
 * 
 * - Like a normal binary tree, we can traverse a BST in preorder, inorder, postorder or level-order.
 * - However, it is noteworthy that inorder traversal in BST will be in ascending order.
 * - Therefore, the inorder traversal is the most frequent used traversal method of a BST.
 * 
 * 
 * - We also have exercises for you to find the inorder successor in a BST.
 * - Obviously, you can do the inorder traversal to find the inorder successor in a BST.
 * - But please try to apply the property of the BST we have learned to find out a better way to solve this problem.
 *
 */

/**
 * 
 * 98. Validate Binary Search Tree
 * 
 * 
 * Q:
 * Check whether is BST
 *  yes => retrun true
 *  no => return false
 *  
 *  valid BST:
 *  
 *  1. left node must be smaller than node
 *  2. right node must be larger than node
 *  3. Both left subtree and right subtree must be BST
 *  
 *   
 *  Approach:
 *  1. Recursive Traversal with valid Range(use dfs)
 *  2.
 *  3.
 *  4.
 *  
 *  
 *  = 1. Recursive Traversal with valid Range(use dfs) =
 *  
 *  1. valid bst:
 *      - 1. empty tree
 *        2. left < root && right > root
 *            
 *  - use recursive to check left and right in the valid range
 *  recursive call the right and left node dfs and change the valid range (low and high)
 *  - the first node range is unlimited, so we set the first call low and high null
 *  - the left subtree low is unlimited, high is smaller that root
 *    the right subtree high is unlimited, low is bigger that root
 *
 */
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(){}
	
	TreeNode(int val){
		this.val = val;
	}
	
	TreeNode(int val, TreeNode left, TreeNode right){
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class ValidateBinarySearchTree {
	
	public boolean validate(TreeNode root, Integer low, Integer high) {
		
		// empty tree are valid bst
		if(root == null) {
			return true;
		}
		
		// The current node's value must between low and high.
		if((low != null && root.val <= low) || (high != null && root.val >= high)) {
			return false;
		}
		
		// Check the left and right subtree
		// The left and right subtree must also be valid.
		// 
		return validate(root.right, root.val, high) && validate(root.left, low, root.val);
	}
	
	public boolean isValidBST(TreeNode root) {
		return validate(root, null, null);
	}
	

}
