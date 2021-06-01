package cn.supfox.concurent.juc;

import cn.supfox.concurent.Consumer;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerTest {

    public static void main(String[] args) {
        Queue queue = new ArrayBlockingQueue(200);
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        int maxQueueSize = 100;
        Producer producer = new Producer(queue, lock, condition, maxQueueSize);
        Consumer consumer = new Consumer(queue, lock, condition, maxQueueSize);
        producer.start();
        consumer.start();

        LockSupport.park();
    }
}
