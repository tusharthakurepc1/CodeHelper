package com.DynamicProgramming;

import java.util.Arrays;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int W = 10;
        int profit[] = {7, 9, 5};
        int wt[] = {1, 3, 9};
        int dp_arr[][] = new int[wt.length][W+1];
//        for(int []arr_tp : dp_arr){
//            Arrays.fill(arr_tp, -1);
//        }

        System.out.println(recursiveSolution(profit, wt, W, wt.length-1));
        System.out.println(recursiveDPSolution(profit, wt, W, wt.length-1, dp_arr));
        System.out.print("Tabulation: ");tabulationSolution(profit, wt, W, dp_arr);
    }

    public static int recursiveSolution(int profit[], int weight[], int W, int ind){
        if(ind == 0){
            int c = W / weight[0];
            return c * profit[0];
        }

        int not_take_it = recursiveSolution(profit, weight, W, ind - 1);
        int take_it = Short.MIN_VALUE;
        if(weight[ind] <= W){
            take_it = profit[ind] + recursiveSolution(profit, weight, W-weight[ind], ind);
        }

        return Math.max(take_it, not_take_it);
    }

    public static int recursiveDPSolution(int profit[], int weight[], int W, int ind, int dp_arr[][]){
        if(ind == 0){
            int c = W / weight[0];
            return c * profit[0];
        }
        if(dp_arr[ind][W] != -1){
            return dp_arr[ind][W];
        }

        int not_take_it = recursiveDPSolution(profit, weight, W, ind - 1, dp_arr);
        int take_it = Short.MIN_VALUE;
        if(weight[ind] <= W){
            take_it = profit[ind] + recursiveDPSolution(profit, weight, W-weight[ind], ind, dp_arr);
        }

        return dp_arr[ind][W] = Math.max(take_it, not_take_it);
    }


    public static void tabulationSolution(int profit[], int weight[], int W, int dp_arr[][]){
        for(int wt = 0;wt<=W;wt++){
            dp_arr[0][wt] = (wt / weight[0]) * profit[0];
        }

        for(int ind = 1;ind < dp_arr.length;ind++){
            for(int wt = 0;wt <= W;wt++){

                int not_take_it = dp_arr[ind-1][wt];
                int take_it = 0;
                if(weight[ind] <= wt){
                    take_it = profit[ind] + dp_arr[ind][wt-weight[ind]];
                }

                dp_arr[ind][wt] = Math.max(take_it, not_take_it);

            }
        }

        System.out.println(dp_arr[dp_arr.length-1][W]);

        for(int []temp:dp_arr){
            System.out.println(Arrays.toString(temp));
        }

    }

}
