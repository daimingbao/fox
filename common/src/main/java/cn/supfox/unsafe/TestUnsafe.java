package cn.supfox.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class TestUnsafe {

    public static void main(String[] args) {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Unsafe o = (Unsafe) field.get(null);
            System.out.println(o);
        } catch (Exception e) {
        }
    }
}
