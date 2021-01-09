package cn.supfox.pattern.single.seriable;

import java.io.Serializable;

/**
 * Created by Tom.
 */

public class SeriableSingletonDestory implements Serializable {


    //序列化
    //把内存中对象的状态转换为字节码的形式
    //把字节码通过IO输出流，写到磁盘上
    //永久保存下来，持久化

    //反序列化
    //将持久化的字节码内容，通过IO输入流读到内存中来
    //转化成一个Java对象


    public  final static SeriableSingletonDestory INSTANCE = new SeriableSingletonDestory();
    private SeriableSingletonDestory(){}

    public static SeriableSingletonDestory getInstance(){
        return INSTANCE;
    }

    //名字和参数不能错
//    private Object readResolve(){ return INSTANCE;}

    public static void main(String[] args) {
        SeriableSingletonDestory instance1 = getInstance();
        SeriableSingletonDestory instance2 = getInstance();
        System.out.println("instance1==instance2: " + (instance1 == instance2));
    }

}
