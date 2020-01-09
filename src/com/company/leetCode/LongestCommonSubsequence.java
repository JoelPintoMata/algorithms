package com.company.leetCode;

/**
 * 1143. Longest Common Subsequence: https://leetcode.com/problems/longest-common-subsequence/
 *
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String str1 = "aed";
        String str2 = "acxe";

        int result = lcs.longestCommonSubsequence(str1, str2);
        System.out.print(result);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int v1 = helper(text1, text2, 0, 0);
        return v1;
    }

    private int helper(String text1, String text2, int i1, int i2) {
        if (i1 >= text1.length() || i2 >= text2.length())
            return 0;
        if (text1.charAt(i1) == text2.charAt(i2)) {
            return 1 + helper(text1, text2, i1 + 1, i2 + 1);
        }
        return Math.max(helper(text1, text2, i1 + 1, i2),
                helper(text1, text2, i1, i2 + 1));
    }
}