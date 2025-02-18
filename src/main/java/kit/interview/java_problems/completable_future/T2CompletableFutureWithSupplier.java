package kit.interview.java_problems.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class T2CompletableFutureWithSupplier {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Supplier<String> suppTask = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Thread.currentThread().getName();
        };

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(suppTask, executor);

        System.out.println("Result: " + completableFuture.join());

        //force completion. change output to 'Too Long' only if not completed.
        //completableFuture.complete("Too Long");

        //force completion. change output to 'Obtrude Value', whether it is completed or not.
        completableFuture.obtrudeValue("Obtrude Value");

        System.out.println("Result: " + completableFuture.join());

        executor.shutdown();
    }
}
