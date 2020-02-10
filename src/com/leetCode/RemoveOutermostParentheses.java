package com.leetCode;

import java.util.Stack;

/**
 * 1021. Remove Outermost Parentheses: https://leetcode.com/problems/remove-outermost-parentheses/
 * <p>
 * Runtime: 7 ms, faster than 31.33% of Java online submissions for Remove Outermost Parentheses.
 * Memory Usage: 41.9 MB, less than 5.19% of Java online submissions for Remove Outermost Parentheses.
 */
public class RemoveOutermostParentheses {

    public static void main(String[] a) {
        RemoveOutermostParentheses combinationSumIV = new RemoveOutermostParentheses();
        System.out.println(combinationSumIV.removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(combinationSumIV.removeOuterParentheses("(()"));
    }

    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack();
        if (S.length() == 0)
            return "";

        int start = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (!stack.empty() && stack.peek() == '(' && S.charAt(i) == ')') {
                stack.pop();
                if (stack.empty()) {
                    result.append(S, start + 1, i);
                    start = i + 1;
                }
            } else {
                stack.push(S.charAt(i));
            }
        }
        return result.toString();
    }
}