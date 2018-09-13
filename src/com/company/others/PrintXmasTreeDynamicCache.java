package com.company.others;

import java.util.ArrayList;
import java.util.List;


public class PrintXmasTreeDynamicCache {

    public static void main(String a[]) {
        getXmasTree(5).stream().forEach(System.out::println);
    }

    public static List<String> getXmasTree(int val) {
        List<String> cache = new ArrayList<>(val);

//        calculate the biggest possible indentation at the root
        String indentation = new String();
        for (int i = 0; i < val - 1; i++) {
            indentation = indentation.concat(" ");
        }

        cache.add("*");
        if (val == 1)
            return cache;

        for (int i = 1; i < val; i++) {
            cache.add(cache.get(i - 1).concat("**"));
            cache.set(i - 1, indentation.concat(cache.get(i - 1)));

            indentation = indentation.substring(0, indentation.length() - 1);
        }
        return cache;
    }
}
