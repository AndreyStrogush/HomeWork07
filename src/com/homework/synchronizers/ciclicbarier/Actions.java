package com.homework.synchronizers.ciclicbarier;

class Actions implements Runnable {
    @Override
    public void run() {
        System.out.println("The barrier is reached");
    }
}

