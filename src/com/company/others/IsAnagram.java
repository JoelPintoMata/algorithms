package com.company.others;


/**
 * Checks if a work is anagram of another
 */
public class IsAnagram {

    public static void main(String[] args) {
        System.out.println("Is joel anagram of noel?: " + isAnagram("joel", "noel"));
        System.out.println("Is joel anagram of loje?: " + isAnagram("joel", "loje"));
        System.out.println("Is joel 'funeral' of 'real fun'?: " + isAnagram("funeral", "real fun"));
    }

    private static boolean isAnagram(String from, String to) {
        for (char c : to.toCharArray()) {
            if (c == ' ')
                continue;
            if (from.indexOf(c) < 0)
                return false;
        }
        return true;
    }
}
