/*
package com.amazonia;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Something3 {

    Set<List<Integer>> solutions = new HashSet<>(0);

    public static void main(String[] a) {
        Something3 Something1 = new Something3();
        int val = 0;
        val = Something1.solution(new int []{0, 9, 0, 2, 6, 8, 0, 8, 3, 0});
        System.out.println(val);
    }

    public int solution(int[] A) {
        int[][] arr = new int[A.length][A.length];
        for(int i=0; i<A.length; i++) {
            if (A[i] == 0) {
                arr[0][i] = 1;
            }
        }
        for(int i=1; i<A.length; i++) {
            if (A[i] > 0) {
                arr[i][A[i]] = 1;
            }
        }
        for(int i=0; i<A.length; i++) {
            for(int i=0; i<A.length; i++) {

            }
            stack.push(i);
            helper(i, stack, A);
        }
    }

    private void helper(int root, Stack<Integer> stack, int[] A) {

        for(int i=1; i<A.length; i++) {
            if(root == 0 && A[i] == 0) {
                stack.push(i);
            } else {
                if()
            }
        }
    }
}*/
