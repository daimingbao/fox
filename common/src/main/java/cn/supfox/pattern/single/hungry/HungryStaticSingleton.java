package cn.supfox.pattern.single.hungry;

/**
 * Created by Tom.
 */
public class HungryStaticSingleton {
    //先静态后动态
    //先上，后下
    //先属性后方法
    private static final HungryStaticSingleton hungrySingleton;

    //类加载的时候就初始化了<br>
    //装个B
    static {
        hungrySingleton = new HungryStaticSingleton();
    }

    private HungryStaticSingleton(){}

    public static HungryStaticSingleton getInstance(){
        return  hungrySingleton;
    }
}
