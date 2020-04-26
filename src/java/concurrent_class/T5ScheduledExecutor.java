package java.concurrent_class;

import utils.MyLogger;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/*
1. schedule tasks to run after a delay
2. execute repeatedly with a fixed interval of time between each execution
 */
public class T5ScheduledExecutor {
    public static void main(String[] args) {
        MyLogger.log("Start");
        // ScheduledExecutorService is created with 5 threads
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        Callable<String> callable = () -> {
            MyLogger.log("Callable Executed");
            return "Called";
        };

        Runnable runnable = () -> {
            long val = System.currentTimeMillis() % 3;
            if (val == 0){
                MyLogger.log("Throwing Exception");
                throw new RuntimeException("Testing Exception");
            }
            MyLogger.log("Runnable Executed");
        };

        Runnable delayRunnable = () -> MyLogger.log("Delay Runnable Executed");

        // callable is executed after 5 seconds
        // use future object either to cancel the execution before it starts executing or obtain
        // the result once it is executed.
        ScheduledFuture<String> future = executorService.schedule(callable, 3, TimeUnit.SECONDS);

        // The task is executed first time with delay 1 sec (initialDelay) and then recurring
        // every time the period expires.
        // The task will continue executed until exception is thrown or shutdown() is called.
        executorService.scheduleAtFixedRate(runnable, 1,3, TimeUnit.SECONDS);

        // execute runnable with fix delay.
        // Delay = time between two end of previous and start of current task.
        executorService.scheduleWithFixedDelay(delayRunnable, 1,3, TimeUnit.SECONDS);

        try {
            MyLogger.log("Future Value: " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Shutdown executorService when task is done
        executorService.shutdown();
        MyLogger.log("End");
    }
}
