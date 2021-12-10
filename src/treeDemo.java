/**
 * 
 * = Tree = 
 * 
 * - The tree is a fundamental structure in a computer science.
 * - Almost all operating systems store files in trees or treelike structures.
 * - Trees are used in complier design, text processing, and searching algorithms.
 * 
 * -  General trees: 
 * 
 *   - Trees can be defined in 2 ways:
 *  
 *     -1.  non recursively 
 *     -2.  recursively
 *    
 *    
 *    
 *    
 * - 1. Non recursively Tree:
 * 
 *    - Non recursively tree consists of a set of nodes and a set of directed edges that connect pairs of nodes.
 *    - In this article, we consider only rooted trees.
 *    
 *    - A rooted tree has the following properties.
 *    
 *      - One node is distinguished as the root.
 *      - Every node c, except the root, is connected by an edge from exactly one other node p.
 *        Node p is c's parent, and c is one of p's children.
 *      - A unique path traverses from the root to each other.
 *        The number of edges that must be followed is the path length.
 *          
 *   - Parents and children are naturally defined.
 *   - A directed edge connects the parent to the child.
 *   
 *   -Figure 18.1 illustrates a tree.
 *   
 *    - The root node is A;
 *    - A's children are B, C, D and E.
 *    - Because A is the root, it has no parents.
 *      - for example
 *        - B's parent is A.
 *    - Node that has no children is called a leaf.
 *      - The leaves in this tree are C, F, G, H, I and K.
 *    - The length of the path from A to K is 3 edges, the length if the path from A to A us 0 edges.
 *    
 *        
 *   - N nodes -> N-1 edges
 *   
 *     - A tree with N nodes must have N-1 edges because every node except the parent has an incoming edge.   
 *     
 *     Depth:
 *     
 *     - is the length of the path from the root to the node. 
 *     - Thus the depth of the root is always 0, and the depth of any node is 1 more than the depth of its parent.
 *     
 *     Height:
 *     
 *     - is the length of the path from the node to the deepest leaf.
 *     - Thus the height of E is 2.
 *     - The height of any node is 1 more than the height of its maximum-height child.
 *     - Thus the height of a tree is the height of the root.
 *     
 *     A rooted tree(Non recursive tree):
 *     
 *     A-> B -> F
 *           -> G
 *      -> C
 *      -> D -> H
 *      -> E -> I
 *           -> J -> K 
 *     
 *     Node  Depth  Height      
 *     A      0       3
 *     B      1       1 
 *     C      1       0
 *     D      1       1
 *     E      1       2
 *     F      2       0
 *     G      2       0
 *     H      2       0
 *     I      2       0
 *     J      2       1
 *     K      3       0
 *     
 *     
 *  - Node with the same parent are called siblings; thus B, C, D and E are all siblings.
 *  - If there is a path from node u to node v, then u is an ancestor of v and v is a descendant of u.
 *  - If u != v, then us u a proper ancestor of v and v is a proper descendant of u.
 *  
 *  - The size of a node:
 *  
 *    - The size of a node is the number of descendants the nodes has(including the node itself).
 *    - Thus the size of B is 3, and the size of C is 1.
 *    - The size of a tree is the size of the root.
 *    - Thus the size of the tree shown in Figure 18.1 is the size of its root A, or 11.
 *  
 *  
 *  
 *  - 2. Recursive tree (binary tree)
 *  
 *     - An alternative definition of the tree is recursive:
 *       - Either a tree is empty or its consist of a root and zero or more nonempty subtrees.
 *         T1, T2, T3...., Tk
 *         each of whose roots are connected by an edge from the root.
 *     - In binary trees, we may allow some of the subtrees to be empty.
 *     
 *     A recursively tree:
 *     
 *     Root -> T1
 *          -> T2
 *          -> T3
 *          ...
 *          ...
 *          ...
 *          -> Tk
 *          
 * 
 *          
 */
public class treeDemo {

}
