package cn.supfox.pattern.adapter.demo.passport.adapterv2;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        IPassportForThird adapter = new PassportForThirdAdapter();
        adapter.loginForQQ("sdfasdfasfasfas");

        /**
         * 问题：如何增加了一个抖音登录，那么就需要修改IPassportForThid接口（增加一个方法）且 PassportForThirdAdapter 也需要增加一个方法<br>
         * 怎么不让增加一个方法呢？策略模式
         */
    }
}
