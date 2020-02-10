package com.company.real.f;

public class FraudioReachingPoints {

    int[][] arr = new int[1001][1001];

    /**
     * @param a
     */
    public static void main(String[] a) {
        FraudioReachingPoints combinationSumIV = new FraudioReachingPoints();
        System.out.println(combinationSumIV.canReach(1, 1, 5, 2));
    }

    public String canReach(int x1, int y1, int x2, int y2) {
        if (x1 > 1000) {
            return "No";
        }
        if (y1 > 1000) {
            return "No";
        }
        if (arr[x1][y1] > 0) {
            return "No";
        }
        if (x1 == x2 && y1 == y2) {
            return "Yes";
        } else {
            arr[x1][y1] = 1;
            return canReach(x1 + y1, y1, x2, y2).equals("Yes")
                    || canReach(x1, x1 + y1, x2, y2).equals("Yes")
                    ? "Yes"
                    : "No";
        }
    }
}