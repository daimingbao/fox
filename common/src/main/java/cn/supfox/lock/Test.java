package cn.supfox.lock;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

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

            for(int i=0;i<1000;i++){

                new Thread(()->Test.incr()).start();

            }

            Thread.sleep(5000);

            System.out.println("result:"+count.get());

        }


}
