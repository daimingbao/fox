package cn.supfox.pattern.adapter.demo.power.objectadapter;


/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        //使用组合来实现
        DC5 adapter = new PowerAdapter(new AC220());
        adapter.output5V();

        //对于外部只具备他应该知道的功能，比如DC5<br>
    }
}
