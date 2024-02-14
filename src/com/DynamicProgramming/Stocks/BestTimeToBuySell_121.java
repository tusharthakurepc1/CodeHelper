package com.DynamicProgramming.Stocks;

import java.util.Arrays;

public class BestTimeToBuySell_121 {
    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};  // Expected answer is: Buy on 1 and sell it on 6 Total profit = 5


        helper(arr);
        optimalSolution(arr);
    }

    public static void helper(int arr[]){
        int dp[] = new int[arr.length];

        dp[0] = arr[0];
        for(int i=1;i<dp.length;i++){
            dp[i] = Math.min(dp[i-1], arr[i]);
        }

        System.out.println(Arrays.toString(dp));

        int max_profit = Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++){
            max_profit = Math.max(max_profit, arr[i] - dp[i]);
        }


        System.out.println(max_profit);
    }

    public static void optimalSolution(int arr[]){
        int dp[] = new int[arr.length];

        dp[0] = arr[0];
        int maxi = arr[0] - dp[0];

        for(int i=1;i<arr.length;i++){
            dp[i] = Math.min(dp[i-1], arr[i]);
            maxi = Math.max(maxi, arr[i] - dp[i]);
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(maxi);

    }

}
