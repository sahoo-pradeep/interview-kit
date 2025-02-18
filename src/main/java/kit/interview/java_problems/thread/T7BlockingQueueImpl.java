package kit.interview.java_problems.thread;

/*
Blocking Queue: Blocks the thread to enqueue if queue is full or to dequeue if queue is empty.
A thread trying to enqueue in a full queue is blocked until some other thread dequeue a value.
A thread trying to dequeue in an empty queue is blocked until some other thread enqueue a value.
 */

import utils.MyLogger;

import java.util.LinkedList;

public class T7BlockingQueueImpl {
    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(3);
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                try {
                    Thread.sleep(400);
                    queue.enqueue(i);
                    System.out.println("Enqueue: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }, "ThreadA");

        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                try {
                    Thread.sleep(900);
                    int out = queue.dequeue();
                    System.out.println("Dequeue: " + out);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }, "ThreadB");

        threadA.start();
        Thread.sleep(50);
        threadB.start();
    }

    public static class MyBlockingQueue<T> {
        private LinkedList<T> queue = new LinkedList<>();
        private int length;

        public MyBlockingQueue(int length) {
            this.length = length;
        }

        public synchronized void enqueue(T value) throws InterruptedException {
            while (queue.size() == length) {
                MyLogger.log("[" + Thread.currentThread().getName() + "] Waiting in enqueue: " + value);
                wait();
                MyLogger.log("[" + Thread.currentThread().getName() + "] Awake in enqueue: " + value);
            }
            MyLogger.log("[" + Thread.currentThread().getName() + "] Adding: " + value);

            queue.add(value);
            if (queue.size() == 1) {
                notifyAll();
            }
        }

        public synchronized T dequeue() throws InterruptedException {
            while (queue.isEmpty()) {
                MyLogger.log("[" + Thread.currentThread().getName() + "] Waiting in dequeue");
                wait();
                MyLogger.log("[" + Thread.currentThread().getName() + "] Awake in dequeue");
            }

            if (queue.size() == length) {
                notifyAll();
            }

            T value = queue.remove();
            MyLogger.log("[" + Thread.currentThread().getName() + "] Removed: " + value);
            return value;
        }
    }
}
