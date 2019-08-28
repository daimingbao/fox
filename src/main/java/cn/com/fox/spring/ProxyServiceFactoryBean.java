package cn.com.fox.spring;

import com.oracle.tools.packager.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author dmb
 * @since 2019-08-11
 */
@Slf4j
@Service
public class ProxyServiceFactoryBean extends AbstractFactoryBean {
    @Override
    public Class<?> getObjectType() {
        return ProxyService.class;
    }

    @Override
    protected Object createInstance() throws Exception {
        return Proxy.newProxyInstance(ProxyService.class.getClassLoader(),new Class[]{ ProxyService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                Log.info(""+ proxy);
//                Log.info( ""+method);
//                Log.info(""+ args);
                log.info(method.getName());
                log.info("proxy hello");
                return "你好";
            }
        });
    }
}
