package com.DynamicProgramming;

import java.util.Arrays;

public class DecodeWays {
    public static void main(String[] args) {
//        String str = "";
        String str = "226";

//        int dp_arr[][] = new int[str.length()+1][str.length()+1];
//        for(int temp[]: dp_arr){
//            Arrays.fill(temp, -1);
//        }

        //3 ways:  2 + 26   22 + 6   2 + 2 + 6

//        System.out.println(recursiveSolution(str, 0, dp_arr));

        int dp_arr[] = new int[str.length()+1];
        Arrays.fill(dp_arr, -1);

        System.out.println(recursionSolution2(str, 0, dp_arr));
    }

    public static int recursiveSolution(String str, int ind, int dp_arr[][]){
        if(ind == str.length()){
            System.out.println();
            return 1;
        }

        int ans = 0;

        //check for all possible take case
        for(int i=ind+1;i<=str.length();i++){
            if(dp_arr[ind][i] != -1){
                return dp_arr[ind][i];
            }

            String temp = str.substring(ind, i);
            if(temp.length() > 2)   break;
            int temp_int = Integer.parseInt(temp);
            if(temp_int > 0 && temp_int < 27){
                System.out.println(temp+" ");
                int res_t =  recursiveSolution(str, i, dp_arr);
                ans += res_t;
                dp_arr[ind][i] = res_t;
            }
            else if(temp_int == 0){
                return 0;
            }
        }

        return ans;
    }

    public static int recursionSolution2(String str, int ind, int dp_arr[]){
        if(ind == str.length()){
            System.out.println("BC1");
            return 1;
        }
        if(ind > str.length()){
            System.out.println("BC2");
            return 0;
        }

        if(dp_arr[ind] != -1){
            return dp_arr[ind];
        }

        //explore one digit number
        int one_digit = Integer.parseInt(str.substring(ind, ind+1));
        if(one_digit == 0)  return 0;
        int res1 = recursionSolution2(str, ind+1, dp_arr);

        //explore two digit number
        int two_digit = 0;
        int res2 = 0;
        if(ind < str.length()-1){
            two_digit = Integer.parseInt(str.substring(ind, ind+2));
            if(two_digit > 0 && two_digit < 27)
                res2 = recursionSolution2(str, ind+2, dp_arr);
        }



        return dp_arr[ind] = res1 + res2;
    }
}
