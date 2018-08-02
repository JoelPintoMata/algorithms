package com.company;


public class FindMiddleIndexWhereSumIsEqual {

    public static void main(String[] args) {
        int[] num = { 2, 4, 4, 5, 4, 1 };
        try {
            System.out.println("Starting from index 0, adding numbers till index "
                    + findMiddleIndex(num) + " and");
            System.out.println("adding rest of the numbers can be equal");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static int findMiddleIndex(int[] num) {
        int[] original = num.clone();
        int[] leftToRight = sumLeftToRight(num);
        num = original.clone();
        int[] rightToLeft = sumRightToLeft(num);


        for(int i=0; i<leftToRight.length-1; i++) {
            if(leftToRight[i] == rightToLeft[i+1])
                return i;
        }
        return -1;
    }

    private static int[] sumLeftToRight(int[] num) {
        for(int i=0; i<num.length; i++) {
            if(i==0)
                num[0] = num[0];
            else
                num[i] = num[i] + num[i-1];
        }
        return num;
    }

    private static int[] sumRightToLeft(int[] num) {
        for(int i=num.length-1; i>=0; i--) {
            if(i==num.length-1)
                num[num.length-1] = num[num.length-1];
            else
                num[i] = num[i] + num[i+1];
        }
        return num;
    }
}
