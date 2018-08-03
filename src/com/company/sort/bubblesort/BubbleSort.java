package com.company.sort.bubblesort;

import java.util.Arrays;

public class BubbleSort {
    
    public static void main(String a[]){
        int num[] = {34,5,78,2,45,1,99,23};

        sort(num, 0, num.length-1);

        Arrays.stream(num).forEach(x -> System.out.println(x));
    }

    private static void sort(int[] num, int min, int max) {
        int pivot = num[min+(max-min)/2];

        int i = min;
        int j = max;
        while(i<=j) {
            while (num[i] < pivot) {
                i++;
            }
            while (num[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(num, i, j);
                i++;
                j--;
            }
        }
        if(min < j)
            sort(num, min, j);
        if(i < max)
            sort(num, i, max);
    }

    private static void swap(int[] num, int i, int i1) {
        int aux = num[i1];
        num[i1] = num[i];
        num[i] = aux;
    }
}
