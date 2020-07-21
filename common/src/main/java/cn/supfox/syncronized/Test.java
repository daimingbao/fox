package cn.supfox.syncronized;

public class Test {

    public static void main(String[] args) {
        add(0);
    }

    public static void add(int i) {
        int i1 = i+1;
        System.out.println(i1);
        add(i1);
    }
}
