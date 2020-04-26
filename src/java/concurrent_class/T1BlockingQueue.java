package java.concurrent_class;

import utils.MyLogger;

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
        });

        Thread threadB = new Thread(() -> {
            try {
                // To Remove: take()
                MyLogger.log(blockingQueue.take());
                MyLogger.log(blockingQueue.take());
                MyLogger.log(blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
    }
}
