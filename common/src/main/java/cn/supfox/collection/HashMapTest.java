package cn.supfox.collection;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @author dmb
 * @since 2019/12/6
 */
public class HashMapTest {

    public static void main(String[] args) {

        boolean advance = true;
        boolean finishing = false; // to ensure sweep before committing nextTab


        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println((64 >>> 3) / 2 );


        //测试map的key为啥推荐使用不可变对象
//        Map<Key,String> map = new HashMap<>();
//        Map<Integer,Integer> maps = new HashMap<>();
//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        for (int i = 0; i < 500; i++) {
//            int finalI = i;
//            new Thread(() -> {
//                try {
//                    countDownLatch.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                maps.put(finalI, finalI);
//            }).start();
//        }
//
//        countDownLatch.countDown();
//        Key k = new Key();
//        k.setId("2");
//        map.put(k, "你好");
//
//        System.out.println(map.get(k));
//        k.setId("5");
//        System.out.println(map.get(k));
//        System.out.println(map.size());
//        map.put(k, "戴明宝");
//        System.out.println(map.get(k));
//        System.out.println(map.size());
//
//        //2^4=16  2^5=32   2^6= 1111 1111
//        int index = 100 & 15 ;
//        System.out.println(index);
//        index = 100 & 31;
//        System.out.println(index);
//        index = 100 & 63;
//        System.out.println(index);
//
//
//        HashMap hashMap = new HashMap();
//        for (int i=0; i< 1000; i++) {
//            hashMap.put("a"+i, i);
//        }



    }

    @Data
    public static class Key {
        private String id;
    }

}

