package com.company.others;

import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {
        int[] intArray = new int[]{1, 2, 4, 5, 6};

        System.out.println(missingNumber(intArray));
    }

    private static int missingNumber(int[] intArray) {
        int sum = Arrays.stream(intArray).sum();
        int lastValue = intArray[intArray.length - 1];
        return (lastValue * (lastValue + 1) / 2) - sum;
    }
}