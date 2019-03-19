package com.sumant.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.summingDouble;

//A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element
// of the array can be paired with another element that has the same value, except for one element that is left unpaired
public class UnpairedElement {

    public static void main(String []args){
        int []in = {1,3,2,4,3,2,1};
        System.out.println(findUnpairedElement(in));
        System.out.println(IntStream.of(in).boxed().collect(summingDouble(x->x)));
        List arrlist = new ArrayList();

        // populate the list
        arrlist.add("A");
        arrlist.add("B");
        arrlist.add("C");
        arrlist.add("C");
        arrlist.add("C");

    }

     static int findUnpairedElement(int [] in){
        int unpaired = Arrays.stream(in).distinct().boxed().collect(Collectors
                .groupingBy(c->c,Collectors.counting())).entrySet().stream()
                .filter(p->p.getValue()==1).findAny().get().getKey();
        return unpaired;
    }
}
