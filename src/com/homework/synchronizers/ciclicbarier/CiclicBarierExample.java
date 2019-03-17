package com.homework.synchronizers.ciclicbarier;

import java.util.concurrent.CyclicBarrier;

public class CiclicBarierExample {
    public static void ciclicBarierTest() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Actions());
        System.out.println("Start");
        new MyThread(cyclicBarrier, "A");
        new MyThread(cyclicBarrier, "B");
        new MyThread(cyclicBarrier, "C");
        new MyThread(cyclicBarrier, "D");
        new MyThread(cyclicBarrier, "E");
        new MyThread(cyclicBarrier, "F");
    }

}
