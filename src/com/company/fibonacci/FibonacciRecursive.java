package com.company.fibonacci;

import java.math.BigInteger;

/**
 * In mathematics, the Fibonacci numbers or Fibonacci series or Fibonacci sequence are the numbers in the following integer sequence:
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144...
 * By definition, the first two numbers in the Fibonacci sequence are 0 and 1,
 * and each subsequent number is the sum of the previous two. Below example shows how to create fibonacci series.
 */
public class FibonacciRecursive {

    public static void main(String a[]) {
        System.out.println("fibonacciRec_1: " + fibonacciRec_1(0, 15, BigInteger.ZERO, BigInteger.ONE, BigInteger.ZERO));
        System.out.println("fibonacciRec_1: " + fibonacciRec_1(0, 6222, BigInteger.ZERO, BigInteger.ONE, BigInteger.ZERO));

        System.out.println("fibonacciRec_2: " + fibonacciRec_2(15));
        System.out.println("fibonacciRec_2: " + fibonacciRec_2(6222));
    }

    public static BigInteger fibonacciRec_1(int call, int calls, BigInteger fib1, BigInteger fib2, BigInteger result) {
        if (call == calls)
            return result;
        if (call == 0) {
            return fibonacciRec_1(++call, calls, fib1, fib2, BigInteger.ZERO);
        } else if (call == 1) {
            return fibonacciRec_1(++call, calls, fib1, fib2, BigInteger.ONE);
        } else {
            BigInteger aux = fib1.add(fib2);
            fib1 = fib2;
            fib2 = aux;
        }
        return fibonacciRec_1(++call, calls, fib1, fib2, fib1.add(fib2));
    }

    public static BigInteger fibonacciRec_2(int val) {
        if (val == 0)
            return BigInteger.ZERO;
        if (val == 1)
            return BigInteger.ONE;
        else {
            return fibonacciRec_2(val - 2).add(fibonacciRec_2(val - 1));
        }
    }
}
