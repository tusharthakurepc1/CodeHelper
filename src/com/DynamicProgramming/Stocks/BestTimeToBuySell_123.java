package com.DynamicProgramming.Stocks;

public class BestTimeToBuySell_123 {
    public static void main(String[] args) {
/*
*   In this given problem you have to buy first then sell and you have almost 2 transaction with you to gain maximum profit
*
*   Buy on day4: 0 and sell on day6: 3 profit = 3
*   Buy on day7: 1 and sell on day7: 4 profit = 3
*
*   Total profit = 6
*/

        int arr[] = {3,3,5,0,0,3,1,4};

        System.out.println(recursiveSolution(arr, 0, false, 2));
    }

    public static int recursiveSolution(int arr[], int ind, boolean buy, int count){
        if(ind == arr.length || count == 0){
            return 0;
        }

        if(!buy){
            int not_buy_price = recursiveSolution(arr, ind+1, false, count);
            int buy_price = -arr[ind] + recursiveSolution(arr, ind+1, true, count);

            return Math.max(not_buy_price, buy_price);
        }
        else{
            int not_sell_price = recursiveSolution(arr, ind+1, true, count);
            int sell_price = arr[ind] + recursiveSolution(arr, ind+1, false, count--);


            return Math.max(not_sell_price, sell_price);
        }
    }
}
