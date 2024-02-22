package com.DynamicProgramming.Stocks;

import java.util.Arrays;

public class BestTimeToBuySell_309 {
    public static void main(String[] args) {
        int arr[] = {1,2,3,0,2};

/*
 *  In this problem you can sell after buy as many no of time to maximize the profit but you can't buy on the next day of sell the stock.
 *  Buy on day1: 1 and sell on day2: 2  profit = 1
 *  Leave day3
 *  Buy on day4: 0 and sell on day: 2   profit = 2
 *
 *  Total Profit = 3
 */
        int dp_arr[][] = new int[2][arr.length+1];
        Arrays.fill(dp_arr[0], -1);
        Arrays.fill(dp_arr[1], -1);

        System.out.println(recursiveSolution(arr, 0, false));
        System.out.println(recursiveDPSolution(arr, 0, 0, dp_arr));

    }

    public static int recursiveSolution(int arr[], int ind, boolean isBuy){
        if(ind >= arr.length){
            return 0;
        }

        if(!isBuy){
//            Explore if you have not buy

            int buy = -arr[ind] + recursiveSolution(arr, ind + 1, true);
            int not_buy = recursiveSolution(arr, ind + 1, false);

            return Math.max(buy, not_buy);
        }
        else{
//            Explore if you have buy

            int sell = arr[ind] + recursiveSolution(arr, ind + 2, false);
            int not_sell = recursiveSolution(arr, ind + 1, true);

            return Math.max(sell, not_sell);
        }

    }

    public static int recursiveDPSolution(int arr[], int ind, int isBuy, int dp_arr[][]){
        if(ind >= arr.length){
            return 0;
        }
        if(dp_arr[isBuy][ind] != -1){
            return dp_arr[isBuy][ind];
        }

        if(isBuy == 0){
//            Explore if you have not buy

            int buy = -arr[ind] + recursiveDPSolution(arr, ind + 1, 1, dp_arr);
            int not_buy = recursiveDPSolution(arr, ind + 1, 0, dp_arr);

            return dp_arr[isBuy][ind] = Math.max(buy, not_buy);
        }
        else{
//            Explore if you have buy

            int sell = arr[ind] + recursiveDPSolution(arr, ind + 2, 0, dp_arr);
            int not_sell = recursiveDPSolution(arr, ind + 1, 1, dp_arr);

            return dp_arr[isBuy][ind] = Math.max(sell, not_sell);
        }

    }

}
