package com.company.graph;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class WordMorph {

    public static void main(String[] args) {
        String[] vocabulary = new String[]{"break", "bread", "tread", "trend"};
        System.out.println("Distance between break and tread is: " + distanceBetween("trend", "bread", vocabulary));
    }

    private static int distanceBetween(String from, String to, String[] vocabulary) {
        Stack<String> stack = new Stack<>();
        stack.push(from);
        return distanceBetweenAux(from, to, vocabulary, stack, 1);
    }

    private static int distanceBetweenAux(String from, String to, String[] vocabulary, Stack<String> stack, int count) {
        count++;
        String localFrom = stack.pop();
        vocabulary = Arrays.stream(vocabulary).filter(x -> !x.equals(from)).collect(Collectors.toList()).toArray(new String[0]);

        List<String> distanceOneFromResult = distanceOneFrom(localFrom, vocabulary);
        for (int i = 0; i < distanceOneFromResult.size(); i++) {
            String aux = distanceOneFromResult.get(i);
            if (aux.equals(to)) {
                return count;
            } else {
                stack.push(aux);

                int result = distanceBetweenAux(aux, to, vocabulary, stack, count);
                if (result > -1)
                    return result;
                else {
                    stack.pop();
                }
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
