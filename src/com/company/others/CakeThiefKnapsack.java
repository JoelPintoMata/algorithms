package com.company.others;

import java.util.ArrayList;
import java.util.List;

/**
 * As in https://www.interviewcake.com/question/java/cake-thief
 * <p>
 * See http://www.wikiwand.com/en/Knapsack_problem
 */
public class CakeThiefKnapsack {

    static List<CakeType> bagType1 = new ArrayList<CakeType>();
    static List<CakeType> bagType2 = new ArrayList<CakeType>();
    static List<CakeType> bagType3 = new ArrayList<CakeType>();

    static List<CakeType> maxBagType1 = new ArrayList<CakeType>();
    static List<CakeType> maxBagType2 = new ArrayList<CakeType>();
    static List<CakeType> maxBagType3 = new ArrayList<CakeType>();

    static int maxValue = 0;

    public static void main(String[] args) {
        CakeType[] cakeTypes = new CakeType[]{
                new CakeType(7, 160),
                new CakeType(3, 90),
                new CakeType(2, 15),
        };

        int capacity = 20;

        maxDuffelBagValue(cakeTypes, capacity);
        System.out.println(maxValue);
        // returns 555 (6 of the middle type of cake and 1 of the last type of cake)
    }

    private static void maxDuffelBagValue(CakeType[] cakeTypes, int capacity) {
    }

    static class CakeType {

        int weight;
        int value;

        public CakeType(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
