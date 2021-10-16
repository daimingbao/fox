package cn.supfox.algorithm;

public class MergeList {


    //      Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5, new ListNode(6, null));
        ListNode l2 = new ListNode(2, new ListNode(3, new ListNode(4, null)));

        ListNode listNode = mergeTwoLists2(l1, l2);
        System.out.println(listNode);
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode newNode = new ListNode();
        ListNode newHead = newNode;
        while (l1 != null && l2 != null) {
            if (l1 != null && l2 != null && l1.val <= l2.val) {
                ListNode tmp = l1;
                l1 = l1.next;
                tmp.next = null;
                newNode.next = tmp;
                newNode = newNode.next;
            }

            if (l1 != null && l2 != null && l2.val <= l1.val) {
                ListNode tmp = l2;
                l2 = l2.next;
                tmp.next = null;
                newNode.next = tmp;
                newNode = newNode.next;
            }
        }


        if (l1 == null && l2 != null) {
            ListNode tmp = l2;
            newNode.next = tmp;
            newNode = newNode.next;
            l2 = l2.next;
        }

        if (l2 == null && l1 != null) {
            ListNode tmp = l1;
            newNode.next = tmp;
            newNode = newNode.next;
            l1 = l1.next;
        }

        return newHead;

    }

    //递归的思想，负载问题分成若干个一样的小问题，处理
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val <= l2.val) {
            //每次都需要计算一个最新的节点，作为头节点
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            //此时l2作为头节点，l2.next和l1继续比较得到下一个节点
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }

    }
}
