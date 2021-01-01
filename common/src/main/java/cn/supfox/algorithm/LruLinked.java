package cn.supfox.algorithm;

import java.util.HashMap;
import java.util.Map;

public class LruLinked {

    private Node head;
    private Node tail;
    private int capacity;

    public static void main(String[] args) {

//        Node node1 = new Node(1, 1);
//        Node node2 = new Node(2, 2);
//        Node node3 = new Node(3, 3);
//        Node node4 = new Node(4, 4);
//
//        node1.next = node2;
////        node2.pre = node1;
//        node2.next = node3;
//        node3.next = node4;
//
//        Node t = node3.next;
//        node2.next = t;
//        node3.next = node1;
//        node1.pre = node3;
//        node1 = node3;
//        node1.pre = null;
//        System.out.println(node1);

        // [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]



        LruLinked lRUCache = new LruLinked(2);
//        lRUCache.get(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);
        lRUCache.put(3, 3); // 缓存是 {1=1, 2=2}
        lRUCache.get(2);
        lRUCache.put(4, 4); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(1);
        lRUCache.get(3);
        lRUCache.get(4);
    }

    private Map<Integer, Node> map = new HashMap<>();

    private static class Node {
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

        public Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public LruLinked(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            if (map.size() == 1 || node == head) {
                System.out.println(node.value);
                return node.value;
            }
            //移动到头部
            Node next =  node.next;
            Node pre = node.pre;
            Node tmp = node;
            pre.next = next;
            if (next != null) {
                next.pre = pre;
            }
            node.next = head;
            head.pre = node;
            head = node;
            head.pre = null;
            if (node == tail) {
                tail = pre;
            }
            System.out.println(node.value);
            return node.value;
        }
        System.out.println(-1);
        return -1;
    }

    public void put(int key, int value) {

        if (head == null) {
            head = new Node(key,value);
            tail = head;
            map.put(key, head);
        } else {
            //判断是否存在,存在则更新
            if (map.containsKey(key)) {
                Node node = map.get(key);
                //头节点，直接返回
                if (head == node) {
                    node.value = value;
                    return;
                }
                node.value = value;
                Node pre = node.pre;
                //尾节点，需要更新尾节点，为尾节点为上一个节点
                if (node == tail) {
                    tail = pre;
                }
                //移动到头部
                Node next =  node.next;
                pre.next = next;
                if (next != null) {
                    next.pre = pre;
                }
                //将node指向原来的头节点
                node.next = head;
                head.pre = node;
                //修改头节点
                head = node;
                head.pre = null;
                map.put(key, head);
            } else {
                int size = map.size();
                if (size == capacity && size == 1) {
                    Node tmp = new Node(key, value);
                    map.clear();
                    head = tmp;
                    tail = tmp;
                    map.put(key, tmp);
                    return;
                }
                //去除尾部
                if (size >= capacity) {
                    Node node = tail.pre;
                    if (node != null) {
                        node.next = null;
                        map.remove(tail.key);
                        tail = node;
                    }
                }
                // n -> n1
                //加入头部
                Node tmp = new Node(key, value);
                Node n = tail;
                Node t = head;
                tmp.next = head;
                head.pre = tmp;
                head = tmp;
                map.put(key, tmp);
            }
        }
    }
}
