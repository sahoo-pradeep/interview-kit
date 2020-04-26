package java_problems.concurrent_class;

import utils.MyLogger;

import java.util.concurrent.CountDownLatch;

// Calling await() blocks the thread until the count reaches zero
public class T2CountDownLatch {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        Thread threadA = new Thread(() -> {
            try {
                MyLogger.log(countDownLatch.getCount());
                Thread.sleep(1000);
                countDownLatch.countDown();

                MyLogger.log(countDownLatch.getCount());
                Thread.sleep(1000);
                countDownLatch.countDown();

                MyLogger.log(countDownLatch.getCount());
                Thread.sleep(1000);
                countDownLatch.countDown();

                MyLogger.log(countDownLatch.getCount());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        threadA.start();
        MyLogger.log("Started");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MyLogger.log("Completed");
    }
}
