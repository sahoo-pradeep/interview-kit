package kit.interview.java_problems.jvm.memory_management;

import java.time.LocalDateTime;
import java.util.WeakHashMap;

public class J2_WeakHashMapDemo {
    public static void main(String[] args) {
        WeakHashMap<Person, PersonMetaData> weakHashMap = new WeakHashMap<>();
        Person pradeep = new Person();
        weakHashMap.put(pradeep, new PersonMetaData());

        PersonMetaData metaData = weakHashMap.get(pradeep);

        System.out.println(metaData);

        pradeep = null;
        System.gc();

        if (weakHashMap.containsValue(metaData)){
            System.out.println("Still contains key");
        } else {
            System.out.println("Key gone");
        }

    }
}

final class Person{ }

class PersonMetaData{
    LocalDateTime date;

    public PersonMetaData() {
        date = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return date.toString();
    }
}
