package com.sumant.arrays;

import java.util.Arrays;

public class LongestPassword {

    public static void main(String [] args){
        System.out.println(solution("test 5 a0A pass007 ?xyl"));
    }
    public static int solution(String S){
      int len =  Arrays.stream(S.split(" "))
                .filter(s-> s.matches("^[?a-zA-Z0-9?]*$"))
                .filter(LongestPassword::countLetters)
                .filter(st -> oddDigitPresent(st))
                .sorted((firstStr, secondStr) -> firstStr.length() - secondStr.length())
                .findFirst()
                .orElse("")
                .length();
      if(len == 0)
          return -1;
        return len;
    }

    static boolean countLetters(String s){
     boolean flag = false;
     char [] chars = s.toCharArray();
     int letterCount = 0;
     for(char c : chars){
         if(Character.isLetter(c))
             letterCount++;
     }
     if(letterCount > 0 && letterCount % 2 == 0)
         flag = true;
     return flag;
    }

    static boolean oddDigitPresent(String s){

        boolean isOdd = false;
        char [] chars = s.toCharArray();
        for(char c : chars){
            if((Character.isDigit(c))&& Character.getNumericValue(c)% 2 != 0)
                isOdd = true;
        }
        return isOdd;
    }
}
