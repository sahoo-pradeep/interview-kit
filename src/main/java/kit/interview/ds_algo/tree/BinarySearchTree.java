package kit.interview.ds_algo.tree;

import java.util.Stack;
import java.util.StringJoiner;

public class BinarySearchTree {
    Node root;

    public Node search(int data, Node node) {
        if (node == null || node.data == data) {
            return node;
        }

        if (data < node.data) {
            return search(data, node.left);
        } else {
            return search(data, node.right);
        }
    }

    public void insert(int data, Node node) {
        Node insertNode = new Node(data);
        Node parent = null;
        Node iterateNode = node;

        while (iterateNode != null){
            parent = iterateNode;
            if (data <  iterateNode.data){
                iterateNode = iterateNode.left;
            } else {
                iterateNode = iterateNode.right;
            }
        }

        if (parent == null){
            return;
        }

        if (data < parent.data){
            parent.left = insertNode;
        } else {
            parent.right = insertNode;
        }
    }

    public Node min(Node root){
        Node min = root;

        while (min.left != null){
            min = min.left;
        }

        return min;
    }

    public void delete(int data){
        if (root == null){
            throw new RuntimeException("Empty Tree. Failed to delete node with data: " + data);
        }

        Node parent = null;
        Node current = root;

        while (current != null){
            if (current.data == data){
                break;
            }

            parent = current;
            if (data < current.data){
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null){
            throw new RuntimeException("Invalid input. Failed to delete node with data: " + data);
        }

        if (current.left != null && current.right != null){
            // has 2 children
            Node successor = min(current.right);
            int successorData = successor.data;
            delete(successor.data);
            current.data = successorData;
        } else {
            if (current.left != null){
                // Has single left child
                int childData = current.left.data;
                delete(current.left.data);
                current.data = childData;
            } else if (current.right != null){
                // has single right child
                int childData = current.right.data;
                delete(current.right.data);
                current.data = childData;
            } else {
                // Has no child
                if (parent == null){
                    // single root element
                    root = null;
                } else if (parent.left != null && parent.left.data == current.data){
                    // parent's left child
                    parent.left = null;
                } else {
                    // parent's right child
                    parent.right = null;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(" -> ", "[", "]");

        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()){
            while (current != null){
                stack.push(current);
                current = current.left;
            }

            Node last = stack.pop();
            joiner.add(String.valueOf(last.data));

            current = last.right;
        }

        return joiner.toString();
    }

    public static void printInorder(Node node) {
        if (node == null) {
            return;
        }

        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

}
