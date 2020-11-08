package cn.supfox;

public class Typetransform {

    public static void main(String[] args) {
        int i =0;
        add(i);
        System.out.println(i);

        Integer integer = new Integer("1");
        addInteger(integer);
        System.out.println(integer);

    }

    private  static void  add(int i) {
        i = 1;
        System.out.println(i);
    }

    private  static void  addInteger(Integer i) {
        i = 3;
        System.out.println(i);
    }
}
