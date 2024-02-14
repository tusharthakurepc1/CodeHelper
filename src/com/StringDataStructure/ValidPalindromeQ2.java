package com.StringDataStructure;

public class ValidPalindromeQ2 {
    public static void main(String[] args) {
        String str = "abbbasdfsc";

        System.out.println(bruteForce(str));
        System.out.println(betterSolution(str));
        System.out.println(optimalSolution(str));
    }

    public static boolean optimalSolution(String str){
        StringBuilder sb1 = new StringBuilder(str);
        int left = 0, right = str.length()-1;
        while(left <= right){
            if(str.charAt(left) == str.charAt(right)){
                left+=1;
                right-=1;
                continue;
            }

            if(checkPalindrome(str, left+1, right) || checkPalindrome(str, left, right-1)){
                return true;
            }
            else{
                return false;
            }
        }


        return true;
    }

    public static boolean betterSolution(String str){
        StringBuilder sb1 = new StringBuilder("");
        int length = str.length();
        if(checkPalindrome(str)){
            return true;
        }

        for(int i=0;i<str.length();i++){
            int left = i, right = length-i-1;

            sb1 = new StringBuilder(str);
            sb1.deleteCharAt(left);
            if(checkPalindrome(sb1.toString())) return true;

            sb1 = new StringBuilder(str);
            sb1.deleteCharAt(right);
            if(checkPalindrome(sb1.toString())) return true;
        }


        return false;
    }

    public static boolean bruteForce(String str){
        StringBuilder sb1 = new StringBuilder(str);

        for(int i=0;i<str.length();i++){
            sb1.deleteCharAt(i);
            if(checkPalindrome(sb1.toString()))
               return true;

            sb1 = new StringBuilder(str);
        }
        return false;
    }

    public static boolean checkPalindrome(String str){
        int length = str.length();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) != str.charAt(length-i-1)){
                return false;
            }
        }
        return true;
    }

    public static boolean checkPalindrome(String str, int start, int end){

        while(start <= end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start+=1;
            end-=1;
        }

        return true;
    }
}
