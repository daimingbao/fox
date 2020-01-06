package com.fox.collection;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author dmb
 * @since 2019/11/6
 */
public class ConcurentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap<Integer, Integer>();
        map.put(1,1);
    }

}
