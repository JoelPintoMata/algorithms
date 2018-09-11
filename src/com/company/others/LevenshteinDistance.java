package com.company.others;

import java.util.Arrays;


public class LevenshteinDistance {

    public static void main(String a[]) {
        String source = "joel";
        String destiny = "noel";
        System.out.println("L evenshtein distance is " + levenshteinDistance(source, destiny));
    }

    public static int levenshteinDistance(String source, String destiny) {
        if (source.length() == 0)
            return destiny.length();
        if (destiny.length() == 0)
            return source.length();

        int replace = levenshteinDistance(source.substring(1), destiny.substring(1))
                + replace(source.charAt(0), destiny.charAt(0));
        int delete = levenshteinDistance(source.substring(1), destiny)
                + 1;
        int insert = levenshteinDistance(source, destiny.substring(1))
                + 1;

        return min(replace, delete, insert);
    }

    public static int min(int... numbers) {
        return Arrays.stream(numbers)
                .min().orElse(Integer.MAX_VALUE);
    }

    private static int replace(char c1, char c2) {
        if (c1 == c2)
            return 0;
        return 1;
    }
}
