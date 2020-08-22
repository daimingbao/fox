package cn.supfox;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;

import java.lang.reflect.Method;

public class ProxyTest {

    public static void main(String[] args) {

        Boolean o1 = true;
        Boolean o2 = true;
        boolean a =   o1 | o2;
        boolean b =   o1 & o2;
        System.out.println(a);
        System.out.println(b);

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ProxyDemo.class);
        enhancer.setCallback(new ProxyInterceptor());
        Object o = enhancer.create();
        System.out.println(o);
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

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("拦截");
//            if (method.getName().equals("getName")) {
//                Object invoke = method.invoke(o, objects);
//            }
            Object o1 = methodProxy.invokeSuper(o, objects);

            return o1;
        }
    }
}
