package cn.supfox.algorithm;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

public class LRUTest {

    //运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
//
//
//
// 实现 LRUCache 类：
//
//
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
//
//
//
//
//
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
//
//
//
// 示例：
//
//
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
//
//
//
//
// 提示：
//
//
// 1 <= capacity <= 3000
// 0 <= key <= 3000
// 0 <= value <= 104
// 最多调用 3 * 104 次 get 和 put
//
// Related Topics 设计
// 👍 1448 👎 0


    public static void main(String[] args) {
        LRUTest lruTest = new LRUTest(3);

        //["LRUCache","put","put","get","put","get","put","get","get","get"]
        //[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]

        //["LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]
        //[[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]


        //[null,null,null,1,null,-1,null,-1,3,4]
        lruTest.put(1, 1);
        lruTest.put(2, 2);
        lruTest.put(3, 3);
        lruTest.put(4, 4);

        System.out.println(lruTest.get(4));
        System.out.println(lruTest.get(3));
        System.out.println(lruTest.get(2));
        System.out.println(lruTest.get(1));
        lruTest.put(5, 5);

        System.out.println(lruTest.get(1));
        System.out.println(lruTest.get(2));
        System.out.println(lruTest.get(3));
        System.out.println(lruTest.get(4));
        System.out.println(lruTest.get(5));




    }

    private Map<Integer, Node> map = new HashedMap();

    private int capacity;

    private Node head = new Node();
    private Node tail = new Node();

    private class Node {
        private int key;
        private int value;
        private Node next;
        private Node pre;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUTest(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            return getNode(key).value;
        }
        return -1;
    }

    private Node getNode(int key) {
        Node node = map.get(key);
        if (node == null) {
            return null;
        }
        //只要是尾节点，就不要移动到尾部了
        if (node == tail.pre) {
            return node;
        }
        //断开node前后连接
        breakNode(node);
        //移动到尾部
        insertToTail(key, node);
        return node;
    }

    //改变一下思想，插入的节点放尾部，经常访问的节点也放尾部，头节点存经常不访问的节点
    public void put(int key, int value) {

        //判断是否存在,存在则更新,访问一下(移动到尾部)，再更新值
        if (map.containsKey(key)) {
            Node node1 = getNode(key);
            node1.value = value;
            return;
        } else {
            //第1次插入

            int size = map.size();

            //大于容量了，不能加新节点了，去除头,再新增一个节点
            if (size >= capacity) {
                Node next = head.next;
                breakNode(next);
            }
            // n -> n1
            //将tmp加入尾部
            Node tmp = new Node(key, value);
            insertToTail(key, tmp);
        }

    }

    //断开一个节点
    private void breakNode(Node node) {
        Node next = node.next;
        Node pre = node.pre;
        //断开连接
        if (pre != null) {
            pre.next = next;
        }
        if (next != null) {
            next.pre = pre;
        }
        map.remove(node.key);
        node.next = null;
        node.pre = null;
    }


    //加入尾部
    private void insertToTail(int key, Node tmp) {
        Node pre = tail.pre;
        if (pre != null) {
            pre.next = tmp;
        }
        tmp.pre = pre;

        tail.pre = tmp;
        tmp.next = tail;

        map.put(key, tmp);
    }

}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)


