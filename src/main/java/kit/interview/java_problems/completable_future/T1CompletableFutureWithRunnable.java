package kit.interview.java_problems.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T1CompletableFutureWithRunnable {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable runTask = () -> System.out.println("Runnable: Running in thread: " + Thread.currentThread().getName());

        CompletableFuture.runAsync(runTask, executor);

        executor.shutdown();
    }
}
