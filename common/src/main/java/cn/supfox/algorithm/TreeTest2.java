package cn.supfox.algorithm;

import java.util.ArrayList;
import java.util.List;

public class TreeTest2 {

    //
    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
//
//
//    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//
//        List<TreeNode> l1 = new ArrayList<>();
//        List<TreeNode> l2 = new ArrayList<>();
//
//
//        lowestCommonAncestor(root, l1, p);
//        lowestCommonAncestor(root, l2, q);
//
//        System.out.println(l1);
//        System.out.println(l2);
//
//        return null;
//
//    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //节点等于p的，结束递归

        if (root == null || root == p || root == q ){
            return root;
        }
        TreeNode treeNode = lowestCommonAncestor(root.left, p, q);
        TreeNode treeNode1 = lowestCommonAncestor(root.right, p, q);

        if (treeNode == null) {
            return treeNode1;
        }
        if (treeNode1 == null) {
            return treeNode;
        }
        return root;
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(6);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        treeNode.left = p;
        treeNode.right = q;

        TreeNode treeNode1 = lowestCommonAncestor(treeNode, p, q);
        System.out.println(treeNode1);

    }

}
