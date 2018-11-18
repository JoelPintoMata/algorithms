package com.codility.countingElements;

import java.util.HashSet;
import java.util.Set;


/**
 * Check: https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
 *
 * 100% solution
 */
public class FrogRiverOne {

    public static void main(String a[]){
        System.out.println(solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
    }

    public static int solution(int X, int[] A) {
//        testedSet contains the values already tested
        Set<Integer> testedSet = new HashSet<>();
        for(int i=0; i<A.length; i++) {
            testedSet.add(A[i]);
            if(testedSet.size() == X)
                return 0;
        }
        return -1;
    }
}