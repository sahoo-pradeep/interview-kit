package kit.interview.ds_algo.tree;

import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/insertion-in-a-binary-tree-in-level-order/
public class Q2InsertInLevelOrder {
    private static BinaryTree init() {
        BinaryTree bt = new BinaryTree();
        Node root = new Node(10);
        Node n11 = new Node(11);
        Node n9 = new Node(9);
        Node n7 = new Node(7);
        Node n15 = new Node(15);
        Node n8 = new Node(8);

        bt.root = root;
        root.left = n11;
        root.right = n9;
        n11.left = n7;
        n9.left = n15;
        n9.right = n8;

        return bt;
    }

    public static void main(String[] args) {
        BinaryTree bt = init();
        System.out.println("Initial Tree: " + bt);

        Node n = new Node(12);
        insertNode(bt, n);

        System.out.println("After Inserting: " + bt);
    }

    private static void insertNode(BinaryTree bt, Node n) {
        if (bt.root == null) {
            bt.root = n;
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(bt.root);

        while (!q.isEmpty()) {
            Node popNode = q.remove();
            if (popNode.left == null) {
                popNode.left = n;
                break;
            } else if (popNode.right == null) {
                popNode.right = n;
                break;
            } else {
                q.add(popNode.left);
                q.add(popNode.right);
            }
        }
    }
}
