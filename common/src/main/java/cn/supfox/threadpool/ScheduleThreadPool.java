package cn.supfox.threadpool;

import cn.supfox.utils.DateTimeUtils;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class ScheduleThreadPool {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor =
                new ScheduledThreadPoolExecutor(5);

        scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(DateTimeUtils.formatNow() +"====20秒执行一次");
            }
        },4L,20L, TimeUnit.SECONDS);


        LockSupport.park();
    }

}
