package com.company.leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * FourSum: https://leetcode.com/problems/4sum/
 * two pointers: https://www.geeksforgeeks.org/two-pointers-technique/
 */
public class FourSum {

    public static void main(String[] a) {
//        fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> resultList = new HashSet<>();
        int i, j, k, l;
        int n = nums.length;

//        sort the array
        Arrays.sort(nums);

        for (i = 0; i < n - 1; i++) {
            for (j = i + 1; j < n - 1; j++) {
                k = j + 1;
                l = n - 1;
                while (l > k && k < l) {
                    int currentVal = nums[i] + nums[j] + nums[k] + nums[l];
                    if (currentVal > target) {
                        l--;
                    } else if (currentVal < target) {
                        k++;
                    } else {
                        resultList.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        Arrays.asList(nums[i], nums[j], nums[k], nums[l]).stream().forEach(x -> System.out.print(x + " "));
                        System.out.println();
                        l--;
                        k++;
                    }
                }
            }
        }
        return resultList.stream().collect(Collectors.toList());
    }
}
