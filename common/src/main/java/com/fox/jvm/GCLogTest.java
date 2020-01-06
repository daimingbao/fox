package com.fox.jvm;

import com.fox.spring.ProxyService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author dmb
 * @since 2020/1/5
 */
public class GCLogTest {

    public static void main(String[] args) throws InterruptedException {

//        System.setProperty("")
        List<String> list = new ArrayList<>();
        byte[] b;
        StringBuilder sb = new StringBuilder();
         while (true) {
//            String s = i + "bbbbb";
//             sb = new StringBuilder();
//            list.add(s);
//            b = new byte[1024];
//            sb.append(b);
//            TimeUnit.SECONDS.sleep(2);
             Person o = (Person) Proxy.newProxyInstance(Student.class.getClassLoader(), new Class[] { Person.class }, new ProxyGenarator(new Student()));
             System.out.println(o);
         }

    }



}

interface Person{
    String talk();
}

class Student  implements Person{

    private int i=0;
    private int b=0;
    private String name = "test";

    @Override
    public String talk() {
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

        return  method.invoke(source, args);
    }
}
