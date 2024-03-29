package com.SlidingWindow;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class LongestSubStringWithoutRepeatingChar {
    public static void main(String[] args) {

        String str = "pwwkew";

        //expected ans is 3 "abc"

        optimalSolution(str);

    }

    public static void solution(String str){
        int max = 0;

        for(int i=0;i<str.length();i++){

            Set<Character> temp = new HashSet<>();
            for(int j=i;j<str.length();j++){

                temp.add(str.charAt(j));

            }

            max = Math.max(max, temp.size());

        }

        System.out.println(max);

    }

    public static void optimalSolution(String str){
        int left = 0, right = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();

        int l = 0;
        for(int r=0; r<str.length(); r++){

            if(set.contains(str.charAt(r))){

                while(l < r && set.contains(str.charAt(r))){
                    set.remove(str.charAt(l));
                    l++;
                }

            }

            set.add(str.charAt(r));
            max = Math.max(max, r-l+1);



        }

        System.out.println(max);

    }
}
