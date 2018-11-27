package com.codility.fibonacci;


import java.util.PriorityQueue;
import java.util.Queue;


/**
 * Check: https://app.codility.com/programmers/lessons/2-arrays/
 *
 * 100% solution
 */
public class FibFrog {

    private static int jumps = 0;
    private static Queue queue = new PriorityQueue();

    public static void main(String a[]){
        System.out.println(solution(new int[]{0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0}));
    }

    public static int solution(int[] A) {
        solutionAux(A);
        jumps++;
        return jumps;
    }

    public static void solutionAux(int[] A) {
        if(A.length == 0)
            return;

        for(int i=0; i<A.length-1; i++) {
            if(A[i]==0 && queue.isEmpty()) {
                continue;
            }
            if(A[i]==0 && !queue.isEmpty()) {
                System.out.println("jump to " + queue.poll());
                ++jumps;
                queue.clear();
                continue;
            }
//            we reach the other side of the river
            if(i==0) {
                System.out.println("jump to " + i);
                ++jumps;
                return;
            }
//            lets skip these ones
            if(A[i]==1) {
                queue.add(i);
                continue;
            }
            if(fib(A[i]) < A.length) {
                System.out.println("jump to " + i);
                ++jumps;
                if(i==0)
                    return;
            }
        }
        return;
    }

    private static int fib(int fib) {
        if(fib==0)
            return 0;
        if(fib==1)
            return 1;
        return fib(fib-1) + fib(fib+1);
    }
}