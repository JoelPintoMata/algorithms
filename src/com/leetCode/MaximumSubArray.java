package com.leetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 121. Best Time to Buy and Sell Stock I: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-i/
 * <p>
 * Runtime: 1 ms, faster than 73.40% of Java online submissions for Best Time to Buy and Sell Stock.
 * Memory Usage: 42.5 MB, less than 5.31% of Java online submissions for Best Time to Buy and Sell Stock.
 */
public class MaximumSubArray {

    Set<List<Integer>> solutions = new HashSet<>(0);

    public static void main(String[] a) {
        MaximumSubArray combinationSumIV = new MaximumSubArray();
        System.out.println(combinationSumIV.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
//        System.out.println(combinationSumIV.maxSubArray(new int []{-2}));
//        System.out.println(combinationSumIV.maxSubArray(new int []{2}));
//        System.out.println(combinationSumIV.maxSubArray(new int []{-1, -2}));
    }

    public int maxSubArray(int[] A) {

        if (A == null) {
            return 0;
        }

        int maxSum = A[0];
        int currentSum = A[0];

        for (int i = 1; i < A.length; i++) {
            currentSum += A[i];

            // restart sum if the current value is greater than sum of current + previous
            if (A[i] > currentSum) {
                currentSum = A[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }
}