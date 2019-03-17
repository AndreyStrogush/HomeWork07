package com.homework;

import com.homework.atomic.AtomicTest;
import com.homework.collections.BlockingQueueExample;
import com.homework.collections.CopyOnWrite;
import com.homework.collections.CuncarentHashMapExample;
import com.homework.locks.LockExample;
import com.homework.readwritelocks.ReadWriteLockExample;
import com.homework.singleton.SingletonTest;
import com.homework.synchronizers.ciclicbarier.CiclicBarierExample;
import com.homework.synchronizers.phaser.PhaserExample;
import com.homework.synchronizers.semaphore.SemaphoreExample;

public class ConsolApp {
    public static void main(String[] args) throws InterruptedException {

        AtomicTest.atomicTest(1000, 2);

        SingletonTest.singletonTest();

        LockExample.locksTest();

        ReadWriteLockExample.readWriteTest();

        CopyOnWrite.copyOnWriteTest();

        BlockingQueueExample.blockingQueueTest();

        SemaphoreExample.semaphoreTest();

        PhaserExample.phaserTest();

        CiclicBarierExample.ciclicBarierTest();

        CuncarentHashMapExample.mapTest();

    }
    
}
