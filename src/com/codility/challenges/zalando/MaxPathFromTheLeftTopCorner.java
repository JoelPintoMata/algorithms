package com.codility.challenges.zalando;


import java.util.Stack;
import java.util.stream.Collectors;

/**
 * FrogJmp: https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/start/
 * <p>
 * Detected time complexity: O(2**(N+M)) or O(N*M*(N+M))
 */
public class MaxPathFromTheLeftTopCorner {

    int maxTotal = 0;
    Stack<Integer> maxStack = new Stack();

    public static void main(String[] a) {
        MaxPathFromTheLeftTopCorner solution = new MaxPathFromTheLeftTopCorner();
        System.out.println(solution.solution(new int[][]{{9, 9, 7}, {9, 7, 2}, {6, 9, 5}, {9, 1, 2}}));
    }

    public String solution(int[][] A) {
        if (A.length == 0 && A[0].length == 0)
            return "";
        helper(A, 0, 0, new Stack(), 0, new int[A.length][A[0].length]);
        return maxStack.stream().map(x -> x.toString()).collect(Collectors.joining());
    }

    public int helper(int[][] A, int x, int y, Stack stackAux, int total, int[][] visited) {
        if (x > A[0].length - 1)
            return total;
        if (y > A.length - 1)
            return total;

        stackAux.push(A[y][x]);
        total = total + A[y][x];
        if (x == A[0].length - 1 && y == A.length - 1) {
            if (total > maxTotal) {
                maxTotal = total;
                maxStack.clear();
                maxStack.addAll(stackAux);
            }
        }
        if (visited[y][x] == 1)
            return total;
        else
            visited[y][x] = 1;
        int max1 = helper(A, x + 1, y, stackAux, total, visited);
        int max4 = helper(A, x, y + 1, stackAux, total, visited);
        stackAux.pop();
        visited[y][x] = 0;

        return Math.max(max1, max4);
    }
}