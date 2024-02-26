package com.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String str = "aab";

        List<List<String>> res = new ArrayList<>();

        recursiveSolution(str, new ArrayList<>(), res);
        System.out.println(res);

    }

    public static void recursiveSolution(String str, List<String> processed, List<List<String>> result){
        if(str.length() == 0){
            result.add(new ArrayList<>(processed));
        }

        for(int i=1;i<=str.length();i++){
            String sub_str = str.substring(0, i);

            if(!isPalindrome(sub_str))   continue;

            processed.add(sub_str);
            recursiveSolution(str.substring(i, str.length()), processed, result);
            processed.remove(processed.size()-1);

        }
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

}
