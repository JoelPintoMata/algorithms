package com.leetCode;

/**
 * 342. Power of Four: https://leetcode.com/problems/power-of-four
 * <p>
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Power of Four.
 * Memory Usage: 33.5 MB, less than 6.67% of Java online submissions for Power of Four.
 */
public class PowerOfFour {

    public static void main(String[] a) {
        PowerOfFour powerOfFour = new PowerOfFour();
        System.out.println(powerOfFour.isPowerOfFour(-2147483648));
    }

    public boolean isPowerOfFour(int num) {
        return helper(num);
    }

    public boolean helper(int num) {
        if (num == 1) {
            return true;
        }
//        is the number divisible by four?
        if (num % 4 != 0) {
            return false;
        }
//        being divisible by four does not mean that is a power of four
//        8 is divisible by four, but not a power of 4
        return helper(num / 4);
    }
}
