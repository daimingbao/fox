package cn.supfox.pattern.single.lazy;

import java.lang.reflect.Constructor;

public class ReflectDestorySingletonTest {
    public static void main(String[] args) {
        try{
            Class<?> clazz = LazyStaticInnerClassSingletonHaveProblem.class;
            Constructor c = clazz.getDeclaredConstructor(null);

            c.setAccessible(true);
            System.out.println(">>>>>before newInstance>>>>>");

            Object instance1 = c.newInstance();

            System.out.println(">>>>>after newInstance>>>>>");
            System.out.println("instance1=" + instance1);

            Object instance2 = c.newInstance();

            System.out.println("instance2=" + instance2);

            System.out.println("instance1==instance2:" + (instance1 == instance2));

        }catch (Exception e)
        {
            System.out.println("error:" + e.getMessage());
            e.printStackTrace();
        }finally {
            System.out.println("finally.");
        }
    }
}
