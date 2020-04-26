package design_patterns.creational_patterns.p1_singleton;

import java.lang.reflect.Constructor;

/*
Concepts:
1. Only one instance created
2. Control of resource (object creation)
3. Lazily loaded (usually)
4. Examples: Runtime, Logger (can be factory as well), Spring Beans

Design:
1. Class is responsible for lifecycle
2. Thread safe
3. Private instance
4. Private Constructor
5. No Parameter in constructor (Factory pattern have parameters)

Examples:
Runtime runtime = Runtime.getRuntime(); runtime.gc();

Pitfalls:
1. Difficult to unit test - private Constructor
2. If not careful - not thread safe
3. Confused with factory - if parameter is required in getInstance, it is factory

Note:
1. java.util.Calendar is not Singleton. It is prototype
 */
public class P1Singleton {
    public static void main(String[] args) throws Exception {
        DatabaseSingleton instance1 = DatabaseSingleton.getInstance();
        DatabaseSingleton instance2 = DatabaseSingleton.getInstance();
        System.out.println(instance1 == instance2);

        // Creating object using reflection
        Constructor<DatabaseSingleton> cons = DatabaseSingleton.class.getDeclaredConstructor();
        cons.setAccessible(true);
        // DatabaseSingleton instance3 = cons.newInstance();
    }
}
