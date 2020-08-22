package cn.supfox.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @author dmb
 * @since 2019/8/30
 */
public class ThreadSynchronizedBlockedTest {


    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {

            synchronized (ThreadSynchronizedBlockedTest.class) {
                System.out.println("1");
                try {
                    Thread.sleep(2000000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Blocking_Thread");

        Thread thread2 = new Thread(() -> {

            synchronized (ThreadSynchronizedBlockedTest.class) {
                System.out.println("2");
            }
        }, "Blocking_Thread");

        thread.start();
        thread2.start();

        LockSupport.park();

    }
}
