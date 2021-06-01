package cn.supfox.thread.state;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class ThreadStateTest {

    public static void main(String[] args) {


        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                TimeUnit.SECONDS.sleep(200);
            }
        }, "time-waiting-thread-1").start();

        /**
         * "block-thread-2" #12 prio=5 os_prio=31 tid=0x00007f97ef8b8800
         *     nid=0xa703 in Object.wait() [0x0000700002e6e000]
         *    java.lang.Thread.State: WAITING (on object monitor)
         */
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                synchronized (this) {
                    wait();
                }
            }
        }, "waiting-thread-2").start();


        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                synchronized (this) {
                    wait(2000000);
                }
            }
        }, "time-waiting-thread-3").start();

        new MyBlockThread("block-thread-1").start();
        new MyBlockThread("block-thread-2").start();
    }

    private static class MyBlockThread extends Thread {

        public MyBlockThread(String name) {
            super(name);
        }

        @SneakyThrows
        @Override
        public void run() {
            synchronized (MyBlockThread.class) {
                System.out.println("1");
                TimeUnit.MINUTES.sleep(1);
            }
        }
    }

}
