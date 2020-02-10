package com.amazonia;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Something2 {

    Set<List<Integer>> solutions = new HashSet<>(0);

    public static void main(String[] a) {
        Something2 Something1 = new Something2();
        int val = 0;
        val = Something1.solution(new int[]{4, -1, 0, 3}, new int[]{-2, 5, 0, 3});
        System.out.println(val);
        val = Something1.solution(new int[]{2, -2, -3, 3}, new int[]{0, 0, 4, -4});
        System.out.println(val);
        val = Something1.solution(new int[]{4, -1, 0, 3}, new int[]{-2, 6, 0, 4});
        System.out.println(val);
        val = Something1.solution(new int[]{3, 2, 6}, new int[]{4, 1, 6});
        System.out.println(val);
        val = Something1.solution(new int[]{1, 4, 2, -2, 5}, new int[]{7, -2, -2, 2, 5});
        System.out.println(val);
    }

    public int solution(int[] A, int[] B) {
        if (A.length == 0) {
            return 0;
        }
        if (A.length == 1 && A[0] == B[0]) {
            return 0;
        }
        if (A.length == 1 && A[0] != B[0]) {
            return 0;
        }
        for (int i = 1; i < A.length; i++) {
            A[i] = A[i] + A[i - 1];
        }
        int count = 0;
        int[] C = new int[B.length];
        C[B.length - 1] = B[B.length - 1];
        for (int i = B.length - 2; i >= 0; i--) {
            C[i] = B[i] + C[i + 1];
        }
        for (int i = 1; i < B.length; i++) {
            B[i] = B[i] + B[i - 1];
            if (B[i - 1] == A[i - 1] && A[i - 1] == C[i]) {
                count++;
            }
        }
        return count;
    }
}