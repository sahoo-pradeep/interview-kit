package kit.interview.java_problems.thread;

import utils.MyLogger;

import java.util.concurrent.atomic.AtomicInteger;

/*
Link: Refer Java Memory Model: http://tutorials.jenkov.com/java-concurrency/java-memory-model.html

If two or more threads share an object, and more than one thread updates variables in that shared
object, race conditions may occur.

Problem Statement:
If thread A reads the variable count into its CPU cache. And thread B also reads the variable count
into its CPU cache. Both the threads add 1 to count. Now count has been incremented two times, once
in each CPU cache. When both the changes are flushed to main memory, the result would be +1 instead
of +2.

Solution:
Synchronized block: It guarantees that only one thread can enter the critical section at a given
time. Also it guarantees that all variables accessed inside the synchronized block will be read from
main memory, and while exiting the synchronized block, changes will be flushed to main memory.

Synchronized methods: If one thread has acquired intrinsic lock and at the same time another
thread calls that method, the second thread has to wait until the first thread releases the
intrinsic lock by finishing method execution.
*/
public class T2RaceCondition {
    private static int count = 0;
    private static AtomicInteger countAtomic = new AtomicInteger(0);

    public static void main(String[] args) {
        Runnable runnableInstance = () -> {
            for (int i = 0; i < 10000; i++) {
                increment();
                incrementAtomic();
            }
        };

        Thread threadA = new Thread(runnableInstance);
        Thread threadB = new Thread(runnableInstance);

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MyLogger.log("Count: " + count);
        MyLogger.log("Count: " + countAtomic.get());
    }

    // Critical Section - More than 1 thread calling this method accessing an object (count)
    // Sequence of execution may change the result value. To avoid this, method should be atomic
    private synchronized static void increment() {
        count++;
    }

    // We can use atomic shared variable.
    private static void incrementAtomic() {
        countAtomic.incrementAndGet();
    }
}
