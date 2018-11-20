package com.codility.maximumSliceProblem;


import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_profit/
 *
 * 66% solution
 */
public class MaxProfit {

    public static void main(String a[]) {
        System.out.println(solution(new int[]{23171, 21011, 21123, 21366, 21013, 21367}));
    }

    public static int solution(int[] A) {
        for (int i = 0; i < A.length; i++) {
            solutionAux(A[i], Arrays.copyOfRange(A, i, A.length));
        }
        return max>0?max:0;
    }

    private static int max = 0;

    public static void solutionAux(int current, int[] A) {
        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            result[i] = A[i] - current;
            if(result[i] > max)
                max = result[i];
        }
    }
}