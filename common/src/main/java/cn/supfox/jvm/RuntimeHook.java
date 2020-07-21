package cn.supfox.jvm;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author dmb
 * @since 2019/9/19
 */
@Slf4j
public class RuntimeHook {

    public static void main(String[] args) throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("jvm关闭时候调用钩子函数");
            }
        }));



        log.info("主线程运作中");
        TimeUnit.SECONDS.sleep(2);
    }
}
