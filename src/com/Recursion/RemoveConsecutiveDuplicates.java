package com.Recursion;

public class RemoveConsecutiveDuplicates {
    public static void main(String[] args) {
        String str = "aaaaabbbbbb";
        String res = removeConsecutiveDuplicates(str, 0);

        System.out.println(res);
    }

    public static String removeConsecutiveDuplicates(String str, int ind){
        if(ind == str.length() - 1){
            return "" + str.charAt(ind);
        }

        if(str.charAt(ind) == str.charAt(ind + 1)){
            return removeConsecutiveDuplicates(str, ind + 1);
        }
        else{
            return str.charAt(ind) + removeConsecutiveDuplicates(str, ind + 1);
        }

    }
}
