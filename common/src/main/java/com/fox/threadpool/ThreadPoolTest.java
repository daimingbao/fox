package com.fox.threadpool;

import com.sun.tools.corba.se.idl.StructEntry;

import java.util.Queue;
import java.util.concurrent.*;

public class ThreadPoolTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue(5);
        queue.offer("",2,TimeUnit.HOURS);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,5,2, TimeUnit.SECONDS,new ArrayBlockingQueue<>(10));
        Future<?> a = executor.submit(new FutureTask<>(() -> System.out.printf("a"), null));
        Object o = a.get();
    }
}
