package com.homework.collections;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWrite {
    private static List<Integer> list = new CopyOnWriteArrayList<>();

    public static void copyOnWriteTest() {
        new Thread(() -> {
            list.add(1);
            list.add(3);
            list.add(5);
            list.add(6);
            System.out.println("From first thread: ");
            list.forEach(System.out::println);
        }).start();

        new Thread(() -> {
            list.add(8);
            list.add(9);
            list.add(10);
            System.out.println("From second thread: ");
            list.forEach(System.out::println);
        }).start();
    }

}
