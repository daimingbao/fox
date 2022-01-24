package cn.supfox.algorithm;

public class ADDTowNum {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode data = new ListNode();
        ListNode dumy = data;
        int n1=  l1.val;
        int n2 = l2.val;
        data.val = (n1+n2)%10;
        int n = (n1+n2)/10;
        while((l1 != null && l1.next != null) || (l2 != null && l2.next != null) ) {
            l1 = l1 == null ? null :  l1.next;
            l2 = l2 == null ? null : l2.next;
            n1 = l1 == null ? 0 : l1.val;
            n2 = l2 == null ? 0 : l2.val;
            ListNode temp = new ListNode();
            temp.val = (n+n1+ n2)%10;
            n = (n+n1+n2)/10;
            data.next = temp;
            data = temp;
        }
        return dumy;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }
}


   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {

}
