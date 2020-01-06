package com.fox.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author dmb
 * @since 2019/11/5
 */
public class QueueTest {

    private static volatile int count = 0;

    public static void main(String[] args) {
//        count++;
//        System.out.println(count);
//        ++count;
//        System.out.println(count);
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);


        for (int i=0 ; i<9; i++) {
//            arrayBlockingQueue.add(1);
//            arrayBlockingQueue.
        }

        new Thread(()->{
            while (true) {
                Object poll = null;
                try {
                    System.out.println(""+Thread.currentThread().getName()+":"+ count);
                    poll = arrayBlockingQueue.offer(++count, 5, TimeUnit.SECONDS);
//                    TimeUnit.SECONDS.sleep(5);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                System.out.println(poll);
            }
        }, "t2").start();

        new Thread(()->{
            while (true) {
                Object poll = null;
                try {

                    poll = arrayBlockingQueue.poll(5, TimeUnit.SECONDS);
                    System.out.println(""+Thread.currentThread().getName()+":"+ poll);
//                    System.out.println(poll);
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//
            }
        }, "t1").start();

        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
