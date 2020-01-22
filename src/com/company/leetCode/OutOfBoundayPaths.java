package com.company.leetCode;

/**
 * 576. Out of Boundary Paths: https://leetcode.com/problems/out-of-boundary-paths/
 */
public class OutOfBoundayPaths {

    public static void main(String[] a) {
        OutOfBoundayPaths combinationSumIV = new OutOfBoundayPaths();
//        System.out.println(combinationSumIV.findPaths(2, 2, 2, 0, 0));
//        System.out.println(combinationSumIV.findPaths(1, 3, 3, 0, 1));
        System.out.println(combinationSumIV.findPaths(8, 50, 23, 5, 26));
    }

    public int findPaths(int m, int n, int N, int i, int j) {
        int[][] array = new int[m][n];
        int[][][] visited = new int[m][n][N + 1];
        return helper(array, visited, N, i, j);
    }

    public int helper(int[][] array, int[][][] visited, int moves, int line, int column) {
        if (moves < 0)
            return 0;
        if (line < 0 || line > array.length - 1 || column < 0 || column > array[0].length - 1)
            return 1;
        int cache = visited[line][column][moves];
        if (cache != 0)
            return cache;

        int total = ((helper(array, visited, moves - 1, line + 1, column) +
                helper(array, visited, moves - 1, line - 1, column)) % 1000000007 +
                (helper(array, visited, moves - 1, line, column + 1) +
                        helper(array, visited, moves - 1, line, column - 1)) % 1000000007) % 1000000007;
        visited[line][column][moves] = total;
        return total;
    }
}