package kit.interview.ds_algo.queue;

import java.util.StringJoiner;

public class QueueLinkedList {
    Node head;
    Node tail;

    public boolean add(int value) {
        Node node = new Node(value);

        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;

        System.out.println("Added successfully: " + value + ", data: " + prettyPrint());
        return true;
    }

    public boolean remove() {
        if (head == null) {
            System.out.println("Queue is Empty. Remove unsuccessful");
            return false;
        } else {
            int value = head.data;
            head = head.next;
            System.out.println("Removed Successfully: " + value + ", data: " + prettyPrint());
            return true;
        }
    }

    public String prettyPrint() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        Node current = head;
        while (current != null) {
            joiner.add(String.valueOf(current.data));
            current = current.next;
        }
        return joiner.toString();
    }

    @Override
    public String toString() {
        return prettyPrint();
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
