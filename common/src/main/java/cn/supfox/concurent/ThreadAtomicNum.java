package cn.supfox.concurent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dmb
 * @since 2019/9/19
 */
@Slf4j
public class ThreadAtomicNum {

    private static volatile AtomicInteger count = new AtomicInteger();

    private static Lock lock = new ReentrantLock();

    private static Condition condition1 = lock.newCondition();

    private static Condition condition2 = lock.newCondition();

    private static Condition condition3 = lock.newCondition();

    public static void test() throws InterruptedException {

        AtomicInteger count = new AtomicInteger(1);

        Thread t1 = new Thread(() -> System.out.println("1:"+count.getAndIncrement()) );
        Thread t2 = new Thread(() -> System.out.println("2:"+count.getAndIncrement()) );
        Thread t3 = new Thread(() -> System.out.println("3:"+count.getAndIncrement()) );

        while (true) {
            ExecutorService service = Executors.newSingleThreadExecutor();
            Future<?> submit = service.submit(t1);
            TimeUnit.SECONDS.sleep(1);
            service.submit(t2);
            TimeUnit.SECONDS.sleep(1);
            service.submit(t3);
            TimeUnit.SECONDS.sleep(1);
        }

    }

    public static void test2() throws InterruptedException {

        AtomicInteger count = new AtomicInteger(1);


        boolean start = false;
        while (true) {
            Thread t1 = new Thread(() -> System.out.println("1:"+count.getAndIncrement()) );
            Thread t2 = new Thread(() -> System.out.println("2:"+count.getAndIncrement()) );
            Thread t3 = new Thread(() -> System.out.println("3:"+count.getAndIncrement()) );
            t1.start();
            t1.join();
            TimeUnit.SECONDS.sleep(1);
            t2.start();
            t2.join();
            TimeUnit.SECONDS.sleep(1);
            t3.start();
            t3.join();
            TimeUnit.SECONDS.sleep(1);
//            start = true;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        double a=  10/0;
        ThreadAtomicNum threadAtomicNum = new ThreadAtomicNum();
//        test();
//        test2();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (threadAtomicNum) {
                    System.out.println("2");
                    try {
                        threadAtomicNum.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("4");
                }
            }
        },"test").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (threadAtomicNum) {
                    System.out.println("2");
                    try {
                        threadAtomicNum.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("4");
                }
            }
        },"test1").start();
//        synchronized (ThreadAtomicNum.class) {
//            System.out.println("1");
//            ThreadAtomicNum.class.wait();
//            System.out.println("3");
//        }



//        Thread t1 = new Thread( new  CountThread(), "a" );
//        Thread t2 = new Thread( new  CountThread1(),"b");
//        Thread t3 = new Thread( new  CountThread2(),"c" );
//
//        t1.start();
//        t2.start();
//        t3.start();




    }

   static class CountThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                lock.lock();
                int i = count.incrementAndGet();
                String name = Thread.currentThread().getName();
                log.info("thread:{}, count:{}", name , i);
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    condition2.signal();
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                condition1.signal();
                lock.unlock();
            }

        }
    }

    static class CountThread1 implements Runnable {

        @Override
        public void run() {
            while (true) {
                lock.lock();
                int i = count.incrementAndGet();
                String name = Thread.currentThread().getName();
                log.info("thread:{}, count:{}", name , i);
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    condition3.signal();
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }

        }
    }

    static class CountThread2 implements Runnable {

        @Override
        public void run() {
            while (true) {
                lock.lock();
                int i = count.incrementAndGet();
                String name = Thread.currentThread().getName();
                log.info("thread:{}, count:{}", name , i);
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    condition1.signal();
                    condition3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }

        }
    }
}
