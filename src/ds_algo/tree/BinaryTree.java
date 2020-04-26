package ds_algo.tree;

import java.util.StringJoiner;

// Binary Tree is represented by pointer to root node
public class BinaryTree {
    Node root;

    public BinaryTree() {
    }

    public BinaryTree(int data){
        root = new Node(data);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(" -> ", "[", "]");
        printInorder(root, joiner);
        return joiner.toString();
    }

    private void printInorder(Node node, StringJoiner joiner) {
        if (node == null) {
            return;
        }

        printInorder(node.left, joiner);
        joiner.add(String.valueOf(node.data));
        printInorder(node.right, joiner);
    }
}
