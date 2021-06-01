package cn.supfox.concurent.juc;

import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock reentrantLock = new ReentrantLock();

        Condition condition = reentrantLock.newCondition();

        reentrantLock.lock();
        reentrantLock.lock();

        Thread thread = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(2000);
                reentrantLock.lock();
                System.out.println("子线程1获取到了锁" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                condition.await();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                reentrantLock.lock();
                System.out.println("子线程2获取到了锁" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                Thread.sleep(3000);
                reentrantLock.unlock();
                condition.signal();
            }
        });

        thread.start();

        Thread.sleep(2000);

        reentrantLock.unlock();
        thread2.start();


//        reentrantLock.unlock();
        reentrantLock.unlock();
        System.out.println("主线程获取到锁，并释放锁");
    }
}
