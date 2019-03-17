package com.homework.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AtomicTest {
    public static void atomicTest(int range, int sleep) {
        AtomicInteger atomicInt = new AtomicInteger(0);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        IntStream.range(0, range)
                .forEach(i -> executor.submit(atomicInt::incrementAndGet));
        executor.shutdown();
        try {
            boolean result = executor.awaitTermination(sleep, TimeUnit.SECONDS);
            System.out.println("Result of termination " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(atomicInt.get());
    }

}
