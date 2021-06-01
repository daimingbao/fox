package cn.supfox.spring;

import org.aopalliance.intercept.Interceptor;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;
import org.springframework.aop.target.SingletonTargetSource;

import java.lang.reflect.Method;

public class FoxProxyFactory {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setInterfaces(ProxyInterface.class);
        proxyFactory.setTargetSource(new SingletonTargetSource( new FoxProxyFactoryImpl()));

        proxyFactory.addAdvice(new MethodBeforeAdviceInterceptor(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] objects, Object o) throws Throwable {
                System.out.println("你好哈");
            }
        }));
        ProxyInterface proxy = (ProxyInterface) proxyFactory.getProxy();


        System.out.println(proxy.hello());
        System.out.println(proxy);

    }
}
