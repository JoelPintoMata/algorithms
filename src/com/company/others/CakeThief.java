package com.company.others;

import java.util.ArrayList;
import java.util.List;

/**
 * As in https://www.interviewcake.com/question/java/cake-thief
 */
public class CakeThief {

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
        for (int i = 0; i < capacity; i++) {
            for (int j = 0; j < capacity; j++) {
                for (int k = 0; k < capacity; k++) {
                    testMax(cakeTypes, bagType1, bagType2, bagType3, capacity);

                    bagType3.add(cakeTypes[2]);
                }
                bagType3 = new ArrayList<>();
                testMax(cakeTypes, bagType1, bagType2, bagType3, capacity);

                bagType2.add(cakeTypes[1]);
            }
            bagType2 = new ArrayList<>();
            testMax(cakeTypes, bagType1, bagType2, bagType3, capacity);

            bagType1.add(cakeTypes[0]);
        }
    }

    private static void testMax(CakeType[] cakeTypes, List<CakeType> bagType1, List<CakeType> bagType2, List<CakeType> bagType3, int capacity) {
        int currentValue = bagType1.size() * cakeTypes[0].value;
        currentValue = currentValue + bagType2.size() * cakeTypes[1].value;
        currentValue = currentValue + bagType3.size() * cakeTypes[2].value;

        int currentCapacity = bagType1.size() * cakeTypes[0].weight;
        currentCapacity = currentCapacity + bagType2.size() * cakeTypes[1].weight;
        currentCapacity = currentCapacity + bagType3.size() * cakeTypes[2].weight;

        if (currentCapacity > capacity)
            return;
        else {
            if (currentValue > maxValue) {
                maxValue = currentValue;

                maxBagType1 = new ArrayList<CakeType>();
                maxBagType2 = new ArrayList<CakeType>();
                maxBagType3 = new ArrayList<CakeType>();

                maxBagType1.addAll(bagType1);
                maxBagType2.addAll(bagType2);
                maxBagType3.addAll(bagType3);
            } else {
                return;
            }
        }
    }
}

class CakeType {

    int weight;
    int value;

    public CakeType(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}
