package cn.supfox.demo;




import cn.supfox.algorithm.LRUTest;

import java.util.HashMap;

import java.util.Map;

public class LruTest {

    /**
     * LRU缓存
     * NewCache(capacity)
     * Get(key) value
     * Put(key, value)
     */

    private Map<Integer, LruCacheNode> cache;

    private LruCacheNode head;

    private LruCacheNode tail;

    private int capacity;

    public static class LruCacheNode {

        private LruCacheNode prev;
        private LruCacheNode next;
        private String val;
        private Integer key;

        public LruCacheNode() {
        }

        public LruCacheNode(Integer key , String val) {
            this.key = key;
            this.val = val;
        }
    }

    public LruTest(int capacity) {
        this.capacity = capacity;
        cache = new HashMap();
        head = null;
        tail = null;
    }

    public String get(Integer key) {
        LruCacheNode lruCacheNode = cache.get(key);
        if (lruCacheNode != null) {
            //节点转移
            moveToTail(lruCacheNode);
            return lruCacheNode.val;
        }
        return null;
    }

    public void put(Integer key, String value) {
        //如果存在
        if (cache.containsKey(key)) {
            LruCacheNode lruCacheNode = cache.get(key);
            lruCacheNode.val = value;
            //数据转移
            moveToTail(lruCacheNode);
        } else {
            //不存在
            LruCacheNode lruCacheNode = new LruCacheNode(key, value);
            addToTail(lruCacheNode);
            cache.put(key, lruCacheNode);
            //容量大小判断
            if (cache.size() > capacity) {
                //移除头节点
                Integer delKey = removeHead();
                cache.remove(delKey);
            }
        }
    }

    private void addToTail(LruCacheNode lruCacheNode) {
        //第1个节点
        if (head == tail && head == null) {
            head = new LruCacheNode();
            tail = new LruCacheNode();
            head.next = lruCacheNode;
            tail.prev = lruCacheNode;
            lruCacheNode.prev = head;
            lruCacheNode.next = tail;
        } else {
            LruCacheNode prev = tail.prev;
            prev.next = lruCacheNode;
            lruCacheNode.prev = prev;
            lruCacheNode.next = tail;
            tail.prev = lruCacheNode;
        }
    }

    public Integer removeHead() {
        LruCacheNode next = head.next;
        LruCacheNode next1 = next.next;
        head.next = next1;
        next1.prev = head;
        return next.key;
    }


    public void moveToTail(LruCacheNode lruCacheNode) {
        if (head == tail ){
            return;
        }
        //断开节点
        LruCacheNode prev = lruCacheNode.prev;
        LruCacheNode next = lruCacheNode.next;
        prev.next = next;
        next.prev = prev;

        //移动节点
        LruCacheNode prev1 = tail.prev;
        prev1.next = lruCacheNode;
        tail.prev = lruCacheNode;
        lruCacheNode.next = tail;
        lruCacheNode.prev = prev1;
    }

    public static void main(String[] args) {
        /**
         * Put 1,a
         * Put 2,b
         * Put 3,c
         * Put 4,d
         * Get 1 = null
         * Get 2 = b
         * Put 5,e
         * Get 3 = null
         */
        LruTest lruTest = new LruTest(3);

        lruTest.put(1, "a");
        lruTest.put(2, "b");
        lruTest.put(3, "c");
        lruTest.put(4, "d");
        String s = lruTest.get(1);
        System.out.println(s);
        String s1 = lruTest.get(2);
        System.out.println(s1);
        lruTest.put(5, "e");

        String s2 = lruTest.get(3);
        System.out.println(s2);
        lruTest.put(6, "g");
        lruTest.put(7, "h");
        lruTest.put(8, "h");
        String s3 = lruTest.get(5);
        System.out.println(s3);

    }



}
