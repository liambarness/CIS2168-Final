public class BinarySearchTree {

    private Node root;

    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    public void inorderTraversal() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    public void preorderTraversal() {
        preorderRec(root);
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    public void postorderTraversal() {
        postorderRec(root);
    }

    private void postorderRec(Node root) {        /* Let us create following BST
        50
     /     \
    30      70
   /  \    /  \
  20   40  60   80 */

        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.value + " ");
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

                /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */


        System.out.println("Inorder traversal:");
        bst.inorderTraversal();

        System.out.println("\nPreorder traversal:");
        bst.preorderTraversal();

        System.out.println("\nPostorder traversal:");
        bst.postorderTraversal();
    }
}
