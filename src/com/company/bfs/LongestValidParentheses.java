package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * In mathematics, the Fibonacci numbers or Fibonacci series or Fibonacci sequence are the numbers in the following integer sequence:
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144...
 * By definition, the first two numbers in the Fibonacci sequence are 0 and 1,
 * and each subsequent number is the sum of the previous two. Below example shows how to create fibonacci series.
 */
public class LongestValidParentheses {
    static int fib1 = 0;
    static int fib2 = 1;

    static Queue<Character> queue = new PriorityQueue<>();
    static int count = 0;
    
    public static void main(String a[]){
        String input = ")()";
        findLongestValidParentheses(input);
        System.out.println(count);

        count = 0;
        input = ")()())";
        findLongestValidParentheses(input);
        System.out.println(count);

        count = 0;
        input = ")(()(((()())()(";
        findLongestValidParentheses(input);
        System.out.println(count);
    }

    private static void findLongestValidParentheses(String input) {
        char[] charArray = input.toCharArray();
        for(int i=0; i<charArray.length; i++) {
            if(charArray[i] == ')') {
                if (queue.peek() == null && charArray[i] == ')') {
                    continue;
                }
                if (queue.peek() != null && queue.peek() == '(') {
                    count = count + 2;
                    queue.remove();
                } else {
                    queue.add(charArray[i]);
                }
            }
            if(charArray[i] == '(')
                queue.add(charArray[i]);
        }
    }
}
