package com.DynamicProgramming.String_DP;

import java.util.Arrays;

public class EditDistance_72 {
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
/*
 *      update h with r         rorse
 *      delete r (index 2)      rose
 *      delete e (index 3)      ros
 *
 *      So minimum 3 operation to make s1 to s2.
 */

        int dp_arr[][] = new int[s1.length()+1][s2.length()+1];
        for(int[] temp: dp_arr){
            Arrays.fill(temp, -1);
        }

        System.out.println(recursiveSolution(s1, 0, s2, 0, dp_arr));
    }

    public static int recursiveSolution(String s1, int ind1, String s2, int ind2, int dp_arr[][]){
        if(ind1 == s1.length()){
            return s2.length() - ind2;
        }
        if(ind2 == s2.length()){
            return s1.length() - ind1;
        }
        if(dp_arr[ind1][ind2] != -1){
            return dp_arr[ind1][ind2];
        }

        if(s1.charAt(ind1) == s2.charAt(ind2)){
//            If both index char is same then move
            return dp_arr[ind1][ind2] = recursiveSolution(s1, ind1 + 1, s2, ind2 + 1, dp_arr);
        }
        else{
//            If both index char not match then perform the all three operations

            int insert = 1 + recursiveSolution(s1, ind1, s2, ind2 + 1, dp_arr);
            int delete = 1 + recursiveSolution(s1, ind1 + 1, s2, ind2, dp_arr);
            int update = 1 + recursiveSolution(s1, ind1 + 1, s2, ind2 + 1, dp_arr);

            return dp_arr[ind1][ind2] = Math.min(insert, Math.min(delete, update));
        }
    }

}
