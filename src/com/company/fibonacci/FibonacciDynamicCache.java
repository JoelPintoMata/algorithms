package com.company.fibonacci;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * In mathematics, the Fibonacci numbers or Fibonacci series or Fibonacci sequence are the numbers in the following integer sequence:
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144...
 * By definition, the first two numbers in the Fibonacci sequence are 0 and 1,
 * and each subsequent number is the sum of the previous two. Below example shows how to create fibonacci series.
 */
public class FibonacciDynamicCache {

    public static void main(String a[]) {
//        fibonacci works for small numbers
        System.out.println("fibonacci: " + fibonacci(0));
        System.out.println("fibonacci: " + fibonacci(1));
        System.out.println("fibonacci: " + fibonacci(15));
//        fibonacci 48 overflows, see the negative value returned?
        System.out.println("fibonacci: " + fibonacci(49));
    }

    public static BigInteger fibonacci(int val) {
        List<BigInteger> cache = new ArrayList<>(val);
        cache.add(BigInteger.ZERO);
        if (val == 0)
            return cache.get(val);

        cache.add(BigInteger.ONE);
        if (val == 1)
            return cache.get(val);

        for (int i = 2; i <= val; i++) {
            BigInteger aux = cache.get(i - 2).add(cache.get(i - 1));
            cache.add(aux);
        }
        return cache.get(val);
    }
}
