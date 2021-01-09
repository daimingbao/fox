package cn.supfox.pattern.single.register;

import java.lang.reflect.Constructor;

/**
 * Created by Tom.
 */
public enum EnumSingleton {
    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance(){return INSTANCE;}

    public static void main(String[] args) {
        EnumSingleton instance = EnumSingleton.getInstance();

        instance.setData(new Object());

        EnumSingleton instance2 = EnumSingleton.getInstance();

        try {
            Class clzz = EnumSingleton.class;
            Constructor<EnumSingleton> constructor = clzz.getDeclaredConstructor(String.class,int.class);
            constructor.setAccessible(true);
            EnumSingleton enumSingleton = constructor.newInstance();
            /**
             * 枚举怎么 解决单例反射破坏的呢？查看Enum.java 类中根据valuesof()方法跟进去，存放在enumConstantDirectory容器中<br>
             */
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("instance1==instance2: " + (instance == instance2));
    }
}
