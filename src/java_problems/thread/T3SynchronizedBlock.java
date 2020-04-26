package java_problems.thread;

import java.util.ArrayList;
import java.util.List;

/*
A synchronized block is on some object. All synchronized blocks synchronized on the same object
can have only 1 thread executing inside then at a given time.

Different types of blocks:
1. Instance method - Object: instance(object) owing the method. Only one thread per instance can
execute any on the synchronized instance methods.
2. Static method - Object: Class object of the class static method belongs to. One class object
exist per class in JVM. One thread can access this block per class.
3. Code blocks inside instance method - Object: instance(object) owing the method. Synchronized
only a part of method rather than the whole method
4. Code blocks inside static method - Object: Class object

Synchronized Block Reentrance: Once a thread entered a synchronized block, it "holds the lock" on
monitor object. If the thread calls another method which again calls the calling method (or
recursively calls its own method), the thread holding the lock can re-enter the synchronized block.
*/
public class T3SynchronizedBlock {
    public static void main(String[] args) {
        MyCounterReentrance myCounterReentrance = new MyCounterReentrance();
        myCounterReentrance.list.add(1);
        myCounterReentrance.list.add(10);
        myCounterReentrance.list.add(20);

        System.out.println(myCounterReentrance.count());
    }

    private static class MyCounter {
        private int count = 0;

        // Instance Method synchronized block
        public synchronized void add(int value) {
            count += value;
        }
    }


    private static class MyStaticCounter {
        private static int count = 0;

        // Static Method synchronized block
        public static synchronized void add(int value) {
            count += value;
        }
    }


    private static class MyCounterCodeBlock {
        private int count = 0;

        // Code blocks inside instance method
        public void add(int value) {
            // object inside parenthesis is monitor object. Lock is acquired for this object.
            synchronized (this) {
                count += value;
            }
        }
    }


    private static class MyCounterStaticCodeBlock {
        private static int count = 0;

        // Code blocks inside static method
        public static void add(int value) {
            // Monitor object: class object
            synchronized (MyCounterStaticCodeBlock.class) {
                count += value;
            }
        }
    }


    private static class MyCounterReentrance {
        List<Integer> list = new ArrayList<>();

        public int count() {
            if (list.size() == 0) {
                return 0;
            }

            synchronized (this) {
                list.remove(0);
                return 1 + count();
            }
        }
    }
}
