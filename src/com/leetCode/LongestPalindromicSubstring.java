package com.leetCode;

/**
 * 5. Longest Palindromic Substring: https://leetcode.com/problems/longest-palindromic-substring/
 *
 * two pointers: https://www.geeksforgeeks.org/two-pointers-technique/
 *
 * Runtime: 17 ms, faster than 53.35% of Java online submissions for Longest Palindromic Substring.
 * Memory Usage: 36.5 MB, less than 100.00% of Java online submissions for Longest Palindromic Substring.
 */
public class LongestPalindromicSubstring {

    public static void main(String[] a) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 0) return s;
        if (s.length() == 1) return s;

        String max = "";
        for (int i = 0; i < s.length() - 1; i++) {
            String l1 = expandPalindrome(s, i, i);
            String l2 = expandPalindrome(s, i, i + 1);
            if (l1.length() > l2.length()) {
                if (l1.length() > max.length()) {
                    max = l1;
                }
            }
            if (l2.length() > l1.length()) {
                if (l2.length() > max.length()) {
                    max = l2;
                }
            }
        }
        return max;
    }

    public static String expandPalindrome(String s, int from, int to) {
        while (from >= 0 && to < s.length() && s.charAt(from) == s.charAt(to)) {
            from--;
            to++;
        }
        return s.substring(from + 1, to);
    }
}
