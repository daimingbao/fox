package cn.supfox.pattern.prototype.shallow;


import lombok.Data;

import java.util.List;

/**
 * Created by Tom.
 */
@Data
public class ConcretePrototype implements Cloneable {

    private int age;
    private String name;
    private List<String> hobbies;
    private User user;

    /**
     * 使用JDK自带克隆方法(Object.clone()方法)
     * @return
     */
    @Override
    public ConcretePrototype clone() {
        try {
            return (ConcretePrototype)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public String toString() {
        return "ConcretePrototype{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                ", user=" + user +
                '}';
    }
}
