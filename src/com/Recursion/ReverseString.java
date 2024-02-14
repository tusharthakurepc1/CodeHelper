package com.Recursion;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        String str = "hello";
        System.out.println(str);
        System.out.println(reverseT2(str, str.length()-1));



    }


    public static String reverseT2(String str, int ind){
        if (ind == 0) {
            return ""+str.charAt(ind);
        }

        return str.charAt(ind) + reverseT2(str, ind-1);
    }
}
