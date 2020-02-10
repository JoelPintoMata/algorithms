package com.leetCode;

/**
 * 1302. Deepest Leaves Sum: https://leetcode.com/problems/deepest-leaves-sum/
 * <p>
 * Runtime: 1 ms, faster than 96.46% of Java online submissions for Deepest Leaves Sum.
 * Memory Usage: 43.7 MB, less than 100.00% of Java online submissions for Deepest Leaves Sum.
 */
//public class DeepestLeavesSum {
//    int maxLevel = 0;
//    Map<Integer, Integer> map = new HashMap<>();
//    public int deepestLeavesSum(TreeNode root) {
//        if(root == null) {
//            return 0;
//        }
//        helper(root, 1);
//        return map.get(maxLevel);
//    }
//
//    public int helper(TreeNode root, int level) {
//        int result = -1;
//        if(root == null) {
//            result = 0;
//        } else {
//            int v1 = helper(root.left, level + 1);
//            int v2 = helper(root.right, level + 1);
//            if(v1 + v2 == 0) {
//                if(map.containsKey(level)) {
//                    map.put(level, map.get(level) + root.val);
//                } else {
//                    map.put(level, root.val);
//                }
//                if(maxLevel < level)
//                    maxLevel = level;
//            }
//            result = -1;
//        }
//        return result;
//    }
//}