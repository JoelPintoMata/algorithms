package com.leetCode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 39. Combination Sum: https://leetcode.com/problems/combination-sum
 * <p>
 * Runtime: 250 ms, faster than 5.07% of Java online submissions for Combination Sum.
 * Memory Usage: 58.2 MB, less than 5.19% of Java online submissions for Combination Sum.
 */
public class CombinationSum {

    Set<List<Integer>> solutions = new HashSet<>(0);

    public static void main(String[] a) {
        CombinationSum combinationSumIV = new CombinationSum();
        System.out.println(combinationSumIV.combinationSum(
                new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Stack<Integer> stack = new Stack<>();
        if (candidates.length == 0)
            return Collections.emptyList();
        helper(candidates, stack, 0, target);
        return solutions.stream().collect(Collectors.toList());
    }

    private int helper(int[] candidates, Stack<Integer> queue, int total, int target) {
        if (total == target) {
            List<Integer> xxx = queue.stream().collect(Collectors.toList());
            Collections.sort(xxx);
            solutions.add(xxx);
            return total - queue.pop();
        } else if (total > target) {
            return total - queue.pop();
        }

        for (int i = 0; i < candidates.length; i++) {
            queue.push(candidates[i]);
            total = total + candidates[i];
            total = helper(candidates, queue, total, target);
        }

        if (!queue.empty())
            return total - queue.pop();
        else
            return total;
    }
}