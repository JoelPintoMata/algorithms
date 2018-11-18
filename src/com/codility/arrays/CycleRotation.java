package com.codility.arrays;

import java.util.Arrays;


/**
 * Check: https://app.codility.com/programmers/lessons/2-arrays/
 */
public class CycleRotation {

    public static void main(String a[]){
        System.out.println("CycleRotation: ");
        Arrays.stream(cycleRotation(new int[]{3, 8, 9, 7, 6}, 3)).forEach(x->System.out.println(x));
        System.out.println("CycleRotation: ");
        Arrays.stream(cycleRotation(new int[]{1, 2, 3, 4}, 4)).forEach(x->System.out.println(x));
    }

    public static int[] cycleRotation(int[] A, int K) {
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
