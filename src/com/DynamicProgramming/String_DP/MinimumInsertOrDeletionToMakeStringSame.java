package com.DynamicProgramming.String_DP;

import java.util.Arrays;

public class MinimumInsertOrDeletionToMakeStringSame {
    public static void main(String[] args) {
        String s1 = "sea";
        String s2 = "eat";

        int dp_arr[][] = new int[s1.length()+1][s2.length()+1];
        for(int temp[]: dp_arr){
            Arrays.fill(temp, -1);
        }

//ans is : 2  delete s and insert t in the string s1

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
        //  move both index if char is same
            return dp_arr[ind1][ind2] = recursiveSolution(s1, ind1 + 1, s2, ind2 + 1, dp_arr);
        }
        else{
        //  it character is not same then perform insert or delete
            int insert_s1 = 1 + recursiveSolution(s1, ind1, s2, ind2 + 1, dp_arr);
            int delete_s1 = 1 + recursiveSolution(s1, ind1 + 1, s2, ind2, dp_arr);

            return dp_arr[ind1][ind2] = Math.min(insert_s1, delete_s1);
        }
    }
}
