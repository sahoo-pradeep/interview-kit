package kit.interview.java_problems.jvm.memory_management;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

public class J4_PhantomReferenceDemo {
    public static void main(String[] args) {
        ReferenceQueue<Person> queue = new ReferenceQueue<>();
        List<FinalizePerson> finalizeList = new ArrayList<>();
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < 5; i++){
            Person p = new Person();
            people.add(p);
            finalizeList.add(new FinalizePerson(p, queue));
        }

        people = null;
        System.gc();

        for (PhantomReference<Person> reference : finalizeList){
            System.out.println(reference.isEnqueued());
        }

        Reference<? extends Person> referenceFromQueue;
        while ((referenceFromQueue = queue.poll()) != null){
            ((FinalizePerson) referenceFromQueue).cleanup();
        }
    }

    private static class FinalizePerson extends PhantomReference<Person> {
        public FinalizePerson(Person referent, ReferenceQueue<? super Person> q) {
            super(referent, q);
        }

        public void cleanup(){
            System.out.println("Finalizing Resources");
        }
    }

    private static class Person{}
}
