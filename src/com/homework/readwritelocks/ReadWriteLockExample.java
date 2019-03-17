package com.homework.readwritelocks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample<E> {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();
    private final List<E> list = new ArrayList<>();

    public void write(E o) {
        writeLock.lock();
        try {
            list.add(o);
            System.out.println("Adding element by thread " + Thread.currentThread().getName());
        } finally {
            writeLock.unlock();
        }
    }

    public E read(int i) {
        readLock.lock();
        try {
            System.out.println("Printing elements by thread " + Thread.currentThread().getName());
            return list.get(i);
        } finally {
            readLock.unlock();
        }
    }

    public static void readWriteTest() {
        ReadWriteLockExample<Integer> test = new ReadWriteLockExample<>();
        test.write(1);
        test.write(2);
        test.write(3);
        test.write(4);
        System.out.println("Printing the first element: " + test.read(1));
    }

}

