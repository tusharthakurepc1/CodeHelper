package com.DynamicProgramming;

public class IsSubsequence {
    public static void main(String[] args) {
        String s1 = "abc", s2 = "ahbgdc";

        System.out.println(recursiveSolution(s2, "", s1, 0));
        System.out.println(iterativeSolution(s2, s1));
    }

    public static boolean recursiveSolution(String str, String processed, String comparison, int ind){
        if(ind >= str.length()){
            return comparison.equals(processed);
        }

        //not take it
        boolean not_take_it = recursiveSolution(str, processed, comparison, ind + 1);

        //take it
        boolean take_it = recursiveSolution(str, processed + str.charAt(ind), comparison, ind + 1);

        return not_take_it || take_it;
    }

    public static boolean iterativeSolution(String str, String comparison){
        int index = 0;

        for(int i=0;i<str.length();i++){
            if(index == comparison.length()){
                return true;
            }
            if(str.charAt(i) == comparison.charAt(index)){
                index++;
            }
        }

        if(index == comparison.length())    return true;
        else    return false;
    }
}
