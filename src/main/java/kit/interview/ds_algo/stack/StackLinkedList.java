package kit.interview.ds_algo.stack;

import java.util.StringJoiner;

public class StackLinkedList {
    Node stack;
    int length;

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        if (length == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean push(int value) {
        Node node = new Node(value);
        node.next = stack;
        stack = node;
        length++;
        System.out.println("Added Successfully: " + value + ", data: " + this.toString());
        return true;
    }

    public boolean pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Remove unsuccessful");
            return false;
        }
        int value = stack.data;
        stack = stack.next;
        length--;
        System.out.println("Removed Successfully: " + value + ", data: " + this.toString());
        return true;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        Node node = stack;
        while (node != null) {
            joiner.add(String.valueOf(node.data));
            node = node.next;
        }
        return joiner.toString();
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
