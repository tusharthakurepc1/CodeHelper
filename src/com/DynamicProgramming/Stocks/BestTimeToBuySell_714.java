package com.DynamicProgramming.Stocks;

import java.util.Arrays;

public class BestTimeToBuySell_714 {
    public static void main(String[] args) {
        int arr[] = {1,3,7,5,10,3};
        int cost = 3;
/*
 *  In this problem you have to buy after then sell to gain maximum profit but you have to pay some amount when
 *  you do some transaction, you can do as many transaction as you want.
 *
 *  Buy on day1: 1 and sell on day5: 10  profit: 9 - 3
 *
 *  Total profit = 6
 */

        int dp_arr[][] = new int[2][arr.length+1];
        Arrays.fill(dp_arr[0], -1);
        Arrays.fill(dp_arr[1], -1);

        System.out.println(recursiveSolution(arr, 0, 0, cost, dp_arr));
    }

    public static int recursiveSolution(int arr[], int ind, int isBuy, int cost, int dp_arr[][]){
        if(ind == arr.length){
            return 0;
        }
        if(dp_arr[isBuy][ind] != -1){
            return dp_arr[isBuy][ind];
        }

        if(isBuy == 0){
//            Explore if you have not buy

            int buy = -arr[ind] + recursiveSolution(arr, ind + 1, 1, cost, dp_arr);
            int not_buy = recursiveSolution(arr, ind + 1, 0, cost, dp_arr);

            return dp_arr[isBuy][ind] = Math.max(buy, not_buy);
        }
        else{
//            Explore if you have buy something

            int sell = arr[ind] + recursiveSolution(arr, ind + 1, 0, cost, dp_arr) - cost;
            int not_sell = recursiveSolution(arr, ind + 1, 1, cost, dp_arr);

            return dp_arr[isBuy][ind] = Math.max(sell, not_sell);
        }
    }
}
