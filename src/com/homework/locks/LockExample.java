package com.homework.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample extends Thread {
    public static Lock lock = new ReentrantLock();

    public static void locksTest() {
        new MyTread().start();
        new MySecondTread().start();
    }

}
