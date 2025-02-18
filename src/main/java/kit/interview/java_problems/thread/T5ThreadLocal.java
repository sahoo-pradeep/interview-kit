package kit.interview.java_problems.thread;

import java.util.function.Supplier;

/*
ThreadLocal: ThreadLocal variable can be read and written by same thread. Two threads having the
same reference of ThreadLocal variable cannot see each other's ThreadLocal variable.
ThreadLocal makes the code threadSafe.
*/
public class T5ThreadLocal {
    public static void main(String[] args) {
        Runnable myRunnable = new MyRunnable();

        Thread threadA = new Thread(myRunnable);
        Thread threadB = new Thread(myRunnable);
        threadA.start();
        threadB.start();

        // Initialize ThreadLocal -> Using child class overriding initialValue
        ThreadLocal<Long> init1 = new ThreadLocal<Long>() {
            @Override
            protected Long initialValue() {
                return System.currentTimeMillis();
            }
        };

        // Initialize ThreadLocal -> Using child class overriding initialValue
        ThreadLocal<Long> init2 = ThreadLocal.withInitial(new Supplier<Long>() {
            @Override
            public Long get() {
                return System.currentTimeMillis();
            }
        });

        // Using Lambda and Method Reference
        ThreadLocal<Long> init3 = ThreadLocal.withInitial(System::currentTimeMillis);
    }

    private static class MyRunnable implements Runnable {
        // Declare
        private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        private int random;

        @Override
        public void run() {
            random = (int) (Math.random() * 100D);
            // Set
            threadLocal.set(random);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Get
            System.out.println("ThreadLocal: " + threadLocal.get());
            System.out.println("Random: " + random);
        }
    }
}
