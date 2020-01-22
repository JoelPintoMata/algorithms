//package com.company.leetCode;
//
///**
// * 513. Find Bottom Left Tree Value: https://leetcode.com/problems/find-bottom-left-tree-value/
// */
//public class FindBottomLeftTreeValue {
//
//    public int findBottomLeftValue(TreeNode root) {
//        return helper(root, 0);
//    }
//
//    public int helper(TreeNode root, int side) {
//        if (root == null)
//            return 0;
//        if (root.left == null && root.right == null && side == 0)
//            return root.val;
//        if (root.left == null && root.right == null && side == -1)
//            return root.val;
//        if (root.left == null && root.right == null && side == 1)
//            return 0;
//
//        return Math.max(helper(root.left, -1), helper(root.right, 1));
//    }
//}