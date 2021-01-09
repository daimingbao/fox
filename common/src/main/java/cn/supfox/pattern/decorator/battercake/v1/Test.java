package cn.supfox.pattern.decorator.battercake.v1;

/**
 * Created by Tom.
 */
public class Test {

    /**
     * 这里是采用继承，来一个就继承一个，类膨胀<br>
     * @param args
     */
    public static void main(String[] args) {
        Battercake battercake = new Battercake();
        System.out.println(battercake.getMsg() + ",总价：" + battercake.getPrice());

        BattercakeWithEgg battercakeWithEgg = new BattercakeWithEgg();
        System.out.println(battercakeWithEgg.getMsg() + ",总价：" + battercakeWithEgg.getPrice());

        BattercakeWithEggAndSauage battercakeWithEggAndSauage = new BattercakeWithEggAndSauage();
        System.out.println(battercakeWithEggAndSauage.getMsg() + ",总价：" + battercakeWithEggAndSauage.getPrice());
    }

}
