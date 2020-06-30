package com.fox.thread;

import com.sun.deploy.security.SelectableSecurityManager;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author dmb
 * @since 2019/8/30
 */
public class ThreadTest {

    public static volatile int enable = 0;

    public static void main(String[] args) throws InterruptedException {

//        Objects o = null;
//        synchronized (o) {
//            System.out.println("111");
//        }

//        System.out.println(Runtime.getRuntime().availableProcessors());

        Thread thread = new Thread(() -> {

            while (!Thread.currentThread().isInterrupted()) {
//                enable ++;

                System.out.println("你好"+enable);
//                try {
//                    Thread.sleep(1000l);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

//                while (true) {
//                    System.out.println(1);
//                    System.out.println("1");
//                }
            }
            System.out.println("停止了");
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                System.out.println("status:"+Thread.currentThread().isInterrupted());
//                e.printStackTrace();
//            }
        });

        thread.start();
        enable = 1;
        Thread.sleep(5000l);

        thread.interrupt();



//        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(1));
//
//        System.out.println(thread.isInterrupted());
//        thread.interrupt();
//        System.out.println(thread.isInterrupted());
//        Thread.interrupted();
        LockSupport.park();

    }
}
