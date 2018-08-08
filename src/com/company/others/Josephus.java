package com.company.others;

import java.util.ArrayList;
import java.util.List;


/**
 * see https://rosettacode.org/wiki/Josephus_problem
 */
public class Josephus {

    public static void main(String a[]) {
        System.out.println("josephus: " + josephus(5, 2));
    }

    public static int josephus(int val, int jump) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < val; i++) {
            list.add(i);
        }

        int indexToRemove;
        int indexCurrent = 0;
        while (list.size() > 1) {
            if (jump + indexCurrent <= list.size()) {
                indexToRemove = jump + indexCurrent - 1;
            } else {
                indexToRemove = jump - list.size() + indexCurrent;
            }
//            list is 0 index based
            indexToRemove = indexToRemove - 1;
            System.out.println("Prisoner " + list.get(indexToRemove) + " killed.");
            list.remove(indexToRemove);

            indexCurrent = indexToRemove;
        }
        return list.get(0);
    }
}
