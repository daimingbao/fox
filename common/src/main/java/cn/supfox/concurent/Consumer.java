package cn.supfox.concurent;

import lombok.SneakyThrows;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Consumer extends Thread{

    private Queue queue;

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (queue.isEmpty()) {
                System.out.println("队列空了，停止消费");
                condition.await();
            }
            System.out.println("消费：" + queue.poll());
            lock.unlock();
        }
    }

    private Condition condition;

    public Consumer(Queue queue, Lock lock,Condition condition,  int maxSize) {
        this.queue = queue;
        this.condition = condition;
        this.lock = lock;
        this.maxSize = maxSize;
    }

    private Lock lock;

    private int maxSize;
}
