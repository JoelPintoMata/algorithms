package com.codility.fibonacci;

import java.util.Arrays;


/**
 * Check: https://app.codility.com/programmers/lessons/2-arrays/
 *
 * 100% solution
 */
public class FibFrog {

    public static void main(String a[]){
        System.out.println(solution(new int[]{0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0}));
    }

    public static int[] solution(int[] A) {
        int [] rotatedA = new int[A.length];

        for(int i=0; i<A.length; i++) {
            //rotated index needs to "wrap" around end of array
            //the mode operator gives us just that 15 mod 10 == 5
            int rotatedIndex = (i + K) % A.length;

            rotatedA[rotatedIndex] = A[i];
        }
        return rotatedA;
    }
}
