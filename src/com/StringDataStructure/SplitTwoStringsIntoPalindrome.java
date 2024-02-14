package com.StringDataStructure;

import com.StringDataStructure.*;

public class SplitTwoStringsIntoPalindrome {
    public static void main(String[] args) {
        String s1 = "abda", s2 = "acmc";

        System.out.println(helper(s1, s2));

        System.out.println(optimalApproach(s1, s2));
    }

    public static boolean optimalApproach2(String s1, String s2){

        

        return false;
    }

    public static boolean optimalApproach(String s1, String s2){
        if(s1.length() == 1){
            return true;
        }
        s2 = new StringBuilder(s2).reverse().toString();


        for(int i=1;i<s1.length();i++){
            System.out.println("\""+s1.substring(0,i)+"\"");
            if(s1.substring(0, i).equals(s2.substring(0, i)) ||
                    s1.substring(i, s1.length()).equals(s2.substring(i, s2.length()))){
                return true;
            }
        }
        return false;
    }

    public static boolean helper(String s1, String s2){

        for(int i=0;i<s1.length();i++){
            String s1_pre = s1.substring(0, i);
            String s1_post = s1.substring(i, s1.length());

            String s2_pre = s2.substring(0, i);
            String s2_post = s2.substring(i, s1.length());

            String p1 = s1_pre + s2_post, p2 = s2_pre + s1_post;

            if (ValidPalindromeQ2.checkPalindrome(p1) || ValidPalindromeQ2.checkPalindrome(p2)) {
                return true;
            }


        }
        return false;
    }
}
