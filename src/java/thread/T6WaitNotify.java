package java.thread;

/*
A thread that calls wait() on any object becomes inactive until another thread calls
notify() on the same object. To call either wait() or notify(), the calling thread must obtain the
lock of that object, i.e. call wait() or notify() inside synchronized block, else system throws
IllegalMonitorStateException.

notify() - One of the thread waiting on that object is awakened.
notifyAll() - wake up all threads on that object.

Once a thread calls wait() it releases the lock on monitor object.

Once a thread is awakened, it cannot exit the wait() call until the thread calling notify has left
its synchronized block, i.e. the thread has to re-obtain the lock on monitor object.
 */
public class T6WaitNotify {
    public static void main(String[] args) {
        signalingViaSharedObject();
        signalingViaWaitNotify();
    }

    private static void signalingViaSharedObject() {
        // Shared Object = signal
        MySignal signal = new MySignal();
        Thread threadA = new Thread(() -> {
            System.out.println("1 Processing Start");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1 Processing Completed");
            signal.setProcessed(true);
        });

        Thread threadB = new Thread(() -> {
            while (!signal.isProcessed()) {
                //wait
            }
            System.out.println("1 Start working");
        });

        threadA.start();
        threadB.start();
    }

    private static void signalingViaWaitNotify() {
        // Shared Object = signal
        MySignalWN signal = new MySignalWN();
        Thread threadA = new Thread(() -> {
            System.out.println("2 Processing Start");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("2 Processing Completed");
            signal.doNotify();
        });

        Thread threadB = new Thread(() -> {
            signal.doWait();
            System.out.println("2 Start working");
        });

        threadA.start();
        threadB.start();
    }

    private static class MySignal {
        private boolean processed = false;

        public synchronized boolean isProcessed() {
            return processed;
        }

        public synchronized void setProcessed(boolean processed) {
            this.processed = processed;
        }
    }


    private static class MySignalWN {
        private final Object lock = new Object();

        public void doWait() {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void doNotify() {
            synchronized (lock) {
                lock.notify();
            }
        }
    }
}
