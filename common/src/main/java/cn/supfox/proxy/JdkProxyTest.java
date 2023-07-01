package cn.supfox.proxy;

import cn.supfox.proxy.service.LoginService;
import cn.supfox.proxy.service.impl.LoginServiceImpl;
//import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dmb
 * @since 2020/1/5
 */
public class JdkProxyTest {

    public static void main(String[] args) throws InterruptedException {

        //开启持久化生成代理类
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        LoginService loginService = (LoginService) Proxy.newProxyInstance(LoginService.class.getClassLoader(), new Class[]{LoginService.class}, new ProxyGenarator(new LoginServiceImpl()));
        System.out.println(loginService.getClass().toGenericString());
        loginService.login("周杰伦");

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        loginService = (LoginService) Proxy.newProxyInstance(LoginService.class.getClassLoader(), new Class[]{LoginService.class}, new ProxyGenarator(loginService));
        loginService.login("周杰伦被二次代理了吗");


    }

    private static void generateClassFile() {
        FileOutputStream out = null;
        try {
//            byte[] classFile = ProxyGenerator.generateProxyClass("com.supfox.proxytest", LoginServiceImpl.class.getInterfaces(), 17);
//            out = new FileOutputStream("/Users/paul/$Proxy2.class");
//            out.write(classFile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void saveProxyClass() {
        FileOutputStream out = null;
        try {
//            byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", LoginService.class.getInterfaces());
//            out = new FileOutputStream("/Users/paul/$Proxy0.class");
//            out.write(classFile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ProxyGenarator implements InvocationHandler {

    private Object source;

    public ProxyGenarator(Object source) {
        this.source = source;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理类："+ proxy.getClass() + "被代理类：" + source.getClass());
        System.out.println("开始执行方法=====" + method.getName());
        Object result = method.invoke(source, args);
        System.out.println("结束执行方法=====" + method.getName());
        return result;
    }
}
