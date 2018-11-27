package com.codility.fibonacci;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Check: https://app.codility.com/programmers/lessons/2-arrays/
 *
 * 100% solution
 */
public class FibFrog {

    private static List<Integer> fibs;
    private static int min;
    private static int jumps = 0;

    public static void main(String a[]){

        min = -1;
        jumps = 0;
        solution(new int[]{0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0});
        System.out.println(min);

        min = -1;
        jumps = 0;
        solution(new int[]{1, 1});
        System.out.println(min);

        min = -1;
        jumps = 0;
        solution(new int[]{0});
        System.out.println(min);

        min = -1;
        jumps = 0;
        solution(new int[]{});
        System.out.println(min);
    }

    public static int solution(int[] A) {
        fibs = fibs(A);
        solutionAux(A, fibs);
        return jumps;
    }

    public static void solutionAux(int[] A, List<Integer> fibs) {
        if (min != -1 && jumps > min) {
            --jumps;
            return;
        }

        for (int i = fibs.size() - 1; i > 0; i--) {
//            the jump is too big
            if (fibs.get(i) > A.length)
                continue;

            if (fibs.get(i) == A.length) {
                jumps++;
                if (min == -1 || jumps < min) {
                    min = jumps;
                }
                --jumps;
                return;
            }

            if (A[fibs.get(i) - 1] == 1) {
                jumps++;
                solutionAux(Arrays.copyOfRange(A, fibs.get(i) - 1, A.length), fibs);
            }
        }
        return;
    }

    private static List<Integer> fibs(int[] A) {
        List<Integer> fibs = new ArrayList();
        for (int i = 0; i < A.length * 2; i++) {
            if (i == 0)
                fibs.add(0);
            else if (i == 1)
                fibs.add(1);
            else
                fibs.add(fibs.get(i - 1) + fibs.get(i - 2));
        }
        return fibs;
    }
}