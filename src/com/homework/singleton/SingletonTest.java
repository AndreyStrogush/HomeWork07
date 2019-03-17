package com.homework.singleton;

import java.lang.reflect.Constructor;

public class SingletonTest {
    public static void singletonTest() {
        new Thread(() -> System.out.println("Instance 1 hashCode: " + Singleton.getInstance().hashCode())).start();
        new Thread(() -> System.out.println("Instance 2 hashCode: " + Singleton.getInstance().hashCode())).start();
        //Reflection
        Singleton instance3 = Singleton.getInstance();
        Singleton reflected = null;
        try {
            Class<Singleton> constuctors = Singleton.class;
            Constructor<Singleton> constructor = constuctors.getDeclaredConstructor();
            constructor.setAccessible(true);
            reflected = constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Instance 3 hashCode:  " + instance3.hashCode());
        System.out.println("Instance 4 hashCode:  " + reflected.hashCode());
    }

}
