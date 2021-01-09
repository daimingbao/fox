package cn.supfox.pattern.proxy.staticproxy;

/**
 * Created by Tom.
 */
public class ZhangLaosan implements IPerson {

    private ZhangSan zhangsan;

    public ZhangLaosan(ZhangSan zhangsan) {
        this.zhangsan = zhangsan;
    }

    /**
     * 为什么只能给张三物色，因为只有zhangsan 这个成员，如果要给其他人代理那么只能修改代码，修改代码就违背了开闭原则<br>
     */
    public void findLove() {
        System.out.println("张老三开始物色！");
        zhangsan.findLove();
        System.out.println("开始交往！");
    }

}
