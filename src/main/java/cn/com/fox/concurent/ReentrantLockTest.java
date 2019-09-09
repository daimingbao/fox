package cn.com.fox.concurent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dmb
 * @since 2019/9/6
 */
@Slf4j
public class ReentrantLockTest {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        Condition condition = lock.newCondition();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock();
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock();
                condition.signalAll();
            }
        }).start();

        LockSupport.park();

    }

    public static void lock() {

        lock.lock();
        log.info("获取到锁:{}", Thread.currentThread().getName());

    }

}
