package com.homework.locks;

public class MyTread extends Thread {
    @Override
    public void run() {
        LockExample.lock.lock();
        System.out.println(super.getName() + " start working");
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(super.getName() + " finished working");
        LockExample.lock.unlock();
    }

}
