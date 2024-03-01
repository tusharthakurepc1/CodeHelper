package com.DynamicProgramming;

import java.util.Arrays;

public class LongestPalindromicSubString {
    public static void main(String[] args) {
        String str = "babad";

        int dp_arr_le[][] = new int[str.length()+1][str.length()+1];
        for(int temp[]: dp_arr_le){
            Arrays.fill(temp, -1);
        }
        System.out.println(recursiveSolutionGetLength(str, 0, str.length()-1, dp_arr_le));

        String[][] dp_arr = new String[str.length()+1][str.length()+1];
        System.out.println(recursiveSolution(str, 0, str.length()-1, dp_arr));
    }

    public static String recursiveSolution(String str, int left, int right, String dp_arr[][]){
        if(left > right){
            return "";
        }

        if(dp_arr[left][right] != null){
            return dp_arr[left][right];
        }

        if(isPalindrome(str, left, right)){
            return str.substring(left, right+1);
        }

//        Explore all the possibilities
        int left_cp = left, right_cp = right;
        String max_string = "";
        while(left <= right){

//            Take left
            String take_left = recursiveSolution(str, left, right - 1, dp_arr);

//            Take right
            String take_right = recursiveSolution(str, left + 1, right, dp_arr);

            if(max_string.length() < take_left.length()){
                max_string = take_left;
            }
            if(max_string.length() < take_right.length()){
                max_string = take_right;
            }

            left++;
            right--;
        }

        return dp_arr[left_cp][right_cp] = max_string;
    }


/*
* This function is going to return the maxi length of palindrome substring.
*/
    public static int recursiveSolutionGetLength(String str, int left, int right, int dp_arr[][]){
        if(left > right){
            return 0;
        }
        if(dp_arr[left][right] != -1){
            return dp_arr[left][right];
        }

        if(isPalindrome(str, left, right)){
            return str.substring(left, right+1).length();
        }

//        Explore all the possibilities
        int maxi = Integer.MIN_VALUE;
        while(left <= right){

//            Take left
            int take_left_len = recursiveSolutionGetLength(str, left, right - 1, dp_arr);

//            Take right
            int take_right_len = recursiveSolutionGetLength(str, left + 1, right, dp_arr);

            maxi = Math.max(maxi, Math.max(take_right_len, take_left_len));

            left++;
            right--;
        }

        return dp_arr[left][right] = maxi;
    }

        // start and end must be the index
    public static boolean isPalindrome(String str, int start, int end){
        while(start < end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
