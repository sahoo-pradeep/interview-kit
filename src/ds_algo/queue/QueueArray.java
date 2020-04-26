package ds_algo.queue;

import java.util.Arrays;
import java.util.StringJoiner;

public class QueueArray {
    private int[] data;
    private int length;
    private int head;
    private int tail;

    public QueueArray(int length) {
        this.data = new int[length];
        this.length = length;
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        if (head == tail)
            return true;
        else
            return false;
    }

    public boolean isFull() {
        if (head == length - 1 && tail == 0) {
            return true;
        } else if (tail == head + 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean add(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Add unsuccessful: " + value);
            return false;
        }

        this.data[head] = value;
        if (head == length - 1) {
            head = 0;
        } else {
            head++;
        }
        System.out.println("Added successfully: " + value + ", data: " + prettyPrint());
        return true;
    }

    public boolean remove() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Remove unsuccessful");
            return false;
        }
        int value = data[tail];
        if (tail == length - 1) {
            tail = 0;
        } else {
            tail++;
        }
        System.out.println("Removed successfully: " + value + ", data: " + prettyPrint());
        return false;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QueueArray{");
        sb.append("data=").append(Arrays.toString(data));
        sb.append(", length=").append(length);
        sb.append(", head=").append(head);
        sb.append(", tail=").append(tail);
        sb.append('}');
        return sb.toString();
    }

    public String prettyPrint() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        if (isEmpty()) {
            return joiner.toString();
        }

        int headPointer = head;
        int tailPointer = tail;

        while (headPointer != tailPointer) {
            if (headPointer == 0) {
                headPointer = length - 1;
            } else {
                headPointer--;
            }

            joiner.add(String.valueOf(data[headPointer]));
        }

        return joiner.toString();
    }
}
