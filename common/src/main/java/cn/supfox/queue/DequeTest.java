package cn.supfox.queue;

import java.util.*;

public class DequeTest {

    public static void main(String[] args) {
        TreeNode root =  new TreeNode(8);
        TreeNode treeNode1 = new TreeNode(6);
        treeNode1.left = new TreeNode(5);
        treeNode1.right = new TreeNode(7);
        root.left = treeNode1;
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(11);
        root.right = treeNode;
        new Solution().Print(root);
    }
}



class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

}
 class Solution {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>>  result = new ArrayList<>();
        //按之字型打印，其实就是遍历
        //思想 一行一行遍历  先从左节点开始遍历第一层 再从右往左遍历第二层 依次类推
        //可以联想到生产者消费者模式 有两个容器
        // 一个容器存第1层的节点 存完了通知第二个容器 存第2层的节点
        //一个容器存第2层的 存完第2层的 通知第一个存第三层的，依次类推。

        //假设使用两个队列 队列q1，队列q2 根节点加入队列q1,然后从q1再pop节点
        // 将root下面的右左节点分别push到队列2
        //然后q2 pop2节点 并将左右子节点push到队列1
        Deque<TreeNode> q1 = new ArrayDeque();
        Deque<TreeNode> q2 = new ArrayDeque();
        q1.addFirst(pRoot);
        while(!q1.isEmpty()  || !q2.isEmpty()) {
            ArrayList<Integer> l1 = new ArrayList();
            int q1Size = q1.size();
            for(int i=0; i< q1Size; i++) {
                TreeNode n1 =  q1.pollFirst();
                l1.add(n1.val);
                if(n1.right != null) {
                    q2.addFirst(n1.right);
                }
                if(n1.left != null) {
                    q2.addLast(n1.left);
                }
            }
            if(l1.size() > 0) {
                result.add(l1);
            }


            ArrayList<Integer> l2 = new ArrayList();
            int q2Size = q2.size();
            for(int i=0; i<q2Size; i++) {
                TreeNode n2 =  q2.pollLast();
                l2.add(n2.val);
                if(n2.left != null) {
                    q1.addFirst(n2.left);
                }
                if(n2.right != null) {
                    q1.addFirst(n2.right);
                }
            }
            if(l2.size()> 0) {
                result.add(l2);
            }
        }

        return result;
    }

}