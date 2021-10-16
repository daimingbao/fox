package cn.supfox.algorithm;

import lombok.Data;

public class AverageTree {


    public boolean isBalancedSolution(TreeNode treeNode) {
        if (treeNode == null) {
            return false;
        }
        int m1 = height(treeNode.left);
        int m2 =  height(treeNode.right);
        if (Math.abs(m1-m2) > 1) {
            return false;
        }
        return isBalancedSolution(treeNode.left) && isBalancedSolution(treeNode.right);
    }

    public int height(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
       int a = height(treeNode.left);
       int b =  height(treeNode.right);
       return a > b ? a+1 : b+1;
    }

   @Data
   static class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int val;
    }
}





