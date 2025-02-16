// Node data structure for Binary Search Tree
class BSTNode {
    private BSTNode leftNode; // Left child of the node
    private BSTNode rightNode; // Right child of the node
    private int data; // Value held by the node

    // Constructor for BSTNode class
    public BSTNode(int value) {
        this.data = value; //  Set the node's value
        this.leftNode = null; // No left child initially
        this.rightNode = null; // No rihght child initially
    }

    // Returns value for data
    public int getData() {
        return data;
    }

    // Returns value for left node
    public BSTNode getLeftNode() {
        return leftNode;
    }

    // Returns value for left node
    public void setLeftNode(BSTNode leftNode) {
        this.leftNode = leftNode;
    }

    // Returns value for right node
    public BSTNode getRightNode() {
        return rightNode;
    }

    //Updates the right child node
    public void setRightNode(BSTNode rightNode) {
        this.rightNode = rightNode;
    }
}

// Binary Search Tree (BST) Class
class BST {
    // Method to insert a new value into the BST that provides the methods to manipulate the tree
    public void insert(BSTNode root, int value) {
        // If the root is null, create a new node (base case)
        if (root == null) {
            root = new BSTNode(value);
        } else {
            // Insert in the left subtree if the value is smaller
            if (value < root.getData()) {
                //  Create a new left child node if none exists
                if (root.getLeftNode() == null) {
                    root.setLeftNode(new BSTNode(value));
                } else {
                    // Recursively insert into the left subtree
                    insert(root.getLeftNode(), value);
                }
            } else {
                // Insert in the right subtree if the value is greater
                if (root.getRightNode() == null) {
                    root.setRightNode(new BSTNode(value));
                } else {
                    // Recursively insert into the right subtree
                    insert(root.getRightNode(), value);
                }
            }
        }
    }

    //Searches for a value in the BST using recursion
    public boolean findValueRecursively(BSTNode node, int value) {
        //  If the current node is null, the value is not in the tree
        if (node == null) {
            return false;
        }

        // If the node's value matches the search value, return true
        if (value == node.getData()) {
            return true;
        } else if (value < node.getData()) {
            // Search in the left subtree if the value is smaller
            return findValueRecursively(node.getLeftNode(), value);
        } else {
            // Search in the right subtree if the value is larger
            return findValueRecursively(node.getRightNode(), value);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a new instance of the BST class
        BST bst = new BST();

        // Create the root node with an initial value of 4
        BSTNode bstNode = new BSTNode(4);

        //  Insert multiple values into the BST
        bst.insert(bstNode, 2); 
        bst.insert(bstNode, 5); 
        bst.insert(bstNode, 6); 
        bst.insert(bstNode, 1); 
        bst.insert(bstNode, 3); 
        bst.insert(bstNode, 7); 

        // Search for the value (7) in the BST
        if (bst.findValueRecursively(bstNode, 7)) {
            System.out.println("Element is found!"); // If the value is found
        } else {
            System.out.println("Element is not found!"); // If the value is not found
        }
    }
}

