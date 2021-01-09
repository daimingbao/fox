package cn.supfox.pattern.prototype.shallow;

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
        User user = new User();
        user.setGrade(2);
        prototype.setUser(user);


        //拷贝原型对象
        ConcretePrototype cloneType = prototype.clone();
        cloneType.getHobbies().add("技术控");
        cloneType.setAge(15);
        cloneType.getUser().setGrade(5);


        System.out.println("原型对象：" + prototype);
        System.out.println("克隆对象：" + cloneType);
        System.out.println(prototype == cloneType);


        System.out.println("原型对象的爱好：" + prototype.getHobbies());
        System.out.println("克隆对象的爱好：" + cloneType.getHobbies());
        System.out.println(prototype.getHobbies() == cloneType.getHobbies());

        /**
         * 克隆对象与原对象是两个不同的对象（地址不一样）但是属性一样<br>
         * 原型对象：ConcretePrototype{age=18, name='Tom', hobbies=[书法, 美术, 技术控], user=User{grade=5, val='null'}}
         * 克隆对象：ConcretePrototype{age=15, name='Tom', hobbies=[书法, 美术, 技术控], user=User{grade=5, val='null'}}
         * false
         * 原型对象的爱好：[书法, 美术, 技术控]
         * 克隆对象的爱好：[书法, 美术, 技术控]  //从这看出，克隆对象Hobbies跟原型对象Hobbies地址一样，说明Hobbies这个属性没有克隆成功（因为是浅克隆）<br>
         * true
         */

    }

    @Test
    public void test2() {
        //创建原型对象
        ConcretePrototypeNotImpCloneable prototype = new ConcretePrototypeNotImpCloneable();
        prototype.setAge(18);
        prototype.setName("Tom");
        List<String> hobbies = new ArrayList<String>();
        hobbies.add("书法");
        hobbies.add("美术");
        prototype.setHobbies(hobbies);
        User user = new User();
        user.setGrade(2);
        prototype.setUser(user);


        //拷贝原型对象
        ConcretePrototypeNotImpCloneable cloneType = prototype.clone();
        cloneType.getHobbies().add("技术控");
        cloneType.setAge(15);
        cloneType.getUser().setGrade(5);


        System.out.println("原型对象：" + prototype);
        System.out.println("克隆对象：" + cloneType);
        System.out.println(prototype == cloneType);


        System.out.println("原型对象的爱好：" + prototype.getHobbies());
        System.out.println("克隆对象的爱好：" + cloneType.getHobbies());
        System.out.println(prototype.getHobbies() == cloneType.getHobbies());


    }

}
