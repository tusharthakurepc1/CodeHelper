package com.DynamicProgramming;

import java.util.Arrays;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int arr[] = {10, 20, 30};
        int dp_arr[][] = new int[arr.length][arr.length];

        for(int temp[]: dp_arr){
            Arrays.fill(temp, -1);
        }

        System.out.println(getMinimumMultiplication(arr, 1, arr.length-1, dp_arr));

    }


    public static int getMinimumMultiplication(int arr[], int start, int end, int dp_arr[][]){
        if(start == end){
            return 0;
        }
        if(dp_arr[start][end] != -1){
            return dp_arr[start][end];
        }

        int mini = (int)1e9;
        //Try all the partition
        for(int k = start;k<end;k++){
            int cost = arr[start-1] * arr[k] * arr[end];

            int left_p = getMinimumMultiplication(arr, start, k, dp_arr);
            int right_p = getMinimumMultiplication(arr, k+1, end, dp_arr);

            int total = cost + left_p + right_p;

            mini = Math.min(mini, total);
        }

        return dp_arr[start][end] = mini;
    }
}
