package java_problems.concurrent_class;

import utils.MyLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.*;

/*
ExecutorService is an Thread Pool to execute tasks concurrently in background.
 */
public class T4ExecutorService {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // Execute a Runnable task with no return
        executorService.execute(() -> {
            MyLogger.log("Using execute");
        });

        sleep(200);

        // Execute a Runnable task returning Future object which can be used to check if Runnable
        // has finished executing
        // Future object represents result of asynchronous computation
        Future future = executorService.submit(() -> {
            MyLogger.log("Using submit(Runnable)");
            sleep(1000);
        });

        // returns null if task is completed successfully. Block thread until then
        MyLogger.log("submit(Runnable) future.get(): " + future.get());

        sleep(200);

        Future<String> futureCallable = executorService.submit(() -> {
            MyLogger.log("Using submit(Callable)");
            sleep(1000);
            return "Returned from submit(Callable)";
        });

        MyLogger.log("submit(Runnable) futureCallable.get(): " + futureCallable.get());

        List<Callable<String>> callableList = new ArrayList<>();
        callableList.add(() -> {
            return "Task1";
        });

        callableList.add(() -> {
            return "Task2";
        });

        callableList.add(() -> {
            return "Task3";
        });

        // invokeAny executes any one of the Callable
        String result = executorService.invokeAny(callableList);
        System.out.println("Result of invokeAny: " + result);

        // invokeAll executes all the callable
        List<Future<String>> results = executorService.invokeAll(callableList);

        StringJoiner joiner = new StringJoiner(",", "Result of invokeAll: [", "]");
        for (Future<String> f : results) {
            joiner.add(f.get());
        }

        System.out.println(joiner);

        // When all the task are submitted. shutdown executorService so that the thread don't
        // keep running
        executorService.shutdown();

        // Block the calling thread until the executorService is shutdown completely, or timeout
        // happen, whichever happen first
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }

    private static void typesOfExecutorService(){
        /*
        Parameters:
        1. corePoolSize: Min number of threads to keep in pool, even if other threads are idle
        2. maximumPoolSize: Max number of threads to allow in pool
        3. keepAliveTime: when the number of threads > corePoolSize, this is the time that idle
           threads will wait for new task before terminating.
        4. unit: time unit
        5. workQueue: Blocking Queue to hold tasks (Runnable).
         */

        // corePoolSize = maximumPoolSize = nThreads
        // keepAliveTime = 0L
        // workQueue = LinkedBlockingQueue (unbounded queue)
        // Note: Thread will not die until you call shutdown()
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        // corePoolSize = 0
        // maximumPoolSize = Integer.MAX_VALUE
        // keepAliveTime = 60L, unit = TimeUnit.SECONDS
        // workQueue = SynchronousQueue (each insert operation must wait for a corresponding remove
        // operation by another thread, and vice versa. Queue of size 1)
        // Note: Creates new threads as needed. Good for short lived asynchronous task
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        // corePoolSize = nThreads
        // maximumPoolSize = Integer.MAX_VALUE
        // keepAliveTime = 0L
        // workQueue = DelayedWorkQueue
        ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);


    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
