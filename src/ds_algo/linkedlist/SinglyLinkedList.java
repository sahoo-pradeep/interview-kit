package ds_algo.linkedlist;

import java.util.StringJoiner;

public class SinglyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public int size() {
        return size;
    }

    public Node<T> getHead(){
        return head;
    }

    public Node<T> add(T data) {
        Node<T> node = new Node<>(data);

        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

        size++;
        return node;
    }

    public boolean remove(T data) {
        if (head == null) {
            return false;
        }

        Node<T> previous = null;
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            // data Not found
            return false;
        }

        if (previous == null) {
            // remove head
            head = head.next;
            if (head == tail) {
                tail = null;
            }
        } else {
            if (tail == current) {
                tail = previous;
            }
            previous.next = current.next;
        }

        size--;
        return true;
    }

    public void reverse() {
        if (head == null) {
            return;
        }

        Node<T> previous = null;
        Node<T> current = head;

        while (current != null) {
            Node<T> next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner(" -> ", "[", "]");
        Node<T> current = head;
        while (current != null) {
            joiner.add(current.data.toString());
            current = current.next;
        }
        return joiner.toString();
    }
}
