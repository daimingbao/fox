package cn.supfox.concurent;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);


        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                countDownLatch.await();
                System.out.println(""+Thread.currentThread().getName() + " .. finish");
            }
        }).start();

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println(""+Thread.currentThread().getName() + " .. countdown");
                Thread.sleep(5000);
                countDownLatch.countDown();
                countDownLatch.countDown();
            }
        }).start();

        countDownLatch.await();
        System.out.println(""+Thread.currentThread().getName() + " .. finish");
    }
}
