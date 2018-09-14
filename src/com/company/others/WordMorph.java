package com.company.others;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class WordMorph {

    private static int min = 0;

    public static void main(String[] args) {
        String[] vocabulary = new String[]{"break", "bread", "tread", "trend", "breat"};

        min = 0;
        distanceBetween("trend", "break", vocabulary);
        System.out.println("Distance between trend and break is: " + min);

        min = 0;
        distanceBetween("break", "breat", vocabulary);
        System.out.println("Distance between break and breat is: " + min);
    }

    private static int distanceBetween(String from, String to, String[] vocabulary) {
        Stack<String> stack = new Stack<>();
        stack.push(from);
        return distanceBetweenAux(from, to, vocabulary, stack, 0);
    }

    private static int distanceBetweenAux(String from, String to, String[] vocabulary, Stack<String> stack, int count) {
        count++;
        String localFrom = stack.pop();
//        remove current word from the available vocabulary
        vocabulary = Arrays.stream(vocabulary).filter(x -> !x.equals(from)).collect(Collectors.toList()).toArray(new String[0]);
//        get all possible distance one words
        List<String> distanceOneFromResultList = distanceOneFrom(localFrom, vocabulary);

        for (String str : distanceOneFromResultList) {
            if (str.equals(to)) {
                if (min == 0 || min > count) {
                    min = count;
                }
                return count;
            } else {
                stack.push(str);
                distanceBetweenAux(str, to, vocabulary, stack, count);
            }
        }
        return -1;
    }

    private static List<String> distanceOneFrom(String from, String[] vocabulary) {
        List<String> thisVocabulary = Arrays.stream(vocabulary).filter(x -> !x.equals(from)).collect(Collectors.toList());
        return thisVocabulary.stream().map(x -> {
            char[] xCharArray = x.toCharArray();
            char[] fromCharArray = from.toCharArray();
            int count = 0;
            for (int i = 0; i < xCharArray.length; i++) {
                if (xCharArray[i] != fromCharArray[i]) {
                    count++;
                }
            }
            if (count == 1) {
                return x;
            } else {
                return "";
            }
        }).filter(x -> !x.isEmpty()).collect(Collectors.toList());
    }
}
