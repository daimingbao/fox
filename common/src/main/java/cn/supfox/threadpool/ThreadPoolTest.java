package cn.supfox.threadpool;

import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

public class ThreadPoolTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
            for (int i=0; i<8; i++) {
                threadPoolExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1L);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("测试5ms睡眠结束啊");
                    }
                });
            }

            LockSupport.park();

        }

}

//        BlockingQueue<String> queue = new ArrayBlockingQueue(5);
//        queue.offer("",2,TimeUnit.HOURS);
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,5,2, TimeUnit.SECONDS,new ArrayBlockingQueue<>(10));
//        Future<?> a = executor.submit(new FutureTask<>(() -> System.out.printf("a"), null));
//        Object o = a.get();
//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//                //业务逻辑
//            }
//        });
