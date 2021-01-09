package cn.supfox.pattern.adapter.general.classadapter;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        /**
         * 通过adapter 把adaptee和target关联起来<br>
         */
        Target adapter = new Adapter();
        int result = adapter.request();
        System.out.println(result);
    }
}
