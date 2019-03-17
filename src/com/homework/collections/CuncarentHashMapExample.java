package com.homework.collections;

import java.util.concurrent.ConcurrentHashMap;

public class CuncarentHashMapExample {
    private final ConcurrentHashMap<Integer, String> conHashMap = new ConcurrentHashMap<>();

    public static void mapTest() {
        CuncarentHashMapExample example = new CuncarentHashMapExample();
        new Thread(() -> {
            example.conHashMap.put(1, "first");
            example.conHashMap.put(2, "second");
            example.conHashMap.put(3, "third");
            example.conHashMap.put(4,"fourth");
            example.conHashMap.replace(1,"first", "new");
            System.out.println(example.conHashMap.toString());
        }).start();
        new Thread(() -> {
            example.conHashMap.remove(2);
            System.out.println(example.conHashMap.toString());
        }).start();
    }

}
