package kit.interview.java_problems.completable_future;

import java.util.concurrent.CompletableFuture;

public class T3SimpleCompletableFuture {
    public static void main(String[] args) {
        CompletableFuture<Void> cf = new CompletableFuture<>();

        Runnable runnable = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Only
            cf.complete(null);
        };

        CompletableFuture.runAsync(runnable);

        // it will block the thread until its complete or obstructValue method is called.
        Void nil = cf.join();
        System.out.println("Completed!");
    }
}
