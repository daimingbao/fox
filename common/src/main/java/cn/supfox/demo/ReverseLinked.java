package cn.supfox.demo;

public class ReverseLinked {

    /**
     * aaa
     *
     * 有一个单向链表
     * 1→2→3→。。。→9
     *
     * 两个一组翻转此链表，最后如果是单个则不翻转
     * 2→1→4→3→6→5→8→7→9
     */

    private static class Node {

        private int val;

        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1, new Node(5, new Node(6, new Node(3, new Node(9,new Node(10, new Node(0)))))));

        if (head == null || head.next == null) {
            //返回
        }
        //2个一组翻转
        Node curr = head;
        Node pre = null;
        // 1 5 6 3 9 10
        // 5 1 3 6
        Node dumy = curr.next;
        while (curr != null && curr.next != null) {

            //交换两个节点
            Node temp = curr.next.next;

            //交换节点 翻转节点
            Node t1 = curr.next;
            curr.next = temp;
            t1.next = curr;

            //前面一个节点和当前 段关联
            if (pre != null) {
                pre.next = t1;
            }
            //前一个节点
            pre = curr;
            //当前节点
            curr = temp;
        }

        System.out.println(dumy);
    }

}
