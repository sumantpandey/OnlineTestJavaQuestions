package com.sumant.arrays;

import java.util.Arrays;
/*
* find missing element in an array of sequential integer
*/
public class MissingElement {
    public static void main(String []args){
        int [] in = {1,2,4};
        System.out.println(solution(in));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int sumall = (A[A.length-1]*(A[A.length-1]+1))/2;
        int sumFirst = (A[0]-1)*A[0]/2;
        int diff = sumall - sumFirst - Arrays.stream(A).sum();
        return diff;
    }
}
