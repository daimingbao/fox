package com.fox.syncronized;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dmb
 * @since 2019/10/27
 */
@Slf4j
public class SyncTest {

    public static final Object o11 = new Object();

    public static List list = new ArrayList();

    public static List<Integer> changeList = new ArrayList();

    public void change1() {

        new Thread(() -> {
            int i = 0;
            while (true) {
                synchronized (o11) {
                    if (changeList.size() % 2 == 0) {
                        int b = 0;
                        if (changeList.size() == 0) {
                            changeList.add(0);
                        } else {
                            b = changeList.get(changeList.size() - 1) + 1;
                            changeList.add(b);
                        }
                        System.out.println(Thread.currentThread().getName() + "生产了" + b);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        o11.notify();
                    } else {
                        try {
                            o11.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

    }

    public void change2() {

        new Thread(() -> {
            int i = 0;
            while (true) {
                synchronized (o11) {
                    if (changeList.size() % 2 != 0) {
                        int a = changeList.get(changeList.size() - 1) + 1;
                        System.out.println(Thread.currentThread().getName() + "生产了" + a);
                        changeList.add(a);
                        o11.notify();
                    } else {
                        try {
                            o11.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

    }


    public void productor() {

        new Thread(() -> {
            int i = 0;
            while (true) {
                synchronized (o11) {
                    if (list.size() == 0) {
                        i = i + 1;
                        list.add(i);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("生产者生产:" + i);
                        o11.notify();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            o11.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

    }

    public void consumer() {

        new Thread(() -> {
            while (true) {
                synchronized (o11) {
                    if (list.size() == 0) {
                        try {
                            o11.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Object o = list.get(0);
                    list.remove(o);
                    System.out.println("消费者消费:" + o);
                    o11.notifyAll();
                }
            }
        }).start();

    }

    public static void main(String[] args) throws InterruptedException {

        SyncTest syncTest = new SyncTest();
//        syncTest.productor();
//        syncTest.consumer();

        syncTest.change1();
        syncTest.change2();

        synchronized (SyncTest.class) {
            SyncTest.class.wait();
        }

//        CountDownLatch countDownLatch = new CountDownLatch(1);
//
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    countDownLatch.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                lock();
//            }
//        },"t1");
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    countDownLatch.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                countDownLatch.countDown();
//                lock();
//            }
//        },"t2");
//
//        t1.start();
//        t2.start();
//        countDownLatch.countDown();
//        log.info("start aquaire lock .....");
//
//        try {
//            TimeUnit.MINUTES.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

    public static synchronized void lock() {

        Thread.State state = Thread.currentThread().getState();
        System.out.println(state);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        System.out.println(stackTrace[0].toString());
        boolean alive = Thread.currentThread().isAlive();
        System.out.println(alive);
        boolean b = Thread.currentThread().holdsLock(SyncTest.class);
        System.out.println(b);

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.error("lock error", e);
        }

    }

}
