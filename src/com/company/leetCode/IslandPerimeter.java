package com.company.leetCode;

/**
 * 463. Island Perimeter: https://leetcode.com/problems/island-perimeter
 * <p>
 * Runtime: 10 ms, faster than 25.88% of Java online submissions for Island Perimeter.
 * Memory Usage: 58.8 MB, less than 97.92% of Java online submissions for Island Perimeter.
 */
public class IslandPerimeter {

    public static void main(String[] a) {
        IslandPerimeter twoSumII = new IslandPerimeter();
//        System.out.println(twoSumII.islandPerimeter(new int[][]{{0,1,0,0},
//                {1,1,1,0},
//                {0,1,0,0},
//                {1,1,0,0}
//        }));
//        System.out.println(twoSumII.islandPerimeter(new int[][]{{0,1,0,0}
//        }));
        System.out.println(twoSumII.islandPerimeter(new int[][]{{0}, {1}}));
    }

    public int islandPerimeter(int[][] grid) {
        int[] arr = findAOne(grid);
        if (arr[0] == -1 && arr[1] == -1) {
            return 0;
        } else {
            return helper(grid, arr[0], arr[1], new int[grid.length][grid[0].length]);
        }
    }

    private int helper(int[][] grid, int line, int column, int[][] visited) {
        int value = 0;
        if (line < 0 || line >= grid.length)
            return 1;
        if (column < 0 || column >= grid[0].length)
            return 1;
        if (grid[line][column] == 0)
            return 1;

        if (visited[line][column] == 1)
            return 0;
        else
            visited[line][column] = 1;

        return helper(grid, line - 1, column, visited)
                + helper(grid, line + 1, column, visited)
                + helper(grid, line, column - 1, visited)
                + helper(grid, line, column + 1, visited);
    }

    private int[] findAOne(int[][] grid) {
        for (int line = 0; line < grid.length; line++) {
            for (int column = 0; column < grid[line].length; column++) {
                if (grid[line][column] == 1) {
                    return new int[]{line, column};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
