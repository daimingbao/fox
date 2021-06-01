package cn.supfox.collection;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author dmb
 * @since 2019/11/6
 */
public class ConcurentHashMapTest {

    private static class A{

        private String name;

//        public A(String name) {
//            this.name = name;
//        }
    }

    public static void main(String[] args) {
        A a =  new A();
        ConcurrentHashMap map = new ConcurrentHashMap<Integer, Integer>();
        map.put(1,1);
    }

}
