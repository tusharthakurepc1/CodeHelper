package com.StringDataStructure;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String str = "tkPAdxpMfJiltOerItiv";

//        System.out.println((int)' ');
        helper(str);
    }

    public static void helper(String str){
        int count = 0;
        int i = str.length() - 1;
        for(i=str.length()-1;i>=0;i--){
            if(str.charAt(i) != 32){
                break;
            }
        }

        for(;i >= 0;i--){
            if(str.charAt(i) == 32){
                break;
            }
            count++;
        }


        System.out.println(count);
    }
}
