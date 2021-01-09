package cn.supfox.pattern.prototype.deep;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom.
 */
public class Client {


    public static void main(String[] args) {
        //创建原型对象
        ConcretePrototype prototype = new ConcretePrototype();
        prototype.setAge(18);
        prototype.setName("Tom");
        List<String> hobbies = new ArrayList<String>();
        hobbies.add("书法");
        hobbies.add("美术");
        prototype.setHobbies(hobbies);

        //拷贝原型对象
        ConcretePrototype cloneType = prototype.deepCloneHobbies();
        cloneType.getHobbies().add("技术控");
        cloneType.setAge(15);

        System.out.println("原型对象：" + prototype);
        System.out.println("克隆对象：" + cloneType);
        System.out.println(prototype == cloneType);


        System.out.println("原型对象的爱好：" + prototype.getHobbies());
        System.out.println("克隆对象的爱好：" + cloneType.getHobbies());
        System.out.println(prototype.getHobbies() == cloneType.getHobbies());

    }

    /**
     * 使用序列化实现深克隆
     * 如果要防止序列化破坏单例，那么单例类需要提供readResolve方法
     */
    @Test
    public void testDeepCloneWithSerialize()
    {
        //创建原型对象
        ConcretePrototype prototype = new ConcretePrototype();
        prototype.setAge(18);
        prototype.setName("Tom");
        List<String> hobbies = new ArrayList<String>();
        hobbies.add("书法");
        hobbies.add("美术");
        prototype.setHobbies(hobbies);
        prototype.setMySingleton(MySingleton.getInstance());

        //拷贝原型对象
        ConcretePrototype cloneType = prototype.deepClone();
        cloneType.getHobbies().add("技术控");
        cloneType.setAge(15);

        System.out.println("原型对象：" + prototype);
        System.out.println("克隆对象：" + cloneType);
        System.out.println(prototype == cloneType);


        System.out.println("原型对象的爱好：" + prototype.getHobbies());
        System.out.println("克隆对象的爱好：" + cloneType.getHobbies());
        System.out.println(prototype.getHobbies() == cloneType.getHobbies());
        System.out.println(cloneType.getMySingleton() == MySingleton.getInstance());
    }

    /**
     * 使用json实现深克隆
     */
    @Test
    public void testDeepCloneWithJson()
    {
        //创建原型对象
        ConcretePrototype2 prototype = new ConcretePrototype2();
        prototype.setAge(18);
        prototype.setName("Tom");
        List<String> hobbies = new ArrayList<String>();
        hobbies.add("书法");
        hobbies.add("美术");
        prototype.setHobbies(hobbies);
        prototype.setMySingleton(MySingleton.getInstance());

        //拷贝原型对象
        ConcretePrototype2 cloneType = prototype.deepCloneByJson();
        cloneType.getHobbies().add("技术控");
        cloneType.setAge(15);

        System.out.println("原型对象：" + prototype);
        System.out.println("克隆对象：" + cloneType);
        System.out.println(prototype == cloneType);


        System.out.println("原型对象的爱好：" + prototype.getHobbies());
        System.out.println("克隆对象的爱好：" + cloneType.getHobbies());
        System.out.println(prototype.getHobbies() == cloneType.getHobbies());
        System.out.println(cloneType.getMySingleton() == MySingleton.getInstance());  // false
        //cloneType.getMySingleton() == MySingleton.getInstance()为false表示json序列化破坏了单例
    }



}
