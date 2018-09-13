package com.company.fibonacci;

import java.math.BigInteger;

/**
 * In mathematics, the Fibonacci numbers or Fibonacci series or Fibonacci sequence are the numbers in the following integer sequence:
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144...
 * By definition, the first two numbers in the Fibonacci sequence are 0 and 1,
 * and each subsequent number is the sum of the previous two. Below example shows how to create fibonacci series.
 */
public class Fibonacci {

    public static void main(String a[]){
//        fibonacci works for small numbers
        System.out.println("fibonacci: " + fibonacci(0));
        System.out.println("fibonacci: " + fibonacci(1));
        System.out.println("fibonacci: " + fibonacci(15));
//        fibonacci 48 overflows, see the negative value returned?
        System.out.println("fibonacci: " + fibonacci(49));
//        replace ints with BigIntegers
        System.out.println("fibonacciBigInteger: " + fibonacciBigInteger(6222));
    }

    public static int fibonacci(int val) {
        int fib1 = 0;
        int fib2 = 1;
        for (int i = 0; i <= val; i++) {
            if (i == 0) {
                continue;
            }
            if (i == 1) {
                continue;
            }
            int aux = fib1 + fib2;
            fib1 = fib2;
            fib2 = aux;
        }
        return fib2;
    }

    public static BigInteger fibonacciBigInteger(int val) {
        BigInteger fib1 = BigInteger.ZERO;
        BigInteger fib2 = BigInteger.ONE;
        for (int i = 0; i <= val; i++) {
            if (i == 0) {
                continue;
            }
            if (i == 1) {
                continue;
            }
            BigInteger aux = fib1.add(fib2);
            fib1 = fib2;
            fib2 = aux;
        }
        return fib2;
    }
}
