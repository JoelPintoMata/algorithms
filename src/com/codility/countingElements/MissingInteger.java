package com.codility.countingElements;


/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
 *
 * 100% solution
 */
public class MissingInteger {

    public static void main(String a[]){
        System.out.println(solution(new int[]{1, 3, 6, 4, 1, 2}));
        System.out.println(solution(new int[]{1, 2, 3}));
        System.out.println(solution(new int[]{-1, -3}));
        System.out.println(solution(new int[]{2}));
        System.out.println(solution(new int[]{0}));
    }

    public static int solution(int[] A) {
        int[] auxArray = new int[A.length];

        for(int i=0; i<A.length; i++) {
            if(A[i]-1 < 0)
                continue;
            if(A[i]-1 > A.length-1)
                continue;
            auxArray[A[i]-1] = 1;
        }

        for(int i=0; i<auxArray.length; i++) {
            if(auxArray[i] == 0)
                return i+1;
        }
        return auxArray.length + 1;
    }
}