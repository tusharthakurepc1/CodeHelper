package com.DynamicProgramming;

import com.sun.xml.internal.stream.XMLInputFactoryImpl;

public class PalindromePartitioning2 {
    public static void main(String[] args) {
        String str = "abcde";

/*
*   In this given problem you have to return the min no of cuts will make all the substring palindrome
*   Example str = "aab"
*
*   "a" , "a" and "b" are three palindrome sub-string with two cut
*   "aa" and "b" are two palindrome sub-string with one cut
*
*   So minimum no of cut is 1           Ans: 1
 */

        System.out.println(recursiveSolution(str) - 1);

        System.out.println(recursiveSolution(str, 0, str.length()-1));

    }

    public static int recursiveSolution(String str, int start, int end){
        if(start >= end)    return 0;

        if(isPalindrome(str, start, end)){
            return 0;
        }

//        Explore all the cuts
        int mini = Integer.MAX_VALUE;

        for(int i=start;i<=end;i++){

            if(isPalindrome(str, start, i)){
                int temp = 1 + recursiveSolution(str, i+1, end);

                mini = Math.min(temp, mini);
            }

        }

        return mini;
    }


//    This method is actually returning minimum no of sub array in the string that is palindrome
    public static int recursiveSolution(String str){
        if(str.length() == 0){
            return 0;
        }

        int mini_cuts = Integer.MAX_VALUE;
        for(int i=1;i<=str.length();i++){
            String temp = str.substring(0, i);
            if(!isPalindrome(temp))  continue;

            int c = 1 + recursiveSolution(str.substring(i, str.length()));

            mini_cuts = Math.min(mini_cuts, c);
        }


        return mini_cuts;
    }

    public static boolean isPalindrome(String str){
        int start = 0, end = str.length()-1;

        while(start <= end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

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
