package kit.interview.java_problems.thread;

import kit.interview.utils.MyLogger;

import java.util.ArrayList;
import java.util.List;

/*
Thread Pool manages the number of thread created to perform tasks.
Instead of creating a new thread for every task to execute concurrently, the task is passed to
thread pool. If there is any idle thread, the task is assigned to it.

 */
public class T8ThreadPoolImpl {
    public static void main(String[] args) throws Exception {
        MyThreadPool threadPool = new MyThreadPool(2, 4);
        for (int i = 0; i < 6; i++) {
            threadPool.execute(() -> {
                MyLogger.log("Executed");
            });
        }
        threadPool.stop();
    }

    private static class MyThreadPool {
        private T7BlockingQueueImpl.MyBlockingQueue<Runnable> queue;
        private List<MyThread> threads = new ArrayList<>();
        private boolean stopped = false;

        public MyThreadPool(int maxThreads, int maxTasks) {
            queue = new T7BlockingQueueImpl.MyBlockingQueue<>(maxTasks);

            for (int i = 0; i < maxThreads; i++) {
                threads.add(new MyThread(queue));
            }

            for (MyThread thread : threads) {
                thread.start();
            }
        }

        public synchronized void execute(Runnable task) throws InterruptedException {
            if (stopped) {
                throw new IllegalStateException();
            }
            Thread.sleep(200);
            queue.enqueue(task);
        }

        public synchronized void stop() {
            stopped = true;
            for (MyThread thread : threads) {
                thread.doStop();
            }
        }
    }


    private static class MyThread extends Thread {
        private T7BlockingQueueImpl.MyBlockingQueue<Runnable> queue;
        private boolean stopped = false;

        public MyThread(T7BlockingQueueImpl.MyBlockingQueue<Runnable> queue) {
            this.queue = queue;
        }


        @Override
        public void run() {
            while (!stopped) {
                try {
                    Runnable task = queue.dequeue();
                    MyLogger.log("Running task");
                    Thread.sleep(2000);
                    task.run();
                } catch (InterruptedException e) {
                    MyLogger.log("Thread interrupted: " + Thread.currentThread().getName());
                }
            }
        }

        public void doStop() {
            stopped = true;
            this.interrupt();
        }
    }

}
