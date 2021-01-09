package cn.supfox.pattern.adapter.demo.power.classadapter;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        //输出DC5<br>
        DC5 adapter = new PowerAdapter();
        adapter.output5V();
        //
        //PowerAdapter 还可以输出220违背了最少知道原则
    }
}
