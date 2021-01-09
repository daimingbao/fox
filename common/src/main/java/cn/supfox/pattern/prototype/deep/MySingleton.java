package cn.supfox.pattern.prototype.deep;

import java.io.Serializable;

public class MySingleton implements Serializable {
    private static  MySingleton mySingleton = new MySingleton();
    private MySingleton(){
//        if(mySingleton!=null){
//            throw new RuntimeException("单例对象不能重复创建");
//        }
    }
    public static MySingleton getInstance(){
        return mySingleton;
    }

    private Object readResolve(){
        return mySingleton;
    }
}
