package com.DynamicProgramming;

import java.util.Arrays;

public class CombinationSumP4 {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        int target = 4;

        int dp_arr[][] = new int[arr.length+1][target+1];
        for(int temp[]: dp_arr){
            Arrays.fill(temp, -1);
        }

        System.out.println(recursiveSolution(arr, 0, target, dp_arr));
    }

    public static int recursiveSolution(int arr[], int ind, int target, int dp_arr[][]){
        if(ind >= arr.length || target < 0){
            return 0;
        }
        if(target == 0){
            return 1;
        }

        if(dp_arr[ind][target] != -1){
            return dp_arr[ind][target];
        }

        //take it
        int take_case = recursiveSolution(arr, 0, target - arr[ind], dp_arr);

        //not take it
        int not_take_case = recursiveSolution(arr, ind + 1, target, dp_arr);


        return dp_arr[ind][target] = not_take_case + take_case;
    }
}
