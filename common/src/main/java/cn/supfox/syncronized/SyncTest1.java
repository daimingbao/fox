package cn.supfox.syncronized;


public class SyncTest1 {

    private final int a;

    private SyncTest1(int a) {
        this.a = a;
    }


    public static void main(String[] args) {
        SyncTest1 syncTest1 = new SyncTest1(2);
        synchronized (syncTest1) {

        }
    }
}
