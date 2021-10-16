package cn.supfox.algorithm;

public class TreeTest {


    // Definition for a binary tree node.
    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public static void main(String[] args) {


    }


    public static boolean hasPathSum(TreeNode root, int sum1) {

        if (root == null ){
            return false;
        }
        //到达了根节点,判断是否有等值
        if (root.right == null && root.left == null) {
            return root.val == sum1;
        }
        return   hasPathSum( root.left, sum1 - root.val) ||
        hasPathSum( root.right, sum1 - root.val);

    }
}
