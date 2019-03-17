package com.homework.singleton;

public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        Singleton localExample = instance;
        if (localExample == null) {
            synchronized (Singleton.class) {
                localExample = instance;
                if (localExample == null) {
                    instance = localExample = new Singleton();
                }
            }
        }
        return localExample;
    }

}
