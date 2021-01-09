package cn.supfox.pattern.single.seriable;

import java.io.Serializable;

/**
 * Created by Tom.
 */

public class SeriableSingleton implements Serializable {


    //序列化
    //把内存中对象的状态转换为字节码的形式
    //把字节码通过IO输出流，写到磁盘上
    //永久保存下来，持久化

    //反序列化
    //将持久化的字节码内容，通过IO输入流读到内存中来
    //转化成一个Java对象


    public  final static SeriableSingleton INSTANCE = new SeriableSingleton();
    private SeriableSingleton(){}

    public static SeriableSingleton getInstance(){
        return INSTANCE;
    }

    /**
     * 1. 名字和参数不能错
     * 2. 想要测试为什么加了这个readResolve()方法就能够解决问题，直接在这个方法里面添加一个断点即可,发现通过发射调用readResolve()方法把对象返回过来了<br>
     */

    private Object readResolve(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        SeriableSingleton instance1 = getInstance();
        SeriableSingleton instance2 = getInstance();
        System.out.println("instance1==instance2: " + (instance1 == instance2));
    }

}
