package kit.interview.java_problems.concurrent_class;


import kit.interview.utils.MyLogger;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class T1BlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

        Thread threadA = new Thread(() -> {
            try {
                // To Add: put()
                blockingQueue.put(1);
                Thread.sleep(1000);
                blockingQueue.put(2);
                Thread.sleep(1000);
                blockingQueue.put(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"threadA");

        Thread threadB = new Thread(() -> {
            try {
                // To Remove: take()
                MyLogger.log(blockingQueue.take());
                MyLogger.log(blockingQueue.take());
                MyLogger.log(blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "threadB");

        threadA.start();
        threadB.start();
    }
}
