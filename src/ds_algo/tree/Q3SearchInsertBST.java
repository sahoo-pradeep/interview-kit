package ds_algo.tree;

public class Q3SearchInsertBST {
    private static BinarySearchTree create() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = new Node(100);
        bst.root.left = new Node(20);
        bst.root.right = new Node(500);
        bst.root.left.left = new Node(10);
        bst.root.left.right = new Node(30);

        return bst;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = create();
        System.out.println("Init: " + bst);
        // Search
        Node n20 = bst.search(20, bst.root);
        Node n40 = bst.search(40, bst.root);
        System.out.println("Searching 20: " + n20);
        System.out.println("Searching 40: " + n40);

        // Insert
        bst.insert(40, bst.root);
        System.out.println("After Inserting: " + bst);

        // Min
        Node minNode = bst.min(bst.root);
        System.out.println("Min Node: " + minNode);

        // Deleting
        bst.delete(30);
        System.out.println("After Deleting 30: " + bst);
        bst.delete(20);
        System.out.println("After Deleting 20: " + bst);
        bst.delete(100);
        System.out.println("After Deleting 100: " + bst);
        bst.delete(40);
        System.out.println("After Deleting 40: " + bst);
        bst.delete(10);
        System.out.println("After Deleting 10: " + bst);
        bst.delete(500);
        System.out.println("After Deleting 500: " + bst);
    }
}
