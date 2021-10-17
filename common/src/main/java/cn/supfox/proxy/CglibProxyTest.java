package cn.supfox.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;

import java.lang.reflect.Method;

public class CglibProxyTest {

    public static void main(String[] args) {


        ProxyDemo proxyDemo = new ProxyDemo();
        proxyDemo.setName("你好");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ProxyDemo.class);
        enhancer.setCallback(new ProxyInterceptor(proxyDemo));
        proxyDemo = (ProxyDemo) enhancer.create();
        System.out.println(proxyDemo.getName());
    }

    public static class ProxyDemo {

        public ProxyDemo() {
        }

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private static class ProxyInterceptor implements MethodInterceptor {

        private ProxyDemo proxyDemo;

        public ProxyInterceptor(ProxyDemo proxyDemo) {
            this.proxyDemo = proxyDemo;
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("拦截");
            System.out.println(o.getClass());
            Object o1 = methodProxy.invokeSuper(proxyDemo, objects);

            return o1;
        }
    }
}
