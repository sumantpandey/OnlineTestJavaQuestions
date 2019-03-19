package com.sumant.arrays;

import java.util.*;

public class FrogCrossingRiver {

    public static void main(String []args){

        int [] A = {1,3,1,4,2,3,5,4};
        int X = 5;
        System.out.println(solution(X, A));
    }

    public static int solution(int X, int[] A) {
        // write your code in Java SE 8
        Set set = new HashSet();
        List list = new ArrayList<>();
        Arrays.stream(A).forEach(i->{

           if(i==X && set.size()==X-1) {
               list.add(i);
           }
            else{ set.add(i);}

        });
        return (int)list.get(0);
    }
}
