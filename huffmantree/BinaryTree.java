//BinaryTree.java
//* Implementation of Binary Tree data structure.
//* Code for self-reading is at the bottom of the class.

package huffmantree;

import java.util.Scanner;

/**
 * Class for a binary tree that stores any type E objects.
 * @author Koffman and Wolfgang
 **/
public class BinaryTree<E>  {

    /*<listing chapter="6" number="1">*/
    /** Class to encapsulate a tree node. */
    protected static class Node<E>  {
        // Data Fields

        /** The information stored in this node. */
        protected E data;
        /** Reference to the left child. */
        protected Node<E> left;
        /** Reference to the right child. */
        protected Node<E> right;

        // Constructors
        /**
         * Construct a node with given data and no children.
         * @param data The data to store in this node
         */
        //This constructor should be protected, not public,
        // because classes that are not subclasses of BinaryTree do not directly use Node.
        protected Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }

        // Methods
        /**
         * Returns a string representation of the node.
         * @return A string representation of the data fields
         */
        //must be public because it overrides what's in class Object.
        @Override
        public String toString() {
            return data.toString();
        }
    }
    /*</listing>*/
    
    // Data Field
    /** The root of the binary tree */
    //use the access modifier protected to give family member classes the direct access
    //   to the root data field.
    protected Node<E> root;

    /** Construct an empty BinaryTree1 */
    public BinaryTree() {
        root = null;
    }   

    /**
     * Construct a BinaryTree1 with the specified root.
     * Should only be used by subclasses.
     * @param root The node that is the root of the tree.
     */
    //Use the access modifier protected because we want to hide details of Node class
    //   from non-family member classes (i.e. classes that are not subclasses of BinaryTree).
    protected BinaryTree(Node<E> root) {
        this.root = root;
        //or use the following that makes a copy of the given root node.
//        if (root != null) {
//            //make a copy of the given root data and store it in a new node
//            this.root = new Node<>(root.data);
//            //adjust the new node's left child and right child so that
//            //  they reference the given root node's left child and right child.
//            this.root.left = root.left;
//            this.root.right = root.right;
//        }
//        else {
//            this.root = null;
//        }
    }

    /**
     * Constructs a new binary tree with data in its root,leftTree
     * as its left subtree and rightTree as its right subtree.
     */
    public BinaryTree(E data, BinaryTree<E> leftTree,
            BinaryTree<E> rightTree) {
        root = new Node<E>(data);           //new node: right, left are both null
        if (leftTree != null) {
            root.left = leftTree.root;
        } else {                                        
            root.left = null;               //don't have to do this, root.left is already null
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        } else {                                        
            root.right = null;              //don't have to do this, root.right is already null.
        }
    }

    /**
     * Return the left subtree.
     * @return The left subtree or null if either the root or the left subtree is null
     */
    public BinaryTree<E> getLeftSubtree() {
        if (root != null && root.left != null) { //if there is a left subtree
            return new BinaryTree<E>(root.left);
        } else {
            return null;
        }
    }

    /**
     * Return the right sub-tree
     * @return the right sub-tree or
     *         null if either the root or the right subtree is null.
     */
    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right != null) {   //if there is a right subtree
            return new BinaryTree<E>(root.right);
        } else {
            return null;
        }
    }

    /**
     * Return the data in the root node
     * @return the data in  the root node
     *         or null if the root is null
     */
    public E getData() {
        if (root != null) {
            return root.data;
        } else {
            return null;
        }
    }

    /**
     * Determine whether this tree is a leaf.
     * @return true if the root has no children
     */
    public boolean isLeaf() {
                //empty tree or 1-node tree
        return (root == null || (root.left == null && root.right == null));
    }

    //public wrapper for the private recursive counterpart: preOrderTraverse(...)
    /** get a string containing all data items in this binary tree.
     *    The string is a preorder traversal sequence of this binary tree.
     * @return the preorder traversal sequence of this binary tree as a string.
     */
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //call the private recursive method to do the real job.
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }

    /**
     * Perform a preorder traversal of the binary tree rooted at node.
     * @param node The local root (i.e. the current root node)
     * @param depth The depth of the local root
     * @param sb The string buffer to save the output
     */
    private void preOrderTraverse(Node<E> node, int depth,
            StringBuilder sb) {
          //part of visit-root-node:
          //add a number of spaces that is proportial to the depth value
        for (int i = 1; i < depth; i++) {
            sb.append("  ");
        }
        if (node == null) {         //base case: current root node does not exist
            sb.append("null\n");    //special handling empty tree
        } else {
                //visit root node
            sb.append(node.toString()); //add current root node's data
            sb.append("\n");
                //recursively preorder traverse the left subtree of current root node
            preOrderTraverse(node.left, depth + 1, sb);
                //recursively preorder traverse the right subtree of current root node            
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }

    /*<listing chapter="6" number="2">*/
    /**
     * Method to read a binary tree.
     * @pre The input consists of a preorder traversal
     *      of the binary tree. The line "null" indicates a null tree.
     * @param scan the Scanner attached to the input file
     * @return The binary tree
     */
    public static BinaryTree<String> readBinaryTree(Scanner scan) {
        // Read a line and trim leading and trailing spaces.
        String data = scan.nextLine().trim();
        if (data.equals("null")) { //data (i.e. current root node's data) is "null"
            return null;
        } else {
                //recursively keep reading and building the left subtree of current root node until it's done.
            BinaryTree<String> leftTree = readBinaryTree(scan);
                //recursively keep reading and building the right subtree of current root node until it's done.
            BinaryTree<String> rightTree = readBinaryTree(scan);
                //build and return a new binary tree that has root data in variable data, leftTree as left subtree, rightTree as right subtree.
            return new BinaryTree<String>(data, leftTree, rightTree);
        }
    }
    /*</listing>*/
    
    public static void main(String[] args) {   
        //create binary trees by directly creating & connecting nodes.
        //1. Binary tree of Integer objects
        //    100
        //    /  \
        //   200  30
        //create 3 leaf nodes
        Node<Integer> node100 = new Node<>(100);
        Node<Integer> node200 = new Node<>(200);   
        Node<Integer> node30 = new Node<>(30);    
        
        //make 200 left child of 100
        node100.left = node200;
        //make 30 right child of 100
        node100.right = node30;
        
        //create a binary tree of Integer objects that is rooted at the node for 100
        BinaryTree<Integer> bt4 = new BinaryTree(node100);
        System.out.println("bt4: \n" + bt4); //implicitly call toString()
      
        //2. Binary tree of String objects
        //      "100"
        //     /    \
        //   "200"  "30"
        //create 3 leaft nodes
        Node<String> node100Str = new Node<>("100");
        Node<String> node200Str = new Node<>("200");   
        Node<String> node30Str = new Node<>("30");
        //connect the leaft nodes
        node100Str.left = node200Str;
        node100Str.right = node30Str;
        //create a binary tree of String objects that is rooted at the node for "100".
        BinaryTree<String> bt4Str = new BinaryTree(node100Str);
        System.out.println("bt4Str: \n" + bt4Str);        
        
        //The following was not covered in the lecture. It's for self-reading.
        //3. Binary tree of Character objects        
        //self-practice: create the following tree
        //     '+'
        //    /   \
        //  'x'   'y'
        
        //answer for the practice:
        //create 3 leaft nodes
        Node<Character> nodePlus = new Node<>('+');
        Node<Character> nodeX = new Node<>('x');   
        Node<Character> nodeY = new Node<>('y');
        //connect the leaft nodes
        nodePlus.left = nodeX;
        nodePlus.right = nodeY;
        //create a binary tree of Character objects that is rooted at the node for '+'.
        BinaryTree<Character> exprBT = new BinaryTree(nodePlus);
        System.out.println("exprBT: \n" + exprBT);       
        
    }    
    
    //This constructor was not covered in the lecture. 
    // It's for self-reading.
    /**
     * Construct a BinaryTree with the specified root data.
     * Intended to use by client classes of BinaryTree1.
     * @param E The data item in the root node of the new tree.
     */
    public BinaryTree(E data) {
        //create the root node whose data field: data references the given data item
        root = new Node<>(data);
    }     
    
}
/*</listing>*/

/*---Program Output
bt4: 
100
  200
    null
    null
  30
    null
    null

bt4Str: 
100
  200
    null
    null
  30
    null
    null

exprBT: 
+
  x
    null
    null
  y
    null
    null
*/