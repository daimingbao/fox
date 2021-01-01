package cn.supfox.jvm;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GarbageTest {

    static List<GarbageTest> list = new ArrayList();
    public static void main(String[] args) throws InterruptedException {

        InputStream in = System.in;
        Scanner sc = new Scanner(in);
        int i = sc.nextInt();
        if (i == 11) {
            return;
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    GarbageTest garbageTest = new GarbageTest();

                    list.add(garbageTest);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();




    }
}
