package com.homework.locks;

public class MySecondTread extends Thread {
    @Override
    public void run() {
        System.out.println(getName() + " start working");
        while (true) {
            if (LockExample.lock.tryLock()) {
                System.out.println(getName() + " is working");
                break;
            } else {
                System.out.println(getName() + " waiting");
            }
        }
    }

}
