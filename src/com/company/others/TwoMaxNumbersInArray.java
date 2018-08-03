package com.company.others;

import java.util.Arrays;


public class TwoMaxNumbersInArray {
    static int max1 = 0;
    static int max2 = 0;
    
    public static void main(String a[]){
        int num[] = {5,34,78,2,45,1,99,23};
        printTwoMaxNumbers(num);
        System.out.println(max1);
        System.out.println(max2);
    }

    private static void printTwoMaxNumbers(int[] num) {
        Arrays.stream(num).forEach(x -> {
            if(x>max1) {
                max2 = max1;
                max1 = x;
            }
        });
    }
}
