package com.interviewcake.Knapsack;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


/**
 * Check: https://www.interviewcake.com/question/java/cake-thief
 */
public class TheCakeThief {

    public static void main(String a[]){
        CakeType[] cakeTypes = new CakeType[] {
                new CakeType(7, 160),
                new CakeType(3, 90),
                new CakeType(2, 15),
        };

        int capacity = 20;

        maxDuffelBagValue(cakeTypes, capacity);
    }

    private static void maxDuffelBagValue(CakeType[] cakeTypes, int capacity) {
        Comparator<? super CakeType> cakeRatioComparator = new Comparator<CakeType>() {
            @Override
            public int compare(CakeType o1, CakeType o2) {
                return o1.ratio > o2.ratio ? -1 : 1;
            }
        };

        List<CakeType> cakeList = Arrays.stream(cakeTypes).sorted(cakeRatioComparator).collect(Collectors.toList());
        AtomicInteger currentCapacity = new AtomicInteger();
        List<CakeType> bag = new ArrayList<>();
        cakeList.forEach(cake -> {
            while(currentCapacity.get() + cake.weight <= capacity) {
                bag.add(cake);
                currentCapacity.set(currentCapacity.get() + cake.weight);
            }
        });
        bag.stream().forEach(System.out::println);
    }

    private static class CakeType {

        private final int weight;
        private final int value;
        private final int ratio;

        public CakeType(int weight, int value) {
            this.weight = weight;
            this.value  = value;
            this.ratio = value/weight;
        }

        @Override
        public String toString() {
            return "weight: " + this.weight + " value: " + this.value + " ratio: " + this.ratio;
        }
    }
}