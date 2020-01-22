package com.company.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Combination Sum IV
 */
public class CombinationSumIV {

    Map<Integer, Integer> visited = new HashMap<>(0);

    public static void main(String[] a) {
        CombinationSumIV combinationSumIV = new CombinationSumIV();
//        System.out.println(combinationSumIV.combinationSum4(new int[]{1, 2, 3}, 4));
//        System.out.println(combinationSumIV.combinationSum4(new int[]{9}, 3));
//        System.out.println(combinationSumIV.combinationSum4(new int[]{2, 1, 3}, 35));
        System.out.println(combinationSumIV.combinationSum4(
                new int[]{3, 4, 5, 6, 7, 8, 9, 10}, 10));
    }

    public int combinationSum4(int[] nums, int target) {
        if (nums.length == 0)
            return 0;

        return helper(nums, 0, target);
    }

    private int helper(int[] nums, int total, int target) {
        if (total == target) {
            return 1;
        } else if (total > target) {
            return 0;
        }
        if (visited.containsKey(total))
            return visited.get(total);

        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            counter = counter + helper(nums, total + nums[i], target);
            visited.put(total, counter);
        }
        return counter;
    }
}