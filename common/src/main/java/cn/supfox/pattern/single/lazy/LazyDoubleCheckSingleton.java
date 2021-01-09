package cn.supfox.pattern.single.lazy;

/**
 * Created by Tom.
 */

/**
 * 优点:性能高了，线程安全了
 * 缺点：可读性难度加大，不够优雅
 */
public class LazyDoubleCheckSingleton {
    private volatile static LazyDoubleCheckSingleton instance;
    private LazyDoubleCheckSingleton(){}

    public static LazyDoubleCheckSingleton getInstance(){
        //检查是否要阻塞
        if (instance == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                //检查是否要重新创建实例
                if (instance == null) {
                    instance = new LazyDoubleCheckSingleton();
                    //指令重排序的问题
                }
            }
        }
        return instance;
    }
    /**
     * 思考以下问题：
     * 1. 把为什么要加Synchronize() --> 第一个if(instance ==null) 和第二个 if(instance ==null)的作用 <br>
     * 2. 我为什么要加volatile，不加会有什么问题<br>
     *
     *     内存空间
     *     初始化
     *     赋值
     */
}
