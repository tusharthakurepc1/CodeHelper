package com.SlidingWindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class LongestSubStringWithoutRepeatingChar {
    public static void main(String[] args) {

        String str = "cddbzabcd";


        bruteForce(str);
        optimalSolution(str);


    }

    //Time complexity: O(n)
    //Space complexity: O(170)  constant
    public static void optimalSolution(String str){

        int left = 0;
        int hash_arr[] = new int[170];
        Arrays.fill(hash_arr, -1);
        int maxi = 0;

        for(int right=0; right<str.length(); right++){

            if(hash_arr[(int)str.charAt(right)] == -1){
                hash_arr[(int)str.charAt(right)] = right;
            }
            else{
                int ind = hash_arr[(int)str.charAt(right)];
                hash_arr[(int)str.charAt(right)] = right;

                if(ind >= left){
                    left = ind + 1;
                }
            }

            maxi = Math.max(maxi, right-left + 1);

        }

        System.out.println(maxi);

    }


    //Time complexity: O(N^2)
    // Space Complexity: O(170) Constant
    public static void bruteForce(String str){
        int maxi = 0;

        for(int i=0; i<str.length(); i++){
            int hash_arr[] = new int[170];

            for(int j=i; j<str.length(); j++){
                if(hash_arr[(int)str.charAt(j)] == 1){
                    break;
                }
                hash_arr[(int)str.charAt(j)] = 1;

                maxi = Math.max(maxi, j-i+1);

            }

        }

        System.out.println(maxi);

    }


    public static void ownSol(String str){
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
