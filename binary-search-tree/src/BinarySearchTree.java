public class BinarySearchTree {

    public BinarySearchTree() // constructors
    {root = null;}

    public BinarySearchTree(long key, String data)
    {root = new Node(key, data);}

    static class Node { // contains key value and left and right children of current node

        long key;
        String data;
        Node left, right;
        public Node(long key, String data)
        {
            this.key = key;
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node root; // root node of BST

    public void insert(long key, String data) // call insertRecursive()
    {root = insertRecursive(root, key, data);}

    private Node insertRecursive(Node root, long key, String data) // recursively insert a new key in BST
    {
        if (root == null) { // return new node if tree is empty

            root = new Node(key, data);
            return root;
        }

        // if not empty, continue down the tree
        else if (key < root.key)
            root.left = insertRecursive(root.left, key, data);

        else if (key > root.key)
            root.right = insertRecursive(root.right, key, data);

        return root; // return original node pointer
    }

    public void inorder() // call inorderRecursive()
    {
        inorderRecursive(root);}

    private void inorderRecursive(Node root) // find inorder traversal of BST
    {
        if (root != null) {

            inorderRecursive(root.left);
            System.out.print(root.key + " : " + root.data + ", ");
            inorderRecursive(root.right);
        }
    }

    public void delete(long key) { // call deleteRecursive()
        this.root = deleteRecursive(root, key);
    }

    private Node deleteRecursive(Node root, long key) { // delete specified node from BST

        if (root == null) {
            return null;
        }

        if (key == root.key) {

            // case 1: no children
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2: 1 child
            if (root.right == null) {
                return root.left;
            }

            if (root.left == null) {
                return root.right;
            }

            // case 3: 2 children
            Node smallerNode = findSmallerNode(root.right);
            root.key = smallerNode.key; // replace key and data of root with the child with the smallest key
            root.data = smallerNode.data;
            root.right = deleteRecursive(root.right, smallerNode.key);
            return root;

        }
        if (key < root.key) {
            root.left = deleteRecursive(root.left, key);
            return root;
        }

        root.right = deleteRecursive(root.right, key);
        return root;
    }

    private Node findSmallerNode(Node root) { // return child with the smallest key
        return root.left == null ? root : findSmallerNode(root.left);
    }

    public void search(long key) { // call searchRecursive()
        Node result = searchRecursive(root, key);
        System.out.print(result.data);
    }

    private Node searchRecursive(Node root, long key) {

        // base cases: root is null or value of root node is the key
        if (root == null || root.key == key)
            return root;

        // key is greater than the root's key
        if (root.key < key)
            return searchRecursive(root.right, key);

        // key is smaller than the root's key
        return searchRecursive(root.left, key);
    }

}
