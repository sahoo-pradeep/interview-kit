package ds_algo.tree;

import sun.applet.AppletResourceLoader;

/*
Fixing Two Nodes in BST:
Link: https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
        10
      /    \
    5       8 <-
  /   \
2       20 <-

Solution: Inorder Traversal of Input Tree: 2 -> 5 -> 20 -> 10 -> 8
Two cases: (1) Swapped nodes are adjacent to each other, (2) Not adjacent to each other

Steps:
1. Traverse the inorder traversal. When we found one defected node (current < prev),
store: first = prev, middle = current
2. If we again found a defected node, store the current value in last.

For Case 1: (Adjacent) swap first and middle, Case 2: swap first and end.
*/
public class Q6FixingTwoNodesBST {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(20);
        System.out.print("Input: ");
        BinarySearchTree.printInorder(root);
        System.out.println();


        solve(root);

        System.out.print("Output: ");
        BinarySearchTree.printInorder(root);
    }

    private static Node first;
    private static Node middle;
    private static Node last;
    private static Node prev;

    private static void solve(Node root) {
        findNodes(root);
        if (first != null && last != null){
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        } else if (first != null && middle != null){
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }

    private static void findNodes(Node node) {
        if (node == null) {
            return;
        }

        findNodes(node.left);
        checkNode(node);
        findNodes(node.right);
    }

    private static void checkNode(Node current) {
        if (prev == null){
            prev = current;
            return;
        }

        if (current.data < prev.data){
            if (first == null){
                first = prev;
                middle = current;
            } else {
                last = current;
            }
        }
        prev = current;
    }
}
