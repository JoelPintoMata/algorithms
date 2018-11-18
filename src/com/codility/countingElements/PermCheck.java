package com.codility.countingElements;

import java.util.HashSet;
import java.util.Set;


/**
 * Check: https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
 *
 * 100% solution
 */
public class PermCheck {

    public static void main(String a[]){
        System.out.println(solution(new int[]{4, 1, 3, 2}));
        System.out.println(solution(new int[]{4, 1, 3}));
        System.out.println(solution(new int[]{4, 3, 2}));
        System.out.println(solution(new int[]{1, 3, 2}));
        System.out.println(solution(new int[]{1, 1}));
    }

    public static int solution(int[] A) {
//        perfectSet will contain all the values between 1 and A.length
        Set<Integer> perfectSet = new HashSet<>();
//        testedSet contains the values already tested, it allows checking for duplicate values in A
        Set<Integer> testedSet = new HashSet<>();

        for(int i=0; i<A.length; i++) {
            perfectSet.add(i+1);
        }
        for(int x:A) {
            if(testedSet.contains(x))
                return 0;
            if(!perfectSet.contains(x)) {
                return 0;
            }
            testedSet.add(x);
        }
        return 1;
    }
}