package com.codility.timeComplexity;


/**
 * FrogJmp: https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/start/
 * <p>
 * 100% solution
 */
public class FrogJmp {

    public static void main(String[] a) {
        FrogJmp solution = new FrogJmp();
        System.out.println(solution.solution(1, 5, 2));
    }

    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        int result = (Y - X) / D;
        if (result * D + X >= Y)
            return result;
        return result + 1;
    }
}