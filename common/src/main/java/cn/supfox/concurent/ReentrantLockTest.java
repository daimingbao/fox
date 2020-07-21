package cn.supfox.concurent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
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

    private static volatile boolean notice = true;

    public static void main(String[] args) {

//        lock.lockInterruptibly();

        Condition condition = lock.newCondition();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lock();
                    try {
                        if (!notice) {
                            condition.await();
                            unlock();
                            notice = true;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (notice) {
                        lock();
                        condition.signal();
                        unlock();
                        notice = false;
                    }
                }
            }
        }).start();

        LockSupport.parkNanos( TimeUnit.SECONDS.toNanos(5));

    }

    public static void lock() {

        lock.lock();
        try {
            TimeUnit.SECONDS.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("获取到锁:{}", Thread.currentThread().getName());

    }

    public static void unlock() {
        lock.unlock();
    }

}
