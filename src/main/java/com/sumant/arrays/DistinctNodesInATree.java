package com.sumant.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
/*
* Find maximum number of unique nodes in a path in binary tree
*
**/
public class DistinctNodesInATree {

    static class Tree{
        Tree left;
        Tree right;
        int data;
        Tree(int data){
            this.data = data;
        }
    }
    public static int solution(Tree T) {
        // write your code in Java SE 8
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        return findMaxDistinctNodes(T, map);
    }

    static int findMaxDistinctNodes(Tree T, Map map){
      if(T == null)
          return map.size();
        int sizePrev = map.size();
        map.put(T.data, 1);
        int l =findMaxDistinctNodes(T.left,map);
        int r =findMaxDistinctNodes(T.right,map);
        int sizeAfter = map.size();
        if(sizeAfter - sizePrev > 0){
            map.remove(T.data);
        }
        else{}
      return Math.max(l,r);
    }

    public static void main(String[]args){

        Tree t1 = new Tree(4);
        t1.left = new Tree(5);
        t1.right = new Tree(6);
        t1.left.left = new Tree(4);
        t1.left.left.left = new Tree(5);
        t1.right.left = new Tree(1);
        t1.right.right = new Tree(6);
        System.out.println(solution(t1));


    }
}
