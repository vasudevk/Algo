package com.pluralsight.singleton;

public class DbSingleton {


    // Eagerly loaded - Since a new instance is created whether it is used or not
    // private static DbSingleton instance = new DbSingleton();

    // Lazily loaded - An instance is only created if the object is null
    // private static DbSingleton instance = null;

    // Thread-safe Singleton
    private static volatile DbSingleton instance = null;

    // Since there is a private constructor, a new object cannot be created using new keyword
    private DbSingleton() {

        // Protecting from Reflections call
        if (instance != null) {
            throw new RuntimeException("Use getInstancec() to create");
        }
    }

    public static DbSingleton getInstance() {
        if (instance == null) {

            // Making it thread-safe by synchronizing the class if the instance is null
            synchronized (DbSingleton.class) {
                if (instance == null) {
                    instance = new DbSingleton();
                }
            }
        }

        return instance;
    }
}