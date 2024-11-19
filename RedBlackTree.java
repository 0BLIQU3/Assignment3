public class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;
    private class Node {
        private Node left, right;
        private boolean color;
        private int size;
        private String productID; //This is the "key" for all searches and insertions
        private String name;
        private String category;
        private String price;
        public Node(String productID, String name, String category, String price, int N) {
            this.productID = productID;
            this.name = name;
            this.category = category;
            this.price = price;
            this.size = N;
            this.color = RED; //New nodes must always start as red
            this.left = null;
            this.right = null;
        }
    }
    //Helper methods
    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.color == RED;
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }
    public int size() {
        return size(root);
    }
    public boolean isEmpty() {
        return root == null;
    }
    //Standard BST implementation
    private String get(Node node, String productID) {
        while (node != null) {
            int compare = productID.compareTo(node.productID);
            if (compare < 0) {
                node = node.left; //If value is less than subject, go check left child
            }
            else if (compare > 0) {
                node = node.right; //If value is greater than subject, go check right child
            }
            else {
                StdOut.println("Product ID: " + node.productID);
                StdOut.println("Name: " + node.name);
                StdOut.println("Category: " + node.category);
                StdOut.println("Price: " + node.price);
                return "------"; //Only reached if we are at correct node!
            }
        }
        if (node == null) {
            StdOut.println("KILL YOURSELF!!!!");
        }
        return null; //Reached if we get to an empty node from unsuccessful search
    }
    public String get(String productID) {
        if (productID == null) {
            throw new IllegalArgumentException("argument to get() is null");
        }
        return get(root, productID); //Start from root with given productID
    }
    public boolean contains(String productID) {
        return get(productID) != null; //Is there something in the tree with this key?
    }

    //Actual Red Black Tree implementation
    public void put(String productID, String name, String category, String price) {
        if (productID == null) {
            throw new IllegalArgumentException("first argument to put() is null");
        }
        root = put(root, productID, name, category, price);
        root.color = BLACK;
    }
    private Node put(Node node, String productID, String name, String category, String price) {
        if (node == null) {
            return new Node(productID, name, category, price, 1);
        }
        int compare = productID.compareTo(node.productID); //Compare given productID to current root productID
        if (compare < 0) { //Move to left child if lesser
            node.left = put(node.left, productID, name, category, price);
        }
        else if (compare > 0) { //Move to right child if greater
            node.right = put(node.right, productID, name, category, price);
        }
        else { //If equals, then we are at the right node.
            //This handles edge-cases of duplicate IDs!
            StdOut.println("ERROR: USER PRODUCT ALREADY EXISTS");
            node.name = name; //Reassign values, in-case we needed to fix values for a product ID
            node.category = category;
            node.price = price;
        }

        //Balance the node
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }
    private Node rotateRight(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        x.size = node.size;
        node.size = 1 + size(node.left) + size(node.right);
        return x;
    }
    private Node rotateLeft(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        x.size = node.size;
        node.size = 1 + size(node.left) + size(node.right);
        return x;
    }
    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

}
