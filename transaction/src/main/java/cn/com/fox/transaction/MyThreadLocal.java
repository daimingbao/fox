package cn.com.fox.transaction;

public class MyThreadLocal {

    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void set(String name) {
        threadLocal.set(name);
    }

    public static String get() {
        return threadLocal.get();
    }
}
