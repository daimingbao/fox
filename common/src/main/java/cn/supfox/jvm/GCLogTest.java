package cn.supfox.jvm;

import sun.misc.ProxyGenerator;

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
public class GCLogTest {

    public static void main(String[] args) throws InterruptedException {
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Person o = (Person) Proxy.newProxyInstance(Student.class.getClassLoader(), new Class[]{Person.class}, new ProxyGenarator(new Student()));
        System.out.println(o.getClass().toGenericString());
        o.talk();


        FileOutputStream out = null;
        try {
            byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", Student.class.getInterfaces());
            out = new FileOutputStream("/Users/daimingbao/$Proxy0.class");
            out.write(classFile);
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

interface Person {
    String talk();

    void add();
}

class Student implements Person {

    @Override
    public void add() {
        System.out.println(this);
        System.out.println("方法add");
    }

    @Override
    public String talk() {
        System.out.println(this);
        add();
        return "hello";
    }
}

class ProxyGenarator implements InvocationHandler {

    private Object source;

    public ProxyGenarator(Object source) {
        this.source = source;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("你好" + method.getName());
        return method.invoke(source, args);
    }
}
