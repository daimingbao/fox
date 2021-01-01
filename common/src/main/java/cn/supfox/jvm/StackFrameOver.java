package cn.supfox.jvm;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class StackFrameOver {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        //信号量，只允许 3个线程同时访问
        Semaphore semaphore = new Semaphore(3);

        for (int i=0;i<10;i++){
            final long num = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        //获取许可
                        semaphore.acquire();
                        //执行
                        System.out.println("Accessing: " + num);
                        Thread.sleep(new Random().nextInt(5000)); // 模拟随机执行时长
                        //释放
                        semaphore.release();
                        System.out.println("Release..." + num);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        executorService.shutdown();
//        System.out.println();

//            String s = new String("1");
//            s.intern();
//            String s2 = "1";
//            System.out.println(s == s2);
//
//            String s3 = new String("1") + new String("1");
//            s3.intern();
//            String s4 = "11";
//            System.out.println(s3 == s4);
//        add(atomicInteger);
    }

//    public static int add(AtomicInteger atomicInteger){
//       atomicInteger.incrementAndGet();
//        System.out.println(atomicInteger.get());
//        return add(atomicInteger);
//    }

}
