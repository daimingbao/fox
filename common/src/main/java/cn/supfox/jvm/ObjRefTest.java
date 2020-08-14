package cn.supfox.jvm;


import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ObjRefTest {

    private static Object strongRef = new Object();

   private  static    ThreadLocal<Object> threadLocal = new ThreadLocal<>();


    public static void main(String[] args) throws InterruptedException {
        //强引用有引用到就不会回收
        Object o = strongRef;
//        System.out.println(o);
        strongRef = null;
//        System.out.println(strongRef);
//        System.out.println(o);

        //内存不足的情况下，软引用会回收，避免oom异常
        Object o1 = new Object();
        SoftReference softReference = new SoftReference(o1);
        o1 = null;
        System.gc();
//        System.out.println(softReference.get());

        //弱引用普通对象，下次gc回收就会回收
        Object o4 = new Object();
        //弱引用字符串对象，下次gc也不会回收，string字符串不属于堆区，而是常量池
//        Object o3 = new Object();
        WeakReference weakReference = new WeakReference(o4);
        o4 = null;
        System.gc();
        System.out.println(weakReference.get());

        //弱引用实例  TODO 理解不了？
        threadLocal.set(new Object());

        System.gc();

        Thread.sleep(5000);
        System.out.println(threadLocal.get());


        //虚引用
        ReferenceQueue referenceQueue = new ReferenceQueue();
        PhantomReference phantomReference = new PhantomReference(new String(),  referenceQueue);

        System.out.println(phantomReference.get());
    }
}
