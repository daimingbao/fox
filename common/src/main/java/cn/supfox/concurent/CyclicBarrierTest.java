package cn.supfox.concurent;

import lombok.SneakyThrows;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    //CyclicBarrier:一个循环（可复用）的屏障 使用场景：固定线程数的情况，相互等待某个屏障点。
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable(){
            @Override
            public void run() {
                System.out.println("都到了，一起学习");
            }
        });

        for (int i=0; i<3; i++) {
            int finalI = i;
            new Thread(new Runnable(){
                @SneakyThrows
                @Override
                public void run() {
                    System.out.println("线程"+ finalI +"到了，准备一起学习");
                    cyclicBarrier.await();
                    System.out.println("线程"+ finalI +"开始学习");
                }
            }).start();
        }
    }
}
