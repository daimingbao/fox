package cn.supfox.volatiledemo;

public class SynchronizedToVisiableTest {

    private static int a;
    private static int b;
    public void add() {
        if (a < Integer.MAX_VALUE) {
            a++;
        }
        if (b < Integer.MAX_VALUE) {
            b++;
        }
    }
    public void print() {
        if (a != b) {
            System.out.println(a + "-" + b);
        }
    }
    public static void main(String[] args) {
        SynchronizedToVisiableTest test = new SynchronizedToVisiableTest();
        new Thread(() -> {
            while (true) {
                test.add();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                test.print();
            }
        }).start();
    }

}
