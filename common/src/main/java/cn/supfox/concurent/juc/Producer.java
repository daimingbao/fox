package cn.supfox.concurent.juc;

import lombok.SneakyThrows;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Producer extends Thread {

    private Queue queue;

    private Condition condition;

    public Producer(Queue queue, Lock lock, Condition condition, int maxSize) {
        this.queue = queue;
        this.condition = condition;
        this.lock = lock;
        this.maxSize = maxSize;
    }

    private Lock lock;

    private int maxSize;


    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (queue.size() == maxSize) {
                System.out.println("队列满了");
                condition.await();
            }
            for (int i=0; i< 2; i++) {
                queue.add("msss"+new Random().nextInt());
            }
            condition.signal();
            lock.unlock();
            Thread.sleep(5000);
        }
    }

}
