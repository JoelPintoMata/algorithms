package com.leetCode;

/**
 * Palindromic Substrings: https://leetcode.com/problems/palindromic-substrings/
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Palindromic Substrings
 * Memory Usage: 34.2 MB, less than 100.00% of Java online submissions for Palindromic Substrings.
 */
public class PalindromicStrings {

    public static void main(String[] a) {
//        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));
    }

    public static int countSubstrings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count = count + getPalindroms(s, i, i);
            count = count + getPalindroms(s, i, i + 1);
        }
        return count;
    }

    private static int getPalindroms(String s, int from, int to) {
        int count = 0;
        while (from >= 0 && to < s.length() && s.charAt(from) == s.charAt(to)) {
            count++;
            from--;
            to++;
        }
        return count;
    }
}