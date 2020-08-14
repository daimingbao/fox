package cn.supfox.threadlocal;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author dmb
 * @since 2019/10/27
 */
@Slf4j
public class ThreadLocalTest {

    private static ThreadLocal<String> threadLocal = new  ThreadLocal<>();

    public static void main(String[] args) {

        String s = threadLocal.get();
        System.out.println(s);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("t1");
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("t2");
            }
        }, "t2");

        threadLocal.set("main");
        log.info(threadLocal.get());
        try {
            TimeUnit.MINUTES.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
