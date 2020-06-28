package java_problems.jvm.memory_management;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class J3_ReferenceQueueDemo {
    public static void main(String[] args) throws IOException {
        //Simple Example
        Person pradeep = new Person("Pradeep");
        ReferenceQueue<Person> queue = new ReferenceQueue<>();
        WeakReference<Person> wr = new WeakReference<>(pradeep, queue);
        pradeep = null;
        System.gc();
        WeakReference pollWr = (WeakReference) queue.poll();

        // Cleanup Mechanism
        Person person = new Person("Person");
        PersonCleaner cleaner = new PersonCleaner();
        ReferenceQueue<Person> referenceQueue = new ReferenceQueue<>();
        PersonWeakReference pwr = new PersonWeakReference(person, cleaner, referenceQueue);

        //Cleanup in background thread
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            try {
                PersonWeakReference removedWr = (PersonWeakReference) referenceQueue.remove();
                removedWr.clean();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        person = null;
        System.gc(); //Weak reference added to reference queue

        // Waiting to shutdown executorService
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Press any key to continue");
        br.readLine();
        executorService.shutdown();
    }

    public static class PersonCleaner {
        public void clean() {
            System.out.println("Cleaned");
        }
    }

    public static class PersonWeakReference extends WeakReference<Person> {
        private PersonCleaner cleaner;

        public PersonWeakReference(Person referent, PersonCleaner cleaner, ReferenceQueue<? super Person> q) {
            super(referent, q);
            this.cleaner = cleaner;
        }

        public void clean(){
            cleaner.clean();
        }
    }

    public static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }
    }
}
