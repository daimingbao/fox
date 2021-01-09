package cn.supfox.pattern.proxy.dynamicproxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 1. 与JDK动态代理就是生成的代理类方式不一样<br>
 * 2. 调用代理类的入口不一样，jdk动态代理
 * Created by Tom on 2019/3/11.
 */
public class CGlibMeipo implements MethodInterceptor {

    /**
     *
     * @param clazz
     * @return
     * @throws Exception
     */
    public Object getInstance(Class<?> clazz) throws Exception{
        //相当于Proxy，代理的工具类
        //1.把它当做工具用就行了获得直观感受暂时不用纠结它背后原理 --> 如果你要造轮子和手写那么就去研究<br>
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object obj = methodProxy.invokeSuper(o,objects);
        after();
        return obj;
    }

    private void before(){
        System.out.println("我是媒婆，我要给你找对象，现在已经确认你的需求");
        System.out.println("开始物色");
    }

    private void after(){
        System.out.println("OK的话，准备办事");
    }
}
