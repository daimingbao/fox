package cn.supfox.algorithm;

public class ReverseList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4
        , new ListNode(5, null)))));

        ListNode listNode = reverseList(head);
        System.out.println(listNode);
    }

    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }


        ListNode next =  head.next;
        ListNode newHead = null;
        ListNode curr = head;
        while (next != null) {
            ListNode tmpnext =   next.next;

            ListNode tmp = new ListNode();
            tmp.next = curr;
//            next.next = curr;
            curr = tmp;
            next = tmpnext;
            if (tmpnext == null) {
                newHead = next;
                break;
            }
        }
        return newHead;
    }

   public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
