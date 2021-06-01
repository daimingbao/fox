package cn.supfox.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * 通过jdk线程的中断标记来对线程进行中断
 */
public class ThreadInterruptTest {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            //判断是否被中断
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("有没有被中断"+ Thread.currentThread().isInterrupted());
            }
            System.out.println("是否被中断了1：" +Thread.currentThread().isInterrupted());
            System.out.println("清楚当前线程中断标记：" +Thread.interrupted());
            System.out.println("是否被中断了2：" +Thread.currentThread().isInterrupted());
            System.out.println("线程结束了");
        });

        thread.start();
        Thread.sleep(1l);
        //设置thread线程中断标志为true
        thread.interrupt();
        LockSupport.park();

    }
}
