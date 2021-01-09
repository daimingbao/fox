package cn.supfox.pattern.adapter.demo.power.classadapter;

/**
 * Created by Tom.
 * 继承原有的，实现输出的接口<br>
 */
public class PowerAdapter extends AC220 implements DC5 {
    public int output5V() {
        int adapterInput = super.outputAC220V();
        //具体转换就在这里只要这里可以转换就是适配器，至于继承AC220和实现DC5是java语法上面的写法，经验总结这些写法是比较好的<br>
        int adapterOutput = adapterInput / 44;
        System.out.println("使用Adapter输入AC" + adapterInput + "V,输出DC" + adapterOutput + "V");
        return adapterOutput;
    }
}
