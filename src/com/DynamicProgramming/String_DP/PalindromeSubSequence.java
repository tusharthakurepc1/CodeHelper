package com.DynamicProgramming.String_DP;

import java.util.Arrays;

public class PalindromeSubSequence {
    public static void main(String[] args) {
        String str = "leetcode";
        // str when it is palindrome    leetcodocteel
//        int dp_arr[][] = new int[str.length()+1][str.length()+1];

//        System.out.println(solution(str, dp_arr));
//        System.out.println(minimumInsertionToMakePalindrome(str,dp_arr));


        int dp_arr[][] = new int[str.length()+1][str.length()+1];
        for(int temp[]: dp_arr){
            Arrays.fill(temp, -1);
        }

        System.out.println(recursiveSolution(str, 0, str.length()-1, dp_arr));
    }

    public static int recursiveSolution(String str, int start, int end, int dp_arr[][]){
        if(start >= end || start >= str.length() || end < 0){
            return 0;
        }
        if(dp_arr[start][end] != -1){
            return dp_arr[start][end];
        }

        if(str.charAt(start) == str.charAt(end)){
//        move start and end if char is same
            return dp_arr[start][end] = recursiveSolution(str, start + 1, end - 1, dp_arr);
        }
        else{
//        if char is not match
            int insert_end = 1 + recursiveSolution(str, start + 1, end, dp_arr);
            int insert_start = 1 + recursiveSolution(str, start, end - 1, dp_arr);
            return dp_arr[start][end] = Math.min(insert_start, insert_end);
        }
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
