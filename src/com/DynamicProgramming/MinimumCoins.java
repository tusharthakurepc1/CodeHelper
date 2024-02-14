package com.DynamicProgramming;

import java.util.Arrays;

public class MinimumCoins {
    public static void main(String[] args) {
        int arr[] = {2, 5, 10, 1};
        int cost = 27;
        int dp_arr[][] = new int[arr.length][cost+1];   //Array zeros if tabulation and -1 if recursive sol
//        for(int temp[]:dp_arr){
//            Arrays.fill(temp, -1);
//        }


//        int sol = recursiveSolution(arr,arr.length-1, cost);
//        int sol = recursiveDPSolution(arr, arr.length-1, cost, dp_arr);

//        if(sol >= Short.MAX_VALUE){
//            System.out.println(-1);
//        }
//        else
//        System.out.println(sol);

        tabulationSolution(arr, cost, dp_arr);
    }

    public static int recursiveSolution(int arr[], int ind, int target){
        if (ind == 0) {
            if(target % arr[ind] == 0)    return target/arr[0];
            else    return Short.MAX_VALUE;
        }

        int take_it = Short.MAX_VALUE, not_take_it = 0;

        not_take_it = recursiveSolution(arr, ind-1, target);
        if(target >= arr[ind]){
            take_it = 1 + recursiveSolution(arr, ind, target - arr[ind]);
        }

        return Math.min(take_it, not_take_it);
    }

    public static int recursiveDPSolution(int arr[], int ind, int target,int dp_arr[][]){
        if (ind == 0) {
            if(target % arr[ind] == 0)    return target/arr[0];
            else    return Short.MAX_VALUE;
        }
        if(dp_arr[ind][target] != -1){
            return dp_arr[ind][target];
        }

        int take_it = Short.MAX_VALUE, not_take_it = 0;

        not_take_it = recursiveDPSolution(arr, ind-1, target, dp_arr);
        if(target >= arr[ind]){
            take_it = 1 + recursiveDPSolution(arr, ind, target - arr[ind], dp_arr);
        }

        return dp_arr[ind][target] = Math.min(take_it, not_take_it);
    }


    public static void tabulationSolution(int arr[], int target, int dp_arr[][]){
        for(int i=0;i<=target;i++){
            if(i % arr[0] == 0)    dp_arr[0][i] = i/arr[0];
            else    dp_arr[0][i] = Short.MAX_VALUE;
        }

        for(int ind = 1;ind<arr.length;ind++){
            for(int j = 0;j<=target;j++){
                int take_it = Short.MAX_VALUE;
                if(j >= arr[ind]){
                    take_it = 1 + dp_arr[ind][j - arr[ind]];
                }
                int not_take_it = dp_arr[ind-1][j];

                dp_arr[ind][j] = Math.min(take_it, not_take_it);
            }
        }

        for(int el[]:dp_arr){
            System.out.println(Arrays.toString(el));
        }

        System.out.println(dp_arr[arr.length-1][target]);
    }
}
