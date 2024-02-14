package com.DynamicProgramming.String_DP;

import java.util.Arrays;

public class PalindromeSubSequence {
    public static void main(String[] args) {
        String str = "leetcode";
        int dp_arr[][] = new int[str.length()+1][str.length()+1];

        System.out.println(solution(str, dp_arr));
        System.out.println(minimumInsertionToMakePalindrome(str,dp_arr));
    }


    public static int solution(String str, int dp_arr[][]){
        String rev = new StringBuilder(str).reverse().toString();
        int res = 0;
        for(int i=1;i<=str.length();i++){
            for(int j=1;j<=str.length();j++){
               if(str.charAt(i-1) == rev.charAt(j-1)){
                   dp_arr[i][j] = 1 + dp_arr[i-1][j-1];
               }
               else{
                   dp_arr[i][j] = Math.max(dp_arr[i-1][j], dp_arr[i][j-1]);
               }

               res = Math.max(res, dp_arr[i][j]);
            }
        }

//        for(int temp[]:dp_arr){
//            System.out.println(Arrays.toString(temp));
//        }

        return res;
    }

    public static int minimumInsertionToMakePalindrome(String str, int dp_arr[][]){
        return str.length() - solution(str, dp_arr);
    }
}
