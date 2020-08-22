package cn.supfox.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class BlockThreadInterruptTest {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {

            while (!Thread.currentThread().isInterrupted()) {
                try {
                    System.out.println("没清除的中断标记0"+ Thread.currentThread().isInterrupted());
                    Thread.sleep(1000l);
                } catch (InterruptedException e) {
                    System.out.println("睡眠中的线程被中断异常中断了，还是可以继续执行，可以充分利益线程资源，唤醒睡眠" +
                            "中的线程执行任务");
                    //InterruptedException 会清除中断标记
                    System.out.println("清除的中断标记2"+ Thread.currentThread().isInterrupted());
//                    e.printStackTrace();
                }
                System.out.println("中断标记1"+ Thread.currentThread().isInterrupted());
            }
            System.out.println("重置线程中断状态"+Thread.interrupted());
            System.out.println("线程中断状态"+Thread.currentThread().isInterrupted());
            System.out.println("停止了");

        });

        thread.start();
        TimeUnit.MICROSECONDS.sleep(100l);
        thread.interrupt();

        LockSupport.park();

    }
}
