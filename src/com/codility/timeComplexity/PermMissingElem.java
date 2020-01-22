package com.codility.timeComplexity;


/**
 * PermMissingElem: https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/start/
 * <p>
 * 100% solution
 */
public class PermMissingElem {

    public static void main(String[] a) {
        PermMissingElem solution = new PermMissingElem();
        System.out.println(solution.solution(new int[]{1, 5, 2, 3}));
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int total = 0;
        for (int i = 1; i <= A.length + 1; i++) {
            total = total + i;
        }
        // System.out.println(total);
        int totalA = 0;
        for (int i = 0; i < A.length; i++) {
            totalA = totalA + A[i];
        }
        // System.out.println(totalA);
        return total - totalA;
    }
}