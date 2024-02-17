package com.DynamicProgramming;

import java.util.Arrays;

public class CoinChangeII_518 {
    public static void main(String[] args) {
        int arr[] = {1, 2, 5};
        int amount = 5;

        int dp_arr[][] = new int[arr.length][amount+1];

        for(int temp[]: dp_arr){
            Arrays.fill(temp, -1);
        }

        System.out.println(recursiveSolution(arr, 0, 0, amount, dp_arr));
    }

    public static int recursiveSolution(int arr[], int ind, int sum, int amount, int dp_arr[][]){
        if(sum == amount){
            return 1;
        }
        if(ind >= arr.length || sum > amount){
            return 0;
        }
        if(dp_arr[ind][sum] != -1){
            return dp_arr[ind][sum];
        }

//        Take it without move to next
        int take_it = recursiveSolution(arr, ind, sum+arr[ind], amount, dp_arr);

//        Leave it and move forward
        int not_take_it = recursiveSolution(arr, ind+1, sum, amount, dp_arr);


        return dp_arr[ind][sum] = (take_it + not_take_it);
    }



}
