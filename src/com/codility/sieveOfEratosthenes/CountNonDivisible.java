package com.codility.sieveOfEratosthenes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_non_divisible/start/
 *
 * 55% solution
 */
public class CountNonDivisible {

    public static void main(String a[]) {
        Arrays.stream(solution(new int[]{3, 1, 2, 3, 6})).forEach(System.out::println);
        Arrays.stream(solution(new int[]{3})).forEach(System.out::println);
    }

    public static int[] solution(int[] A) {
        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (A[i] % A[j] > 0) {
                    result[i] = result[i] + 1;
                }
            }
        }
        return result;
    }
}