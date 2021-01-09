package cn.supfox.pattern.proxy.dynamicproxy.jdkproxy;

import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Tom.
 */
public class JdkDynamicProxyTest {
    public static void main(String[] args) {
        JdkMeipo jdkMeipo = new JdkMeipo();
        //动态代理类是动态生成的，根据客户需求来生成的，动态生成新的类（相当于根据需求来生成）
        IPerson zhangsan = jdkMeipo.getInstance(new Zhangsan());
        zhangsan.findLove();

        IPerson zhaoliu = jdkMeipo.getInstance(new ZhaoLiu());
        zhaoliu.findLove();

        System.out.println(">>>>>>>>using obj>>>>>>>>>>>>>>>>>");
        JdkMeipo jdkMeipo1 = new JdkMeipo();
        Object zhangsan1 = jdkMeipo1.getInstance(new Zhangsan());
        ((IPerson)zhangsan1).findLove();
    }

    @Test
    public void showProblem1()
    {
        JdkMeipo jdkMeipo = new JdkMeipo();
        //动态代理类是动态生成的，根据客户需求来生成的，动态生成新的类（相当于根据需求来生成）
        IPerson zhangsan = jdkMeipo.getInstance(new Zhangsan());

        IPerson zhaoliu = jdkMeipo.getInstance(new ZhaoLiu());
        System.out.println("zhangsan.findLove-begin");
        zhangsan.findLove();
        System.out.println("zhangsan.findLove-end");
        zhaoliu.findLove();

        System.out.println(">>>>>>>>using obj>>>>>>>>>>>>>>>>>");
        JdkMeipo jdkMeipo1 = new JdkMeipo();
        Object zhangsan1 = jdkMeipo1.getInstance(new Zhangsan());
        ((IPerson)zhangsan1).findLove();

        /**
         * zhangsan.findLove-begin
         * 我是媒婆，已经收集到你的需求，开始物色
         * 赵六要求：有车有房学历高  FIXME 为什么这里是赵六，是因为这里JdkMeipo里的Target被替换掉了<br>
         * 双方同意，开始交往
         * zhangsan.findLove-end
         * 我是媒婆，已经收集到你的需求，开始物色
         * 赵六要求：有车有房学历高
         * 双方同意，开始交往
         * >>>>>>>>using obj>>>>>>>>>>>>>>>>>
         * 我是媒婆，已经收集到你的需求，开始物色
         * 张三要求：肤白貌美大长腿
         * 双方同意，开始交往
         */
    }

    @Test
    public void testPrintJdkProxyDynamicClass()
    {
        //$Proxy0
        byte [] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{IPerson.class});

        try {
            FileOutputStream os = new FileOutputStream("D://$Proxy0-IPerson897.class");
            os.write(bytes);
//            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
