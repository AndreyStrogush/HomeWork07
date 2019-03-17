package com.homework.synchronizers.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    static Semaphore semaphore = new Semaphore(4);

    static class MyRunner extends Thread {
        String name;

        MyRunner(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(name + " : acquiring lock...");
                System.out.println(name + " : available Semaphore permits now: "
                        + semaphore.availablePermits());
                semaphore.acquire();
                System.out.println(name + " : got the permit!");
                try {
                    for (int i = 1; i <= 5; i++) {
                        System.out.println(name + " : is performing operation " + i
                                + ", available Semaphore permits : "
                                + semaphore.availablePermits());
                        Thread.sleep(100);
                    }
                } finally {
                    System.out.println(name + " : releasing lock...");
                    semaphore.release();
                    System.out.println(name + " : available Semaphore permits now: "
                            + semaphore.availablePermits());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void semaphoreTest() {
        System.out.println("Total available Semaphore permits : "
                + semaphore.availablePermits());
        MyRunner r1 = new MyRunner("A");
        MyRunner r2 = new MyRunner("B");
        MyRunner r3 = new MyRunner("C");
        r1.start();
        r2.start();
        r3.start();
    }

}
