package com.company.others;

public class main {

    public static void main(String [] args) {
        int[] A = new int[]{3, 8, 9, 7, 6};
        int[] A1 = solution(A, 3);

        A = new int[]{1, 2, 3, 4};
        A1 = solution(A, 4);

        A = new int[]{5, -1000};
        A1 = solution(A, 1);
    }

    public static int[] solution(int[] A, int K) {
        int[] B = new int[A.length];

        int index=0;
        for(int i = K; i<A.length; i++) {
            B[index] = A[i];
            index++;
        }
        index=K;
        if(K>=A.length)
            index=0;
        for(int i=0; i<K; i++) {
            B[index] = A[i];
            index++;
            if(index>=A.length)
                index=0;
        }
        return B;
    }
}
