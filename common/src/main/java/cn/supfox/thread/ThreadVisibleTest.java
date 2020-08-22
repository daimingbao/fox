package cn.supfox.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * 测试volatile关键字对线程间可见性的测试
 */
public class ThreadVisibleTest {

    public static volatile boolean enable  = true;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {

            while (enable) {
                System.out.println("任务执行中");
            }
            System.out.println("停止了");
        });

        thread.start();
        Thread.sleep(1l);
        enable = false;
        LockSupport.park();

    }
}
