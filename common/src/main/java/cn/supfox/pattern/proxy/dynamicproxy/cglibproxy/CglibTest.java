package cn.supfox.pattern.proxy.dynamicproxy.cglibproxy;

import net.sf.cglib.core.DebuggingClassWriter;

/**
 * Created by Tom on 2019/3/11.
 */
public class CglibTest {
    public static void main(String[] args) {

        try {


            //JDK是采用读取接口的信息
            //CGLib覆盖父类方法
            //目的：都是生成一个新的类，去实现增强代码逻辑的功能

            //JDK Proxy 对于用户而言，必须要有一个接口实现，目标类相对来说复杂
            //CGLib 可以代理任意一个普通的类，没有任何要求

            //CGLib 生成代理逻辑更复杂，效率,调用效率更高，生成一个包含了所有的逻辑的FastClass，不再需要*反射*调用
            //JDK Proxy生成代理的逻辑简单，执行效率相对要低，每次都要反射动态调用，FAST CLASS 新的API性能会更高<br>

            //CGLib 有个坑，CGLib不能代理final的方法

            System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"D://cglib_proxy_classes");

            Customer obj = (Customer) new CGlibMeipo().getInstance(Customer.class);
            //生成子类，我们平常写子类是不是有{ xxx; super.method();  xxx } 这里前后就可以做一些事情了，这个不就是增强嘛？
            System.out.println(obj);
            obj.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
