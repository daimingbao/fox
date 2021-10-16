package cn.supfox.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

final class $Proxy0 extends Proxy implements IHello {

    private static Method m1;

    private static Method m3;

    private static Method m2;

    private static Method m0;

    //代理类通过该构造函数实例化，参数为方法调用处理对象

    public $Proxy0(InvocationHandler var1) throws RuntimeException {

        super(var1);

    }

    public final boolean equals(Object var1) throws RuntimeException  {

        try {

            return (Boolean)super.h.invoke(this, m1, new Object[]{var1});

        } catch (RuntimeException | Error var3) {

            throw var3;

        } catch (Throwable var4) {

            throw new UndeclaredThrowableException(var4);

        }

    }

    //代理调用实现的逻辑，通过调用处理对象达到调用目标类的方法

    public final void sayHello() throws RuntimeException {

        try {

            super.h.invoke(this, m3, (Object[])null);

        } catch (RuntimeException | Error var2) {

            throw var2;

        } catch (Throwable var3) {

            throw new UndeclaredThrowableException(var3);

        }

    }

    public final String toString() throws RuntimeException {

        try {

            return (String)super.h.invoke(this, m2, (Object[])null);

        } catch (RuntimeException | Error var2) {

            throw var2;

        } catch (Throwable var3) {

            throw new UndeclaredThrowableException(var3);

        }

    }

    public final int hashCode() throws  RuntimeException{

        try {

            return (Integer)super.h.invoke(this, m0, (Object[])null);

        } catch (RuntimeException | Error var2) {

            throw var2;

        } catch (Throwable var3) {

            throw new UndeclaredThrowableException(var3);

        }

    }

    static {

        try {

            //加载所有的父类方法实例

            m1 = Class.forName("java.lang.Object").getMethod("equals");

            m3 = Class.forName("com.lm.blog.DynamicProxyTest$IHello").getMethod("sayHello");

            m2 = null;

            m0 = null;

        } catch (NoSuchMethodException var2) {

            throw new NoSuchMethodError(var2.getMessage());

        } catch (ClassNotFoundException var3) {

            throw new NoClassDefFoundError(var3.getMessage());

        }

    }

}
