package cn.supfox.algorithm;

import java.util.LinkedList;

/**
 * 翻转链表啊
 */
public class ReverseLinkedList {

    private static LinkedList<Node> linkedList = new LinkedList<>();

    static {
        linkedList.add(new Node(1));
        linkedList.add(new Node(2));
        linkedList.add(new Node(3));
        linkedList.add(new Node(4));
        linkedList.add(new Node(5));
    }

    private static class Node{
        private int data;

        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println(linkedList);


    }

}
