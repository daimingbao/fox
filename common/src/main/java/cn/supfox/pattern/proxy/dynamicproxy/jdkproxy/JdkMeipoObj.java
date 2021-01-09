package cn.supfox.pattern.proxy.dynamicproxy.jdkproxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Tom.
 */
public class JdkMeipoObj implements InvocationHandler {
    private Object target;
    public Object getInstance(Object target){
        this.target = target;
        Class<?> clazz =  target.getClass();
        return (IPerson) Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    /**
     * 动态代理增加的入口，before()和after，代理为了什么就是为了增强<br>
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.target,args);
        after();
        return result;
    }

    private void after() {
        System.out.println("双方同意，开始交往");
    }

    private void before() {
        System.out.println("我是媒婆，已经收集到你的需求，开始物色");
    }
}
