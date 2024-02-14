package com.DynamicProgramming;

import java.util.Arrays;

public class KnapSackZeroOne {
    public static void main(String[] args) {
        int n = 4;
        int weight[] = {1, 2, 4, 5};
        int value[] = {5, 4, 8, 6};
        int capacity = 5;

        int dp_arr[][] = new int[n][capacity+1];
        for(int arr[] :dp_arr){
            Arrays.fill(arr, -1);
        }


        System.out.println(recursiveSolution(weight, value, capacity, n-1));
        System.out.println(recursiveDPSolution(weight, value, capacity, n-1, dp_arr));
        tabulationSolution(weight, value, capacity, dp_arr);
    }

    public static int recursiveSolution(int wt[], int value[], int capacity,int ind){
        if(ind == 0){
            if(wt[ind] <= capacity){
                return value[ind];
            }
            else    return 0;
        }

        int take_it = Integer.MIN_VALUE, not_take_it = 0;
        not_take_it = recursiveSolution(wt, value, capacity, ind - 1);

        if(capacity >= wt[ind]){
            take_it = value[ind] + recursiveSolution(wt, value, capacity - wt[ind], ind-1);
        }

        return Math.max(take_it, not_take_it);
    }

    public static int recursiveDPSolution(int wt[], int value[], int capacity,int ind, int dp_arr[][]){
        if(ind == 0){
            if(wt[0] <= capacity){
                return value[0];
            }
            else    return 0;
        }

        if(dp_arr[ind][capacity] != -1){
            return dp_arr[ind][capacity];
        }
        int take_it = Integer.MIN_VALUE, not_take_it = 0;
        not_take_it = recursiveDPSolution(wt, value, capacity, ind - 1, dp_arr);

        if(capacity >= wt[ind]){
            take_it = value[ind] + recursiveDPSolution(wt, value, capacity - wt[ind], ind-1, dp_arr);
        }

        return dp_arr[ind][capacity] = Math.max(take_it, not_take_it);
    }

    public static void tabulationSolution(int wt[], int value[], int capacity, int dp_arr[][]){
        for(int i=wt[0];i<=capacity;i++){
            dp_arr[0][i] = value[0];
        }

        for(int ind = 1;ind< wt.length;ind++){
            for(int j = 0;j <=capacity;j++){
                int take_it = Short.MIN_VALUE, not_take_it = 0;

                if(j >= wt[ind]){
                    take_it = value[ind] + dp_arr[ind-1][j-wt[ind]];
                }
                not_take_it = dp_arr[ind-1][j];

                dp_arr[ind][capacity] = Math.max(take_it, not_take_it);
            }
        }

        System.out.println(dp_arr[wt.length-1][capacity]);

    }

}
