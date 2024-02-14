package com.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PrintAllPalendromeStrings {
    public static void main(String[] args) {
        String str = "madam";
        ArrayList<String> res = new ArrayList<>();

        allSubStrings(str, "", 0, res);

        System.out.println(res);
    }

    public static void allSubStrings(String str, String processed, int ind, ArrayList<String> res){
        if(ind == str.length()){
            if(checkPalendrome(processed)){
                res.add(processed);
            }
            return;
        }

        char temp = str.charAt(ind);
//        System.out.println(temp);

        allSubStrings(str, processed + temp, ind + 1, res);

        allSubStrings(str, processed, ind + 1, res);
    }

    public static boolean checkPalendrome(String str){
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
}
