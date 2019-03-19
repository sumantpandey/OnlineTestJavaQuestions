package com.sumant.arrays;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MovingTotal {
    /**
     * Adds/appends list of integers at the end of internal list.
     */
    List linkedList = new LinkedList();
    public void append(int[] list) {
        for(Integer input : list){
            linkedList.add(input);
        }
    }

    /**
     * Returns boolean representing if any three consecutive integers in the
     * internal list have given total.
     */
    public boolean contains(int total) {
        if(linkedList.size()>=3){
            for (int i = 0; i <= linkedList.size() - 3; i++) {
                int sum = (Integer) linkedList.get(i) + (Integer) linkedList.get(i + 1) + (Integer) linkedList.get(i + 2);
                if(sum == total)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MovingTotal movingTotal = new MovingTotal();

        movingTotal.append(new int[] { 1, 2, 3 });

        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));

        movingTotal.append(new int[] { 4 });

        System.out.println(movingTotal.contains(9));
    }
}