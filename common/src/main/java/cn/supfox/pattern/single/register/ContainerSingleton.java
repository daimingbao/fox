package cn.supfox.pattern.single.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Tom.
 */
public class ContainerSingleton {

    private ContainerSingleton(){}

    private static Map<String,Object> ioc = new ConcurrentHashMap<String, Object>();

    public static Object getInstance(String className){
        Object instance = null;
        if(!ioc.containsKey(className)){
            try {
                instance = Class.forName(className).newInstance();
                ioc.put(className, instance);
                //com.guapo.user,userBean
                //userBean,userBean
            }catch (Exception e){
                e.printStackTrace();
            }
            return instance;
        }else{
            return ioc.get(className);
        }
    }

    /**
     * 解决线程安全问题<br>
     * @param className
     * @return
     */
    public static Object getInstance2(String className){
        Object instance = null;
        synchronized (ioc) {
            if (!ioc.containsKey(className)) {
                try {
                    instance = Class.forName(className).newInstance();
                    ioc.put(className, instance);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return instance;
            } else {
                return ioc.get(className);
            }
        }
    }
    /**
     * 解决大批量创建，将实例都缓存到统一的容器中<br>
     */

}