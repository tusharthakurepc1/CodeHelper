package com.DynamicProgramming.String_DP;

import java.util.Arrays;

public class PalindromicSubString {
    public static void main(String[] args) {
        String str = "abcde";

        int dp_arr[] = new int[str.length()+1];
        Arrays.fill(dp_arr, -1);

        System.out.println(recursiveSolution(str, 0, dp_arr));
    }

    public static int recursiveSolution(String str, int ind, int dp_arr[]){
        if(ind == str.length()){
            return 0;
        }
        if(dp_arr[ind] != -1){
            return dp_arr[ind];
        }

        //slide window from ind to n
        int sum = 0;
        for(int i=ind+1; i<=str.length(); i++){
            String temp = str.substring(ind, i);

            if(isPalindrome(temp)){
                sum += 1;
            }

        }

        return dp_arr[ind] = sum + recursiveSolution(str, ind+1, dp_arr);
    }

    public static boolean isPalindrome(String str){
        int low = 0, high = str.length()-1;
        while(low < high){

            if(str.charAt(low) != str.charAt(high)){
                return false;
            }

            low++;
            high--;
        }

        return true;
    }

}
