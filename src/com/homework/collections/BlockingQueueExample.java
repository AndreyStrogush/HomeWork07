package com.homework.collections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class BlockingQueueExample {
    private static BlockingQueue<String> blockingQueue = new PriorityBlockingQueue<>();

    public static void blockingQueueTest() throws InterruptedException {
        new Thread(() -> System.out.println(blockingQueue.add("some item"))).start();
        Thread.sleep(200);
        new Thread(() -> {
            try {
                System.out.println(blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
