package cn.supfox.pattern.proxy.staticproxy;

/**
 * Created by Tom.
 */
public class ZhangLaosi implements IPerson {

    private IPerson zhangsi;

    public ZhangLaosi(IPerson zhangsan) {
        this.zhangsi = zhangsan;
    }

    /**
     * 为什么只能给张三物色，因为只有zhangsan 这个成员，如果要给其他人代理那么只能修改代码，修改代码就违背了开闭原则<br>
     */
    public void findLove() {
        System.out.println("张老四开始物色"); // 实际
        zhangsi.findLove();
        System.out.println("开始交往");
    }

}
