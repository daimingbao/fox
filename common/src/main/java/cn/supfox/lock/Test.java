package cn.supfox.lock;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

        static AtomicInteger count= new AtomicInteger(0);

        public static void incr(){

            synchronized (count) {

                try {

                    Thread.sleep(1);

                } catch (InterruptedException e) {

                    e.printStackTrace();

                }

                count.incrementAndGet();

            }

        }

        public static void main(String[] args) throws IOException, InterruptedException {

            Lock lock = new ReentrantLock();

            List<Thread> threadList = new ArrayList<>();
            for(int i=0;i<2;i++){

                Thread thread = new Thread(() -> {


                    lock.lock();

                    System.out.println(Thread.currentThread().getName() + "状态" + Thread.currentThread().getState());

                    try {
                        Thread.sleep(50000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.unlock();

                });
                thread.start();
                threadList.add(thread);
            }



            Thread.sleep(5000);
            for (int i = 0; i < threadList.size(); i++) {
                Thread.State state = threadList.get(i).getState();
                System.out.println(state);
            }

            System.out.println("result:"+count.get());

        }


}
