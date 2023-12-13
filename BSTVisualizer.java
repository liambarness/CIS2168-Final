public class BSTVisualizer {

    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    static class BinarySearchTree {
        Node root;

        BinarySearchTree() {
            root = null;
        }

        void insert(int key) {
            root = insertRec(root, key);
        }

        Node insertRec(Node root, int key) {
            if (root == null) {
                root = new Node(key);
                return root;
            }

            if (key < root.key) {
                root.left = insertRec(root.left, key);
            } else if (key > root.key) {
                root.right = insertRec(root.right, key);
            }

            return root;
        }

        void inorder() {
            inorderRec(root);
        }

        void inorderRec(Node root) {
            if (root != null) {
                inorderRec(root.left);
                System.out.print(root.key + " ");
                inorderRec(root.right);
            }
        }
    }

    public static void printBinaryTree(Node root, int level) {
        if (root == null) {
            return;
        }
        printBinaryTree(root.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t");
            }
            System.out.println("|-------" + root.key);
        } else {
            System.out.println(root.key);
        }
        printBinaryTree(root.left, level + 1);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal of the given tree:");
        tree.inorder();

        System.out.println("\n\nVisual representation of the tree:");
        printBinaryTree(tree.root, 0);
    }
}

