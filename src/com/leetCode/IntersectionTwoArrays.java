package com.leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 349. Intersection of Two Arrays: https://leetcode.com/problems/intersection-of-two-arrays/
 * <p>
 * A better way of defining this problem is search for elements of A existing in B
 * <p>
 * Runtime: 250 ms, faster than 5.07% of Java online submissions for Combination Sum.
 * Memory Usage: 58.2 MB, less than 5.19% of Java online submissions for Combination Sum.
 */
public class IntersectionTwoArrays {

    public static void main(String[] a) {
        IntersectionTwoArrays intersectionTwoArrays = new IntersectionTwoArrays();
        Arrays.stream(intersectionTwoArrays.intersection(
                new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})).forEach(x -> System.out.println(x));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet(0);
        Arrays.stream(nums1).forEach(x -> set1.add(x));

        Set<Integer> set2 = new HashSet(0);
        Arrays.stream(nums2).forEach(x -> set2.add(x));

        Set<Integer> resultSet = new HashSet<>(0);

        for (int i : set1) {
            if (set2.contains(i))
                resultSet.add(i);
        }

        return resultSet.stream().mapToInt(Integer::intValue).toArray();
    }
}