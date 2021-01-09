package cn.supfox.pattern.prototype.deep;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ConcretePrototype2 implements Cloneable, Serializable {
    private int grade;
    private Integer age;
    private String name;
    private List<String> hobbies;
    private MySingleton mySingleton;

    @Override
    public ConcretePrototype clone() {
        try {
            return (ConcretePrototype)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 使用json实现的深克隆
     * @return
     */
    public ConcretePrototype2 deepCloneByJson(){
        byte[] bytes = JSON.toJSONBytes(this);
        ConcretePrototype2 cloneObj = JSON.parseObject(bytes, ConcretePrototype2.class);
        return cloneObj;
    }

    @Override
    public String toString() {
        return "ConcretePrototype{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }
}
