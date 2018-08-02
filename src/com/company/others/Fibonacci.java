package com.company.others;

/**
 * In mathematics, the Fibonacci numbers or Fibonacci series or Fibonacci sequence are the numbers in the following integer sequence:
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144...
 * By definition, the first two numbers in the Fibonacci sequence are 0 and 1,
 * and each subsequent number is the sum of the previous two. Below example shows how to create fibonacci series.
 */
public class Fibonacci {
    static int fib1 = 0;
    static int fib2 = 1;
    
    public static void main(String a[]){
        System.out.println(fib1);
        for(int i=0; i<15; i++) {
            System.out.println(fib2);
            int aux = fib1 + fib2;
            fib1 = fib2;
            fib2 = aux;
        }
    }
}
