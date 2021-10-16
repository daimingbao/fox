package cn.supfox.algorithm;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRULinkedHashMap extends LinkedHashMap<Integer, Integer> {

    private int size;

    public LRULinkedHashMap(int initialCapacity, int size) {
        super(initialCapacity, 0.75f, true);
        this.size = size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > size;
    }

    public static void main(String[] args) {
        LRULinkedHashMap lruLinkedHashMap = new LRULinkedHashMap(2,2);
        lruLinkedHashMap.put(1,1);
        lruLinkedHashMap.put(2,2);
        lruLinkedHashMap.get(1);
        lruLinkedHashMap.put(3,3);

//        System.out.println(lruLinkedHashMap.size);



    }



}
