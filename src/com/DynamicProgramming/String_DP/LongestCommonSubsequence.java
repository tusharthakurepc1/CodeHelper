package com.DynamicProgramming.String_DP;

import java.time.chrono.MinguoDate;
import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "ababa", s2 = "cbbcad";
        int dp_arr[][] = new int[s1.length()][s2.length()];
        for(int temp[] :dp_arr){
            Arrays.fill(temp, -1);
        }

//        System.out.println(recursiveSolution(s1, s1.length()-1, s2, s2.length()-1));
        System.out.println(recursiveDPSolution(s1, s1.length()-1, s2, s2.length()-1, dp_arr));

//        int dp_arr[][] = new int[s1.length()+1][s2.length()+1];
//        for(int temp[] :dp_arr){
//            Arrays.fill(temp, -1);
//        }

//        System.out.println(recursiveDPSolutionM2(s1, s1.length(), s2, s2.length(), dp_arr));
//        int size = tabulationSolution(s1,s2,dp_arr);

//        System.out.println(printRecursiveSolution(s1, s1.length()-1, s2, s2.length()-1, new StringBuilder()));
//            printRecursiveSolutionM2(s1, s2, size, dp_arr);
    }

    public static int recursiveSolution(String s1, int index1, String s2, int index2){
        if(index1 < 0 || index2 < 0){
            return 0;
        }

        if(s1.charAt(index1) == s2.charAt(index2)){
            return 1 + recursiveSolution(s1, index1-1, s2, index2-1);
        }

        return Math.max(recursiveSolution(s1, index1-1, s2, index2), recursiveSolution(s1, index1, s2, index2-1));
    }

    public static int recursiveDPSolution(String s1, int index1, String s2, int index2,int dp_arr[][]){

        if(index1 < 0 || index2 < 0){
            return 0;
        }
        if(dp_arr[index1][index2] != -1){
            return dp_arr[index1][index2];
        }

        if(s1.charAt(index1) == s2.charAt(index2)){
            return dp_arr[index1][index2] = 1 + recursiveDPSolution(s1, index1-1, s2, index2-1, dp_arr);
        }

        return dp_arr[index1][index2] = Math.max(recursiveDPSolution(s1, index1-1, s2, index2, dp_arr), recursiveDPSolution(s1, index1, s2, index2-1, dp_arr));
    }

    public static int recursiveDPSolutionM2(String s1, int index1, String s2, int index2,int dp_arr[][]){
        if(index1 == 0 || index2 == 0){
            return 0;
        }
        if(dp_arr[index1][index2] != -1){
            return dp_arr[index1][index2];
        }

        if(s1.charAt(index1-1) == s2.charAt(index2-1)){
            return dp_arr[index1][index2] = 1 + recursiveDPSolutionM2(s1, index1-1, s2, index2-1, dp_arr);
        }

        return dp_arr[index1][index2] = Math.max(recursiveDPSolutionM2(s1, index1-1, s2, index2, dp_arr), recursiveDPSolutionM2(s1, index1, s2, index2-1, dp_arr));
    }

    public static int tabulationSolution(String s1, String s2, int dp_arr[][]){
        for(int i = 0;i<=s1.length();i++){
            dp_arr[i][0] = 0;
        }
        for(int j = 0;j<=s2.length();j++){
            dp_arr[0][j] = 0;
        }

        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp_arr[i][j] = 1 + dp_arr[i-1][j-1];
                }
                else{
                    dp_arr[i][j] = Math.max(dp_arr[i-1][j], dp_arr[i][j-1]);
                }
            }
        }
        return dp_arr[s1.length()][s2.length()];
    }

    public static StringBuilder printRecursiveSolution(String s1, int index1, String s2, int index2, StringBuilder res){

        if(index1 < 0 || index2 < 0){
            return res;
        }

        if(s1.charAt(index1) == s2.charAt(index2)){
            res.insert(0, s1.charAt(index1));
            return printRecursiveSolution(s1, index1-1, s2, index2-1, res);
        }

        res.insert(0, s1.charAt(index1));
        StringBuilder p1 = printRecursiveSolution(s1, index1-1, s2, index2, res);
        res.deleteCharAt(0);

        res.insert(0, s2.charAt(index2));
        StringBuilder p2 = printRecursiveSolution(s1, index1, s2, index2-1, res);
        res.deleteCharAt(0);

        if(p1.length() > p2.length())   return p1;
        else  return p2;
    }

//NOTE :The Below method will gonna work when there is unique longest common substring in the DP array.
    public static void printRecursiveSolutionM2(String s1, String s2, int size, int dp_arr[][]){
        int i = s1.length();
        int j = s2.length();

//        char res[] = new char[size];
        StringBuilder res = new StringBuilder();
        while(i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                //Same String move diagnol..
                res.insert(0, s1.charAt(i-1));
                i--;
                j--;
            }
            else{
                //Check for the grater element at top and left and move with the grater value direction.
                int left = dp_arr[i][j-1];
                int top = dp_arr[i-1][j];

                if(top > left)  i--;
                else    j--;
            }

        }
        System.out.println(res);

    }




}
