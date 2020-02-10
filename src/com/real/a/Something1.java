package com.real.a;

import java.util.*;

public class Something1 {

    Set<List<Integer>> solutions = new HashSet<>(0);

    public static void main(String[] a) {
        Something1 Something1 = new Something1();
        int val = 0;
        val = Something1.solution(new int[]{3, 8, 2, 3, 3, 2});
        System.out.println(val);
        val = Something1.solution(new int[]{7, 1, 2, 8, 2});
        System.out.println(val);
        val = Something1.solution(new int[]{3, 1, 4, 1, 5});
        System.out.println(val);
        val = Something1.solution(new int[]{5, 5, 5, 5, 5});
        System.out.println(val);
    }

    public int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>(A.length);
        if (A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return A[0];
        }
        int val = 0;
        int rep = 0;
        int thisRep = 0;
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                thisRep = map.get(A[i]) + 1;
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                thisRep = 1;
                map.put(A[i], 1);
            }
            if (thisRep > rep) {
                rep = thisRep;
                val = A[i];
                continue;
            }
            if (thisRep == rep && A[i] > val) {
                val = A[i];
                continue;
            }
        }
        return val == rep ? val : 0;
    }
}