package com.company.sort.quicksort;

public class Quicksort2 {

    public static void main(String a[]) {
        int num[] = {34, 5, 78, 2, 45, 1, 99, 23};

        sort(num, 0, num.length - 1);
        sort(num, 0, num.length - 2);
    }

    private static void sort(int[] num, int min, int max) {
        int pivot = (max - min) / 2;
        int pivotValue = num[pivot];

        int i = min;
        int j = max;
        while (i <= j) {
            while (num[i] < pivotValue) {
                i++;
            }
            while (num[j] > pivotValue) {
                j--;
            }
            int aux = num[i];
            num[i] = num[j];
            num[j] = aux;
            i++;
            j--;
        }
        sort(num, min, i);
        sort(num, i, max);
    }
}
