package com.company.others;

import java.util.ArrayList;
import java.util.List;


public class PrintXmasTreeDynamicCache {

    public static void main(String a[]) {
        getXmasTree(3).stream().forEach(System.out::println);
    }

    public static List<String> getXmasTree(int val) {
        List<String> cache = new ArrayList<>(val);
        cache.add("*");

        if (val == 1)
            return cache;

        for (int i = 1; i < val; i++) {
            cache.add(cache.get(i - 1).concat("*"));
        }
        return cache;
    }
}
