package com.company.sort.quicksort;

import java.util.Arrays;

public class QuickSort {
    
    public static void main(String a[]){
        int num[] = {34,5,78,2,45,1,99,23};

        sort(num);

        Arrays.stream(num).forEach(x -> System.out.println(x));
    }

    private static void sort(int[] num) {
        boolean swaped = false;
        for(int i=1; i<num.length; i++) {
            if(num[i] < num [i-1]) {
                swap(num, i, i - 1);
                swaped = true;
            }
        }
        if(swaped)
            sort(num);
    }

    private static void swap(int[] num, int i, int i1) {
        int aux = num[i1];
        num[i1] = num[i];
        num[i] = aux;
    }
}
