package com.javacodegeeks;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ArraySum {

    public static void main(String [] args)
    {
        int [] ia = new int[]{1,2,4,7,3,5,8,2,5};
        int size = 9;
        int [] finalResult = arraySum(ia,9);
        IntStream.of(finalResult).forEach(i->{
            System.out.println(i);
        });
    }
    static int[] arraySum(int [] in, int size)
    {
        int[] res=new int [9];
        int sum = IntStream.of(in).sum();
        for(int i=0;i<9;i++)
        {
           res[i] = sum-in[i];
        }
        return res;

    }
}
