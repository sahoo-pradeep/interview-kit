package ds_algo.tree;

/*
Diameter of a Binary Tree: https://www.geeksforgeeks.org/diameter-of-a-binary-tree/

Def: The diameter of a tree (sometimes called the width) is the number of nodes on the longest path
between two end nodes

*/
public class Q7DiameterOfTree {
    static int diameter = 0;

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        solve(root);
        System.out.println("Diameter: " + diameter);
    }

    private static void solve(Node root) {
        height(root);
    }

    private static int height(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        int currentNodeHeight = leftHeight + rightHeight + 1;
        diameter = Math.max(diameter, currentNodeHeight);

        return currentNodeHeight;
    }
}
