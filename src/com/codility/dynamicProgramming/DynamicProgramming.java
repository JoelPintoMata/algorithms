package com.codility.dynamicProgramming;


import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/17-dynamic_programming/number_solitaire/
 *
 * 66% solution
 */
class NumberSolitaire {

    public static void main(String a[]) {
        System.out.println(solution(new int[]{1, -2, 0, 9, -1, -2}));
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