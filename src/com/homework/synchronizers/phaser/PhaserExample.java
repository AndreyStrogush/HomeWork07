package com.homework.synchronizers.phaser;

import java.util.concurrent.Phaser;

public class PhaserExample {


    public static void phaserTest() throws InterruptedException {
        Phaser phaser = new Phaser();
        phaser.register();
        int phasecount = phaser.getPhase();
        System.out.println("Phasecount is " + phasecount);
        new PhaserExample().testPhaser(phaser, 2000);
        new PhaserExample().testPhaser(phaser, 4000);
        new PhaserExample().testPhaser(phaser, 6000);
        phaser.arriveAndDeregister();
        Thread.sleep(10000);
        phasecount = phaser.getPhase();
        System.out.println("Phasecount is " + phasecount);
    }

    private void testPhaser(final Phaser phaser, final int sleepTime) {
        phaser.register();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " arrived");
                phaser.arriveAndAwaitAdvance();
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " after passing barrier");
        }).start();
    }

}
