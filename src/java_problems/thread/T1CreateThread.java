package java_problems.thread;

import utils.MyLogger;

/*
Create thread using:
1. Class extends Thread
2. Class implements Runnable
3. Anonymous class for Thread
3. Anonymous class for Runnable
4. Anonymous class for Runnable using Lambda

Note: We cannot start a thread more than once.
 */
public class T1CreateThread {
    public static void main(String[] args) {
        // Class extending Thread class
        Thread threadExtended = new RunnerExtended();

        //Class implementing Runnable interface
        Thread threadImplemented = new Thread(new RunnerImplemented());

        // Anonymous class for threadExtended
        Thread threadAnonymousThread = new Thread() {
            @Override
            public void run() {
                MyLogger.log(
                        Thread.currentThread().getName() + " [threadAnonymousThread] Starting");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                MyLogger.log(Thread.currentThread().getName() + " [threadAnonymousThread] Done");
            }
        };

        // Anonymous class for RunnerImplemented
        Thread threadAnonymousRunnable = new Thread(new Runnable() {
            @Override
            public void run() {
                MyLogger.log(Thread.currentThread() + " [threadAnonymousRunnable] Starting");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                MyLogger.log(Thread.currentThread().getName() + " [threadAnonymousRunnable] Done");
            }
        });

        // Anonymous class using Java 8 Lambda
        Thread threadLambda = new Thread(() -> {
            MyLogger.log(Thread.currentThread() + " [Lambda] Starting");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MyLogger.log(Thread.currentThread().getName() + " [Lambda] Done");
        });

        // Starting all threads - The start() call will return as soon as the thread is started.
        // It will not wait until the run() method is done.
        threadExtended.start();
        threadImplemented.start();
        threadAnonymousThread.start();
        threadAnonymousRunnable.start();
        threadLambda.start();
    }

    private static class RunnerExtended extends Thread {
        @Override
        public void run() {
            MyLogger.log(Thread.currentThread().getName() + " [RunnerExtended] Starting");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MyLogger.log(Thread.currentThread().getName() + " [RunnerExtended] Done");
        }
    }


    private static class RunnerImplemented implements Runnable {
        @Override
        public void run() {
            MyLogger.log(Thread.currentThread() + " [RunnerImplemented] Starting");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MyLogger.log(Thread.currentThread().getName() + " [RunnerImplemented] Done");
        }
    }

}