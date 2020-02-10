package com.codility.challenges.zalando;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * MaxNotPresent: https://app.codility.com/c/run/trainingRQ2YBA-2KD/
 * https://leetcode.com/problems/card-flipping-game/submissions/
 * <p>
 * Detected time complexity: O(2**(N+M)) or O(N*M*(N+M))
 */
public class MaxNotPresent {

    int result = 0;

    public static void main(String[] a) {
        MaxNotPresent solution = new MaxNotPresent();
//        System.out.println(solution.solution(new int[]{1, 2, 4, 3}, new int[]{1, 3, 2, 3}));
//        System.out.println(solution.solution(new int[]{4, 2, 1, 6, 5}, new int[]{3, 2, 1, 7, 7}));
//        System.out.println(solution.solution(new int[]{1, 2, 4, 4, 7}, new int[]{1, 3, 4, 1, 3}));
        System.out.println(solution.solution(new int[]{1}, new int[]{2}));
    }

    public int solution(int[] A, int[] B) {
        if (A.length == 1)
            if (A[0] == A[1])
                return 0;
            else
                return Math.min(A[0], B[0]);

        return helper(A, B, new int[A.length], 0);
    }

    public int helper(int[] A, int[] B, int[] stackAux, int index) {
        if (index >= A.length)
            return findMissingNumber(stackAux);

        int v1 = 0;
        if (!Arrays.asList(stackAux).contains(A[index])) {
            stackAux[index] = A[index];
            v1 = helper(A, B, stackAux, index + 1);
        }

        int v2 = 0;
        if (!Arrays.asList(stackAux).contains(B[index])) {
            stackAux[index] = B[index];
            v2 = helper(A, B, stackAux, index + 1);
        }

        return Math.min(v1, v2);
    }

    private int findMissingNumber(int[] stackAux) {
        Set<Integer> set = new HashSet<>(stackAux.length);
        for (int i : stackAux)
            set.add(i);
        if (set.size() == stackAux.length)
            return result;
        for (int i = 1; i < stackAux.length; i++) {
            if (!set.contains(i)) {
                if (result == 0)
                    result = i;
                else if (result > i)
                    result = i;
                break;
            }
        }
        return result;
    }
}