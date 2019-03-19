package com.sumant.arrays;

import java.util.Arrays;
//rotate array
public class RotateArray {

    public static void main(String[] args)
    {
        int [] input = {1,2,3,4,5};
        input = rotate(input, 3);
        Arrays.stream(input).forEach(i-> System.out.println(i));
    }
    static int[] rotate(int [] in, int rotationCounter){
        int[] result = new int[in.length];
        for (int i=0; i< in.length; i++){
            int rotation = i + rotationCounter;
            if(rotation > in.length-1){
                rotation = rotation - in.length;}
            result[rotation] = in[i];
        }
        return result;
    }
}
