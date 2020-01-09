package com.company.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 167. Two Sum II - Input array is sorted: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * <p>
 * Runtime: 3 ms, faster than 19.28% of Java online submissions for Two Sum II - Input array is sorted.
 * Memory Usage: 37.2 MB, less than 100.00% of Java online submissions for Two Sum II - Input array is sorted.
 */
public class TwoSumII {

    public static void main(String[] a) {
        TwoSumII twoSumII = new TwoSumII();
        twoSumII.twoSum(new int[]{2, 7, 11, 15}, 9);
    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            int val = numbers[i];
            if (val > target)
                break;
            map.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i]) && map.get(target - numbers[i]) != i) {
                return new int[]{i + 1, map.get(target - numbers[i]) + 1};
            }
        }
        return new int[]{};
    }
}
