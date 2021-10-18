package cn.supfox.proxy;

import cn.supfox.proxy.service.TicketService;
import cn.supfox.proxy.service.impl.TicketServiceImpl;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;

import java.lang.reflect.Method;

public class CglibProxyTest {

    public static void main(String[] args) {

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"/Users/paul/$CglibProxy.class");
        TicketService ticketService = new TicketServiceImpl();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TicketServiceImpl.class);
        enhancer.setCallback(new ProxyInterceptor(ticketService));
        ticketService = (TicketService) enhancer.create();
        ticketService.sendTicket("1", "2");
    }


    private static class ProxyInterceptor implements MethodInterceptor {

        private TicketService ticketService;

        public ProxyInterceptor(TicketService ticketService) {
            this.ticketService = ticketService;
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("执行方法"+ method.getName() +"前");
            System.out.println(o.getClass());
            Object o1 = methodProxy.invoke(ticketService, objects);
            System.out.println("执行方法"+ method.getName() +"后");

            return o1;
        }
    }
}
