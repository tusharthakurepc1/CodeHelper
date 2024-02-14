package com.DynamicProgramming.Stocks;

import java.util.Arrays;

public class BestTimeToBuySell_122 {
    public static void main(String[] args) {

/*
*   You can buy and sell it on the multiple time to maximize the profit
*   Condition 1: Buy before sell
*   Condition 2: Don't buy stock until previous stock sell
*
*   Buy on day2: 1 and sell on day3: 5 profit = 4
*   Buy on day4: 3 and sell on day5: 6 profit = 3
*   Total Profit = 7
*/
        int arr[] = {7,1,5,3,6,4};
        int dp[][] = new int[2][arr.length];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);


        System.out.println(recursiveSolution(arr, 0, false));
        System.out.println(optimalSolution(arr, 0, 0, dp));
    }

    public static int recursiveSolution(int arr[], int ind, boolean buy){
        if(ind == arr.length){
            return 0;
        }
        if(ind == arr.length-1){
            if(buy) return arr[ind];
            else    return 0;
        }


//        Explore when you do not have any buy
        if(!buy){

            int not_buy_price = recursiveSolution(arr, ind+1, buy);
            int buy_price = -arr[ind] + recursiveSolution(arr, ind+1, true);

            return Math.max(buy_price, not_buy_price);
        }
        else{

            int not_sell_price = recursiveSolution(arr, ind+1, buy);
            int sell_price = arr[ind] + recursiveSolution(arr, ind+1, false);

            return Math.max(sell_price, not_sell_price);
        }

    }

    public static int optimalSolution(int arr[], int ind, int buy, int dp[][]){
        if(ind == arr.length){
            return 0;
        }
        if(ind == arr.length-1){
            if(buy == 1) return arr[ind];
            else    return 0;
        }
        if(dp[buy][ind] != -1){
            return dp[buy][ind];
        }

//        Explore when you do not have any buy
        if(buy == 0){

            int not_buy_price = optimalSolution(arr, ind+1, buy, dp);
            int buy_price = -arr[ind] + optimalSolution(arr, ind+1, 1, dp);

            return dp[buy][ind] = Math.max(buy_price, not_buy_price);
        }
        else{

            int not_sell_price = optimalSolution(arr, ind+1, buy, dp);
            int sell_price = arr[ind] + optimalSolution(arr, ind+1, 0, dp);

            return dp[buy][ind] = Math.max(sell_price, not_sell_price);
        }
    }
}
