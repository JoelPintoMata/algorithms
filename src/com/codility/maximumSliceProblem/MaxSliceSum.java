package com.codility.maximumSliceProblem;


import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_slice_sum/
 *
 * 84% solution
 */
public class MaxSliceSum {

    public static void main(String a[]) {
        System.out.println(solution(new int[]{3, 2, -6, 4, 0}));
        System.out.println(solution(new int[]{4, 5, -10, 9, 0}));
        System.out.println(solution(new int[]{-10}));
        System.out.println(solution(new int[]{-2, 1}));
    }

    public static int solution(int[] A) {
        for (int i = 0; i < A.length; i++) {
            solutionAux(Arrays.copyOfRange(A, i, A.length));
        }
        return max;
    }

    private static int max = -2147483648;

    public static void solutionAux(int[] A) {
        int[] result = new int[A.length];

        int tot = 0;
        for (int i = 0; i < A.length; i++) {
            tot = tot + A[i];
            result[i] = tot;
            if(result[i] > max)
                max = result[i];
        }
    }
}