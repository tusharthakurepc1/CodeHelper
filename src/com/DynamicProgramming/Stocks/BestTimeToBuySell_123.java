package com.DynamicProgramming.Stocks;

import java.util.Arrays;

public class BestTimeToBuySell_123 {
    public static void main(String[] args) {
/*
*   In this given problem you have to buy first then sell and you have at most 2 transaction with you to gain maximum profit
*
*   Buy on day4: 0 and sell on day6: 3 profit = 3
*   Buy on day7: 1 and sell on day7: 4 profit = 3
*
*   Total profit = 6
*/

        int arr[] = {2,1,4,5,2,9,7};
        int dp_arr[][] = new int[5][arr.length];
        for(int i=0;i<dp_arr.length;i++){
            Arrays.fill(dp_arr[i], -1);
        }

        System.out.println(recursiveDPSolution(arr, 0, 0, 4, dp_arr));



    }

    public static int recursiveDPSolution(int arr[], int ind, int isBuy, int max_transaction, int dp_arr[][]){
        if(ind == arr.length || max_transaction <= 0){
            return 0;
        }
        if(dp_arr[max_transaction][ind] != -1){
            return dp_arr[max_transaction][ind];
        }

        if(isBuy == 0){
//            Explore when you not have buy

            int buy = -arr[ind] + recursiveDPSolution(arr, ind + 1, 1, max_transaction - 1, dp_arr);
            int not_buy = recursiveDPSolution(arr, ind + 1, 0, max_transaction, dp_arr);

            return dp_arr[max_transaction][ind] = Math.max(buy, not_buy);
        }
        else{
//            Explore when you have a buy

            int sell = arr[ind] + recursiveDPSolution(arr, ind + 1, 0, max_transaction - 1, dp_arr);
            int not_sell = recursiveDPSolution(arr, ind + 1, 1, max_transaction, dp_arr);

            return dp_arr[max_transaction][ind] = Math.max(sell, not_sell);
        }
    }

    public static int recursiveSolution(int arr[], int ind, boolean isBuy, int max_transaction){
        if(ind == arr.length || max_transaction <= 0){
            return 0;
        }

        if(!isBuy){
//            Explore when you not have buy

            int buy = -arr[ind] + recursiveSolution(arr, ind + 1, true, max_transaction);
            int not_buy = recursiveSolution(arr, ind + 1, false, max_transaction);

            return Math.max(buy, not_buy);
        }
        else{
//            Explore when you have a buy

            int sell = arr[ind] + recursiveSolution(arr, ind + 1, false, max_transaction - 1);
            int not_sell = recursiveSolution(arr, ind + 1, true, max_transaction);

            return Math.max(sell, not_sell);
        }
    }


}
