package com.techiedelight.recursion;


import java.util.Arrays;

/**
 * Check: https://www.techiedelight.com/find-shortest-path-in-maze/
 */
public class ShortestPath {

    private static int min;

    public static void main(String a[]) {
        int mat[][] = {
                {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
                {0, 0, 1, 0, 1, 1, 1, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 1, 1, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                {0, 0, 1, 0, 0, 1, 1, 0, 0, 1},
        };

        int[][] visited = new int[mat.length][mat[0].length];
        min = -1;
        shortestPath(0, 0, 7, 5, mat, visited);
        System.out.println(min);

        visited = new int[mat.length][mat[0].length];
        min = -1;
        shortestPath(5, 4, 7, 5, mat, visited);
        System.out.println(min);

        visited = new int[mat.length][mat[0].length];
        min = -1;
        shortestPath(2, 2, 4, 3, mat, visited);
        System.out.println(min);
    }

    private static void shortestPath(int x1, int y1, int x2, int y2, int[][] mat, int[][] visited) {
        shortestPathAux(x1, y1, x2, y2, mat, visited, 0);
    }

    private static int shortestPathAux(int x1, int y1, int x2, int y2, int[][] mat, int[][] visited, int length) {
        if (x1 == x2 && y1 == y2)
            return length;

        int[] arr = new int[4];
        if (x1 - 1 > 0 && mat[y1][x1 - 1] == 1 && visited[y1][x1 - 1] == 0) {
            visited[y1][x1 - 1] = 1;
            arr[0] = shortestPathAux(x1 - 1, y1, x2, y2, mat, visited, ++length);
//            remove the visited square to allow back tracking
            visited[y1][x1 - 1] = 0;
            --length;
        }
        if (x1 + 1 < mat[0].length - 1 && mat[y1][x1 + 1] == 1 && visited[y1][x1 + 1] == 0) {
            visited[y1][x1 + 1] = 1;
            arr[1] = shortestPathAux(x1 + 1, y1, x2, y2, mat, visited, ++length);
//            remove the visited square to allow back tracking
            visited[y1][x1 + 1] = 0;
            --length;
        }
        if (y1 - 1 > 0 && mat[y1 - 1][x1] == 1 && visited[y1 - 1][x1] == 0) {
            visited[y1 - 1][x1] = 1;
            arr[2] = shortestPathAux(x1, y1 - 1, x2, y2, mat, visited, ++length);
//            remove the visited square to allow back tracking
            visited[y1 - 1][x1] = 0;
            --length;
        }
        if (y1 + 1 < mat[0].length - 1 && mat[y1 + 1][x1] == 1 && visited[y1 + 1][x1] == 0) {
            visited[y1 + 1][x1] = 1;
            arr[3] = shortestPathAux(x1, y1 + 1, x2, y2, mat, visited, ++length);
//            remove the visited square to allow back tracking
            visited[y1 + 1][x1] = 0;
            --length;
        }

        int minAux = -1;
        arr = Arrays.stream(arr).filter(x -> x > 0).toArray();
        if (arr.length > 0) {
            minAux = Arrays.stream(arr).min().getAsInt();
            if (min == -1)
                min = minAux;
            else {
                if (minAux < min) {
                    min = minAux;
                }
            }
        }
        return minAux;
    }
}
