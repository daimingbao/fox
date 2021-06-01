package cn.supfox.volatiledemo;

public class VolatileTest {

    private static volatile boolean success = true;

    public static void main(String[] args) throws InterruptedException {

        success = false;


    }
}
