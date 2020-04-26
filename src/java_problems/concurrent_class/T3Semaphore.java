package java_problems.concurrent_class;

import utils.MyLogger;

import java.util.concurrent.Semaphore;

/*
Semaphore: initialized with given number of 'permits'
For each acquire() call, a permit is taken
For each release() call, a permit is returned.

At most N threads can pass acquire() without any release()
*/
public class T3Semaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                criticalSection(semaphore);
            }, "Thread" + i).start();
        }

        MyLogger.log("Task submitted");
    }

    private static void criticalSection(Semaphore semaphore) {
        try {
            semaphore.acquire();

            MyLogger.log("Work Started");
            Thread.sleep(2000);
            MyLogger.log("Work Completed");

            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
