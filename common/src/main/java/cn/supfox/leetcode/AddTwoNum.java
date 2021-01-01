//package cn.supfox;
//
//public class AddTwoNum {
//    //给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
////
//// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
////
//// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
////
//// 示例：
////
//// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
////输出：7 -> 0 -> 8
////原因：342 + 465 = 807
////
//// Related Topics 链表 数学
//// 👍 5318 👎 0
//
//
////leetcode submit region begin(Prohibit modification and deletion)
//public static void main(String[] args) {
//    ListNode l1 = new ListNode(2,new ListNode(1, new ListNode(2,null)));
//    ListNode l2 = new ListNode(2,new ListNode(9, new ListNode(3,null)));
//    ListNode listNode = addTwoNumbers(l1, l2);
//    System.out.println(listNode);
//}
//
//    public static class ListNode {
//      int val;
//      ListNode next;
//      ListNode() {}
//      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }
//    /**
//     * Definition for singly-linked list.
//     * public class ListNode {
//     *     int val;
//     *     ListNode next;
//     *     ListNode() {}
//     *     ListNode(int val) { this.val = val; }
//     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//     * }
//     */
//        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//            //遍历l1
//            int a =  l1.val;
//            int b =  l2.val;
//            int d = a + b;
//            int tmp = 0;
//            ListNode head = new ListNode(d);
//            ListNode tail = head;
//
//            l1 = l1.next;
//            l2 = l2.next;
//            if ((a+b) >= 10 ){
//                tmp =  (a + b) % 10;
//            }
//            do {
//                a = l1.val;
//                b = l2.val;
//                ListNode tmpListNode = new ListNode((a + b + tmp)%10);
//                if ((a+b) >= 10 ){
//                    tmp =  (a + b) / 10;
//                }
//                tail.next = tmpListNode;
//                tail = tail.next;
//                if(l1.next == null && l2.next == null) {
//                    return head;
//                }
//                if (l1.next == null) {
//                    l1 = null;
//                } else {
//                    l1 = l1.next;
//                }
//
//                if (l2.next == null) {
//                    l2 = null;
//                } else {
//                    l2 = l2.next;
//                }
//            } while (true);
//        }
//    }
////leetcode submit region end(Prohibit modification and deletion)
//
//
