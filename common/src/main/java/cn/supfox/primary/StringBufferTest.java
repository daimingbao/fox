package cn.supfox.primary;

import java.util.concurrent.locks.LockSupport;

public class StringBufferTest {

    public static void main(String[] args) throws InterruptedException {

        StringBuffer sb = new StringBuffer();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            sb.append(i);
//            Thread.sleep(10l);

        }
        long end = System.currentTimeMillis();
        System.out.println(sb.toString().getBytes().length);
        System.out.println(sb.length());
        System.out.println(end - start);

        System.out.println(sb.capacity());

        LockSupport.park();
    }
}
