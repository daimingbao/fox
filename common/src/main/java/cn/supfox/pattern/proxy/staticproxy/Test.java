package cn.supfox.pattern.proxy.staticproxy;

/**
 * Created by Tom.
 */
public class Test {

//    @Autowired
//    A a;

    @org.junit.Test
    public void test0()
    {
        IPerson zhangLaosan = new ZhangLaosan(new ZhangSan());
        zhangLaosan.findLove();
    }

    @org.junit.Test
    public void test1()
    {
        IPerson zhanglaosi = new ZhangLaosi(new ZhangSi());
        zhanglaosi.findLove();
    }

    /**
     * 1. 静态代理：因为代理的逻辑不一样类的实现不一样，每个实现是不一样的类，每次来新的代理需求需要新建新的代理类<br>
     */
}
