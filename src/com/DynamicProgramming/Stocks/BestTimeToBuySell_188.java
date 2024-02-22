package com.DynamicProgramming.Stocks;

import java.util.Arrays;

public class BestTimeToBuySell_188 {
    public static void main(String[] args) {
        int arr[] = {3,2,6,5,0,3};
        int k = 2;
/*
 *  In this problem you have to buy first then sell any you have at max k no of buy ans sell to maximize the output.
 *  Buy on day2: 2 and sell on day3: 6  profit = 4
 *  Buy on day5: 0 and sell on day6: 3  profit = 3
 *
 *  Total Profit = 7
 */

        int dp_arr[][] = new int[(k*2) + 1][arr.length+1];
        for(int i=0;i<dp_arr.length;i++){
            Arrays.fill(dp_arr[i], -1);
        }
        System.out.println(recursiveSolution(arr, 0, false, k*2, dp_arr));

        for(int temp[]: dp_arr){
            System.out.println(Arrays.toString(temp));
        }
    }



    public static int recursiveSolution(int arr[], int ind, boolean isBuy, int max_transaction, int dp_arr[][]){
        if(ind == arr.length || max_transaction <= 0){
            return 0;
        }
        if(dp_arr[max_transaction][ind] != -1){
            return dp_arr[max_transaction][ind];
        }

        if(!isBuy){
//            Explore if you are not buy anything

            int buy = -arr[ind] + recursiveSolution(arr, ind+1, true, max_transaction - 1, dp_arr);
            int not_buy = recursiveSolution(arr, ind + 1, false, max_transaction, dp_arr);

            return dp_arr[max_transaction][ind] = Math.max(buy, not_buy);
        }
        else{
//            Explore if you are already buy some

            int sell = arr[ind] + recursiveSolution(arr, ind + 1, false, max_transaction - 1, dp_arr);
            int not_sell = recursiveSolution(arr, ind + 1, true, max_transaction, dp_arr);

            return dp_arr[max_transaction][ind] = Math.max(sell, not_sell);
        }
    }
}
