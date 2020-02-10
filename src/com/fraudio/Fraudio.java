package com.fraudio;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Fraudio {

    /**
     * @param a
     */
    public static void main(String[] a) {
        Fraudio combinationSumIV = new Fraudio();
        List<Integer> list = Arrays.asList(4);
//        System.out.println(combinationSumIV.maxTickets(list));
        list = Arrays.asList(4, 5);
        System.out.println(combinationSumIV.maxTickets(list));
        list = Arrays.asList(4, 6);
        System.out.println(combinationSumIV.maxTickets(list));
        list = Arrays.asList(4, 13, 2, 3);
        System.out.println(combinationSumIV.maxTickets(list));
        list = Arrays.asList(5, 10, 12, 1, 10, 4);
        System.out.println(combinationSumIV.maxTickets(list));
    }

    public int maxTickets(List<Integer> tickets) {
        Collections.sort(tickets);
        int max = 1;
        int totalMax = 1;
        for (int i = 1; i < tickets.size(); i++) {
            if (tickets.get(i) - tickets.get(i - 1) > 1) {
                if (totalMax < max)
                    totalMax = max;
                max = 1;
            } else {
                max = max + 1;
            }
        }
        return totalMax > max ? totalMax : max;
    }
}