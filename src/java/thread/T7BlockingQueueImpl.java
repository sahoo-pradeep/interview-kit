package java.thread;

/*
Blocking Queue: Blocks the thread to enqueue if queue is full or to dequeue if queue is empty.
A thread trying to enqueue in a full queue is blocked until some other thread dequeue a value.
A thread trying to dequeue in an empty queue is blocked until some other thread enqueue a value.
 */

import utils.MyLogger;

import java.util.LinkedList;
import java.util.List;

public class T7BlockingQueueImpl {
    public static void main(String[] args) {
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(3);
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                try {
                    Thread.sleep(200);
                    queue.enqueue(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "ThreadA");

        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                try {
                    Thread.sleep(1000);
                    queue.dequeue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "ThreadB");

        threadA.start();
        threadB.start();
    }

    public static class MyBlockingQueue<T> {
        private List<T> queue = new LinkedList<>();
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
            Thread.sleep(200);
            queue.add(value);
            if (queue.size() == 1) {
                notifyAll();
            }
        }

        public synchronized T dequeue() throws InterruptedException {
            while (queue.size() == 0) {
                MyLogger.log("[" + Thread.currentThread().getName() + "] Waiting in dequeue");
                wait();
                MyLogger.log("[" + Thread.currentThread().getName() + "] Awake in dequeue");
            }

            if (queue.size() == length) {
                notifyAll();
            }
            Thread.sleep(200);
            T value = queue.remove(0);
            MyLogger.log("[" + Thread.currentThread().getName() + "] Removed: " + value);
            return value;
        }
    }
}
