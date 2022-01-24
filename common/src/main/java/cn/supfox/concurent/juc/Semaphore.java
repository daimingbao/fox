package cn.supfox.concurent.juc;

import lombok.SneakyThrows;
import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;
import java.util.concurrent.locks.LockSupport;


public class Semaphore {

    public static void main(String[] args) {


        java.util.concurrent.Semaphore semaphore = new java.util.concurrent.Semaphore(3);

        for (int i=0; i< 5; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    semaphore.acquire(1);
                    System.out.println(Thread.currentThread().getName() + " 在"+ DateFormatUtils.format(new Date(),"yyyy/MM/dd HH:mm:ss") + " 申请到一个令牌");
                    Thread.sleep((finalI +1) *3000);
                    semaphore.release(1);
                }
            }).start();
        }

        LockSupport.park();

    }
}
