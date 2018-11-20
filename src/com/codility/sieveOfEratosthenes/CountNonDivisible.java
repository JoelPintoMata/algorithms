package com.codility.sieveOfEratosthenes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


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
        Map<Integer, Integer> cache = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if (cache.get(A[i]) != null && cache.get(A[i]) > 0) {
                result[i] = cache.get(A[i]);
                continue;
            }
            for (int j = 0; j < A.length; j++) {
                if (A[i] % A[j] > 0) {
                    result[i]++;
                }
            }
            cache.put(A[i], result[i]);
        }
        return result;
    }
}