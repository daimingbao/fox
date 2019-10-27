package com.fox.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author dmb
 * @since 2019/8/30
 */
public class ThreadTest {

    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());

        Thread thread = new Thread(() -> {

            while (true) {
                System.out.println("1");
            }
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                System.out.println("status:"+Thread.currentThread().isInterrupted());
//                e.printStackTrace();
//            }
        });

        thread.start();
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(1));

        System.out.println(thread.isInterrupted());
        thread.interrupt();
        System.out.println(thread.isInterrupted());
        Thread.interrupted();
        LockSupport.park();

    }
}
