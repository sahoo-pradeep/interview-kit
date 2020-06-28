package java_problems.jvm.memory_management;

import java.lang.ref.WeakReference;

public class J1_WeakReferenceDemo {
    public static void main(String[] args) {
        Person person = new Person();
        WeakReference<Person> wr = new WeakReference<>(person);
        Person p1 = wr.get();
        System.out.println(p1);

        person = null;
        p1 = null;
        Person p2 = wr.get();
        System.out.println(p2);

        p2 = null;
        System.gc();
        Person p3 = wr.get();
        System.out.println(p3);
    }

    private static class Person {}
}
