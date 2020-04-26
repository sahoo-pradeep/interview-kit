package ds_algo.queue;

public class Q1QueueBasicOperations {
    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();
//        QueueArray queue = new QueueArray(5);
        System.out.println("Initial: " + queue);
        queue.add(1);
        queue.add(2);
        queue.remove();
        queue.add(3);
        queue.add(4);
        queue.remove();
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.remove();
    }
}
