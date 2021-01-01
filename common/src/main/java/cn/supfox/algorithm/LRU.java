package cn.supfox.algorithm;

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
// 👍 1070 👎 0

/**
 * Lru (least recently used) cache decorator.
 * Author:
 * Clinton Begin
 */

//leetcode submit region begin(Prohibit modification and deletion)
class LRU {

    public static void main(String[] args) {
        LRU lRUCache = new LRU(3);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(4);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(2);    // 返回 3




       // [[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
        // [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]

    }

    private int capacity;

    private Node[] nodes ;

    private int size;

    private class Node {
        private int data;
        private int key;
        private Long lastAccessTime;

        public Node(int data, int key, Long lastAccessTime) {
            this.data = data;
            this.key = key;
            this.lastAccessTime = lastAccessTime;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public Long getLastAccessTime() {
            return lastAccessTime;
        }

        public void setLastAccessTime(Long lastAccessTime) {
            this.lastAccessTime = lastAccessTime;
        }
    }

    public LRU(int capacity) {
        this.capacity = capacity;
        nodes  = new Node[capacity];
    }

    public int get(int key) {
        Node node = null;
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (nodes[i] != null && nodes[i].getKey() == key) {
                if (i == 0) {
                    System.out.println(i);
                    return nodes[i].getData();
                }
                node = nodes[i];
                index = i;
                break;
            }
        }
        //将节点放入头部
        if (node != null) {
            Node[] newNodes = new Node[capacity];
            newNodes[0] = node;

            System.arraycopy(nodes,0,newNodes,1,index);

            if ((size -index -1) > 0) {
                System.arraycopy(nodes,index+1,newNodes,index+1, size - index-1);
            }
            nodes = newNodes;
            for (Node newNode : newNodes) {
                System.out.println(newNode.getData());
            }
            return node.getData();
        }

        return -1;
    }

    private void moveToHead(Node node, int index) {
        Node[] newNodes = new Node[capacity];
        newNodes[0] = node;

        System.arraycopy(nodes,0,newNodes,1,index);

        if ((size -index -1) > 0) {
            System.arraycopy(nodes,index,newNodes,index+1, size - index-1);
        }
        nodes = newNodes;
    }

    public void put(int key, int value) {

        for (int i = 0; i < size; i++) {
            if (nodes[i] != null && nodes[i].getKey() == key) {
                nodes[i].setData(value);
                if (i == 0) {
                    return;
                }
                moveToHead(nodes[i], i );
                return;
            }
        }

        //容量大小已经大了，将尾部数据删除，
        // 并将新数据加入头部
        // 构建新的数组
        if (size == capacity) {
            Node[] newNodes = new Node[capacity];
            newNodes[0] = new Node(value, key, System.currentTimeMillis());
            if (capacity-1 != 0) {
                System.arraycopy(nodes,0,newNodes,1,capacity-1);
            }
            nodes = newNodes;
        } else {
            size ++;
            Node[] newNodes = new Node[capacity];
            newNodes[0] = new Node(value, key, System.currentTimeMillis());
            if (size - 1 != 0) {
                System.arraycopy(nodes,0,newNodes,1,size-1);
            }
            nodes = newNodes;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

