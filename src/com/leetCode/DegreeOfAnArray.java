//package com.leetCode;
//
//import java.util.*;
//
///**
// * 121. Best Time to Buy and Sell Stock I: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-i/
// *
// * Runtime: 1 ms, faster than 73.40% of Java online submissions for Best Time to Buy and Sell Stock.
// * Memory Usage: 42.5 MB, less than 5.31% of Java online submissions for Best Time to Buy and Sell Stock.
// */
//public class DegreeOfAnArray {
//
//    public static void main(String[] a) {
//        DegreeOfAnArray combinationSumIV = new DegreeOfAnArray();
////        System.out.println(combinationSumIV.findShortestSubArray(new int []{1, 2, 2, 3, 1}));
////        System.out.println(combinationSumIV.findShortestSubArray(new int []{1, 2, 2, 3, 1, 4, 2}));
//        System.out.println(combinationSumIV.findShortestSubArray(new int []{2,1,1,2,1,3,3,3,1,3,1,3,2}));
////        System.out.println(combinationSumIV.findShortestSubArray(new int []{1}));
//    }
//
//    public int findShortestSubArray(int[] nums) {
////        find degree
//        Map<Integer,Integer> map = new HashMap<>();
//        Map<Integer,Integer> mapposi = new HashMap<>();
//        Map<Integer,Integer> mapposf = new HashMap<>();
//        int max = 0;
//        int numMaxIndex = 0;
//        for (int i=0; i<nums.length; i++) {
//            if (map.containsKey(nums[i])) {
//                map.put(nums[i], map.get(nums[i]) + 1);
//                mapposf.put(nums[i], i);
//                if (numMaxIndex == nums[i]) {
//                    max = map.get(nums[i]);
//                    continue;
//                }
//                if (max =< map.get(nums[i]) &&) {
//                    max = map.get(nums[i]);
//                    numMaxIndex = nums[i];
//                }
//            } else {
//                map.put(nums[i], 1);
//                mapposi.put(nums[i], 0);
//            }
//        }
//
//        int posi = -1;
//        int posf = -1;
//        int found = 0;
//        int i = 0;
//        while(i < nums.length && found < max) {
//            if (nums[i] == numMaxIndex && posi != -1) {
//                posf = i;
//                found ++;
//            }
//            if (nums[i] == numMaxIndex && posi == -1) {
//                posi = i;
//                found ++;
//            }
//            i++;
//        }
//        return posf - posi + 1;
//    }
//}