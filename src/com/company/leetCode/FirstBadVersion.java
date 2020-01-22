//package com.company.leetCode;
//
///**
// * 278. First Bad Version: https://leetcode.com/problems/first-bad-version/
// *
// * Runtime: 10 ms, faster than 99.86% of Java online submissions for First Bad Version.
// * Memory Usage: 38.6 MB, less than 5.63% of Java online submissions for First Bad Version.
// */
//
///* The isBadVersion API is defined in the parent class VersionControl.
//      boolean isBadVersion(int version); */
//
//public class FirstBadVersion extends VersionControl {
//
//    public int firstBadVersion(int n) {
//        int start = 1;
//        int version = n;
//        while(start <= n) {
//            int middle = start + (n - start)/2;
//            if(isBadVersion(middle)) {
//                version = middle;
//                n = middle-1;
//            } else {
//                start = middle + 1;
//            }
//        }
//        return version;
//    }
//}