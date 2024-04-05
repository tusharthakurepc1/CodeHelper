package com.DynamicProgramming.String_DP;

import java.util.Arrays;

public class ValidParenthesisString {
    public static void main(String[] args) {

        String str = "(*)";

        //* represent as '(', ')' or ' '

        int dp_arr[][] = new int[str.length()][str.length()];
        for(int temp[]: dp_arr){
            Arrays.fill(temp, -1);
        }
        System.out.println(memoizationSolution(str, 0, 0, dp_arr));
    }

    public static int memoizationSolution(String str, int balance, int ind, int dp_arr[][]){
        if(ind == str.length()){
            if(balance == 0){
                return 1;
            }
            return 0;
        }
        if(dp_arr[ind][balance] != -1){
            return dp_arr[ind][balance];
        }

        //open
        if(str.charAt(ind) == '('){
            return dp_arr[ind][balance] = memoizationSolution(str, balance + 1, ind + 1, dp_arr);
        }
        else if(str.charAt(ind) == '*'){

            //open
            int open = memoizationSolution(str, balance + 1, ind + 1, dp_arr);

            //close     //if stack is already empty and you try to pop
            int close = 0;
            if(balance > 0) close = memoizationSolution(str, balance - 1, ind + 1, dp_arr);

            //blank
            int blank = memoizationSolution(str, balance, ind + 1, dp_arr);

            return  dp_arr[ind][balance] = (open == 1 || close == 1 || blank == 1) ? 1 : 0;
        }
        else{
            //if stack is already empty and you try to pop
            if(balance == 0)    return dp_arr[ind][balance] = 0;
            return dp_arr[ind][balance] = memoizationSolution(str, balance - 1, ind + 1, dp_arr);
        }

    }

    public static boolean recursiveSolution(String str, int balance, int ind, int dp_arr[][]){
        if(ind == str.length()){
            if(balance == 0){
                return true;
            }
            return false;
        }

        //open
        if(str.charAt(ind) == '('){
            return recursiveSolution(str, balance + 1, ind + 1, dp_arr);
        }
        else if(str.charAt(ind) == '*'){

            //open
            boolean open = recursiveSolution(str, balance + 1, ind + 1, dp_arr);

            //close     //if stack is already empty and you try to pop
            boolean close = false;
            if(balance > 0) close = balance != 0 && recursiveSolution(str, balance - 1, ind + 1, dp_arr);

            //blank
            boolean blank = recursiveSolution(str, balance, ind + 1, dp_arr);

            return  open || close || blank;
        }
        else{
            //if stack is already empty and you try to pop
            if(balance == 0)    return false;
            return recursiveSolution(str, balance - 1, ind + 1, dp_arr);
        }

    }

}
