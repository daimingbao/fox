package com.fox.test;

import com.fox.test.DVD;
public class MovieTest {


    /**
     * 测试电影时长设置
     */
    public void testMovie() {

        DVD dvd = new DVD();
        dvd.setDuration(50);
        dvd.read();
    }

    /**
     * 测试播放中是否可以播放
     */
    public void testMovie2() {

        DVD dvd = new DVD();
        dvd.setEnReading(true);
        dvd.read();
    }
}
