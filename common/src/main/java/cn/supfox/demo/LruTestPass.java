package cn.supfox.demo;


import java.util.*;

public class LruTestPass {

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
        private Integer val;
        private Integer key;

        public LruCacheNode() {
        }

        public LruCacheNode(Integer key , Integer val) {
            this.key = key;
            this.val = val;
        }
    }

    public LruTestPass(int capacity) {
        this.capacity = capacity;
        cache = new HashMap();
        head = null;
        tail = null;
    }

    public LruTestPass() {
    }

    public Integer get(Integer key) {
        LruCacheNode lruCacheNode = cache.get(key);
        if (lruCacheNode != null) {
            //节点转移
            moveToTail(lruCacheNode);
            return lruCacheNode.val;
        }
        return null;
    }

    public void put(Integer key, Integer value) {
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

        int[][] operators = new int[3][3];
        operators[0][0] = 1;
        operators[0][1] = 1;
        operators[0][2] = 1;

        operators[2][0] = 3;
        operators[2][1] = 3;
        operators[2][2] = 3;

        operators[1][0] = 2;
        operators[1][1] = 1;
        LRU(operators, 2);


    }


    public static int[] LRU (int[][] operators, int k) {
        LruTestPass lruCache = new LruTestPass(k);
        // write code here
        List<Integer> list = new ArrayList<>();
        for(int i =0 ; i< operators.length; i++) {
            int[] a = operators[i];
            if(a[0] == 1) {
                lruCache.put(operators[i][1], operators[i][2]);
            } else {
                Integer r = lruCache.get(a[1]);
                if (r != null) {
                    list.add(r);
                } else {
                    list.add(-1);
                }
            }
        }
        int[] result = list.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }
}
