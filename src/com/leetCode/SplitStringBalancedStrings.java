package com.leetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * 39. Combination Sum: https://leetcode.com/problems/combination-sum
 * <p>
 * Runtime: 250 ms, faster than 5.07% of Java online submissions for Combination Sum.
 * Memory Usage: 58.2 MB, less than 5.19% of Java online submissions for Combination Sum.
 */
public class SplitStringBalancedStrings {

    Set<List<Integer>> solutions = new HashSet<>(0);

    public static void main(String[] a) {
        SplitStringBalancedStrings combinationSumIV = new SplitStringBalancedStrings();
//        System.out.println(combinationSumIV.balancedStringSplit("RLRRLLRLRL"));
//        System.out.println(combinationSumIV.balancedStringSplit("RL"));
//        System.out.println(combinationSumIV.balancedStringSplit("LR"));
//        System.out.println(combinationSumIV.balancedStringSplit("LLR"));
        System.out.println(combinationSumIV.balancedStringSplit("RLRRRLLRLL"));
    }

    public int balancedStringSplit(String s) {
        Stack<Character> stack = new Stack();
        int i = 0;
        int count = 0;
        int skip = 1;
        while (i < s.length()) {
            if (!stack.empty() && (stack.peek() == 'L' && s.charAt(i) == 'R'
                    || stack.peek() == 'R' && s.charAt(i) == 'L')) {
                if (skip == 0)
                    count++;
                skip = 1;
                stack.pop();
            } else if (stack.empty()) {
                skip = 0;
                stack.push(s.charAt(i));
            } else {
                stack.push(s.charAt(i));
            }
            i++;
        }
        return count;
    }
}