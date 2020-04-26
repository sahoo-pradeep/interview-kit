package design_patterns.creational_patterns.p1_singleton;

public class DatabaseSingleton {
    // Lazy loading
    // Eager Loading may result in slow startup of application
    // Added volatile so that object is always pushed to main memory.
    private static volatile DatabaseSingleton instance = null;

    // Private Constructor
    private DatabaseSingleton() {
        // Handling creation of object using Reflection
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create object");
        }
    }

    // Static method returning instance of DatabaseSingleton
    public static DatabaseSingleton getInstance() {
        if (instance == null) {
            // Thread safe
            synchronized (DatabaseSingleton.class) {
                // Double check
                if (instance == null) {
                    instance = new DatabaseSingleton();
                }
            }
        }
        return instance;
    }
}
