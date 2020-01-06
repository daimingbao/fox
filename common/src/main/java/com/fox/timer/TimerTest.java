package com.fox.timer;

import lombok.extern.slf4j.Slf4j;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.LockSupport;

/**
 * @author dmb
 * @since 2019/10/28
 */
@Slf4j
public class TimerTest
{
    public static void main(String[] args) {

        Timer timer = new Timer("timer_1", true);

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                log.info("timer");
            }
        }, 5, 2000);

        LockSupport.park();
    }
}
