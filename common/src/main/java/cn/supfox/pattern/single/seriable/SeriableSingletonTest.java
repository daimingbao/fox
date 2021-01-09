package cn.supfox.pattern.single.seriable;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by zigong.
 * 这个类干嘛的，主要测试什么？
 */
public class SeriableSingletonTest {
    /**
     * 备注：这个函数测试什么功能：序列化破坏了单例 <br>
     * to see how destory by serilizable <br>
     */
    @Test
    public void test1()
    {
        SeriableSingletonDestory s1 = null;
        SeriableSingletonDestory s2 = SeriableSingletonDestory.getInstance();

        FileOutputStream fos = null;
            try {
                fos = new FileOutputStream("SeriableSingleton.obj");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(s2);

                FileInputStream fis = new FileInputStream("SeriableSingleton.obj");
                ObjectInputStream ois = new ObjectInputStream(fis);
                s1 = (SeriableSingletonDestory)ois.readObject();
                System.out.println("s1==s2: "+ (s1 == s2));
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @Test
    public void test2()
    {
        SeriableSingleton s1 = null;
        SeriableSingleton s2 = SeriableSingleton.getInstance();

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("SeriableSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);

            FileInputStream fis = new FileInputStream("SeriableSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (SeriableSingleton)ois.readObject();
            System.out.println("s1==s2: "+ (s1 == s2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 单例的例子：
     * 1. AbstractFactoryBean.java<br>
     * 2. mybatis Errorcontext.java ThreadLocal单例的例子<br>
     */
}
