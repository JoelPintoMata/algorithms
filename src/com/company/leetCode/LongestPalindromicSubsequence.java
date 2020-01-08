package com.company.leetCode;

/**
 * 516. Longest Palindromic Subsequence: https://leetcode.com/problems/longest-palindromic-subsequence/
 * <p>
 * Runtime: 17 ms, faster than 89.48% of Java online submissions for Longest Palindromic Subsequence.
 * Memory Usage: 47.7 MB, less than 5.55% of Java online submissions for Longest Palindromic Subsequence.
 */
public class LongestPalindromicSubsequence {

    int[][] array;

    public static void main(String[] args) {
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();

        String s;
//        s = "agbdba";
//        s = "bbbab";
//        s = "bacab";
//        s = "bbbab";
        s = "nwlrbbmqbh";
        int dynamic = lps.calculateDynamic(s);
        int recursive = lps.longestPalindromeSubseq(s);

        System.out.print(dynamic + " " + recursive);
    }

    public int longestPalindromeSubseq(String s) {
//        return calculateDynamic(s, 0, s.length() - 1);

        array = new int[s.length()][s.length()];
        return calculateRecursive(s, 0, s.length() - 1);
    }

    public int calculateDynamic(String s) {
        int[][] array = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            array[i][i] = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < s.length() - 1; j++) {
                if (j + i >= s.length()) {
                    break;
                }
                if (s.charAt(j) == s.charAt(j + i)) {
                    array[j][j + i] = 2 + array[j + 1][(j + i) - 1];
                } else {
                    array[j][(j + i)] = Math.max(array[j][(j + i) - 1],
                            array[j + 1][(j + i)]);
                }
            }
        }
        return array[0][s.length() - 1];
    }

    private int calculateRecursive(String str, int from, int to) {
        if (array[from][to] != 0)
            return array[from][to];
        if (from > to || to < from)
            return 0;
        if (from == to)
            return 1;
        int value;
        if (str.charAt(from) != str.charAt(to)) {
            int i1 = calculateRecursive(str, from, to - 1);
            int i2 = calculateRecursive(str, from + 1, to);
            value = Math.max(i1, i2);
        } else {
            value = 2 + calculateRecursive(str, from + 1, to - 1);
        }
        array[from][to] = value;
        return value;
    }
}