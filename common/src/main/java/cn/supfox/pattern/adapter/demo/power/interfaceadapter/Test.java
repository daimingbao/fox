package cn.supfox.pattern.adapter.demo.power.interfaceadapter;


/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        DC adapter = new PowerAdapter(new AC220());
        adapter.output5V();

        adapter.output12V();
        adapter.output24V();
        /**
         * 不符合接口隔离原则和单一职责原则<br>
         */
        /**
         * 接口适配器是接口不只是有一个方法，比方说有5伏/3/2不可能定义很多接口，比如DC2/DC3/DC5，这些你是可以自己琢磨出来的<br>
         * 1. 如果一个方法一个适配器那么adapter会很多，这里使用一个adapter来适配所有的接口<br>
         */
    }
}
