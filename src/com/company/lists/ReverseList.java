package com.company.lists;

import java.util.ArrayList;
import java.util.List;


public class ReverseList {

    public static void main(String[] args) {
        List<Integer> sl = new ArrayList<>();
        sl.add(3);
        sl.add(32);
        sl.add(54);
        sl.add(89);

        System.out.println("original");
        sl.stream().forEach(x->System.out.println(x));

        System.out.println("reversed");
        reverse(sl).stream().forEach(x->System.out.println(x));
    }

    private static List<Integer> reverse(List<Integer> sl) {
        if(sl.size() == 1) {
            return sl;
        } else {
            Integer x = sl.get(0);
            List<Integer> result = reverse(sl.subList(1, sl.size()));
            result.add(x);
            return result;
        }
    }
}
