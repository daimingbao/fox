package com.fox.syncronized;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author dmb
 * @since 2019/10/27
 */
@Slf4j
public class SyncTest {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock();
            }
        },"t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
                lock();
            }
        },"t2");

        t1.start();
        t2.start();
        countDownLatch.countDown();
        log.info("start aquaire lock .....");

        try {
            TimeUnit.MINUTES.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static synchronized void lock() {

        Thread.State state = Thread.currentThread().getState();
        System.out.println(state);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        System.out.println(stackTrace[0].toString());
        boolean alive = Thread.currentThread().isAlive();
        System.out.println(alive);
        boolean b = Thread.currentThread().holdsLock(SyncTest.class);
        System.out.println(b);

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.error("lock error", e);
        }

    }

}
