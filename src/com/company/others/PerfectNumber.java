package com.company.others;


public class PerfectNumber {
    
    public static void main(String a[]) {
        System.out.println("Is perfect number: "+isPerfectNumber(6));
        System.out.println("Is perfect number: "+isPerfectNumber( 23));
        System.out.println("Is perfect number: "+isPerfectNumber( 28));
    }

    private static boolean isPerfectNumber(int i) {
        boolean result = false;
        int total = 0;

        for(int j=1; j<=i/2; j++) {
            if(i%j == 0)
                total = total + j;
        }
        if(total == i)
            result = true;
        return result;
    }
}
