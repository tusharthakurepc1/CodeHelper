package com.DynamicProgramming;

import java.io.CharArrayReader;
import java.util.Arrays;

public class RodCuttingProblem {
    public static void main(String[] args) {
        int price[] = {3, 5, 8, 9, 10, 17, 17, 20};
        int capacity = 8;
        int dp_arr[][] = new int[price.length][capacity+1];
        for(int []temp:dp_arr){
            Arrays.fill(temp, -1);
        }

        System.out.println(recursiveSolution(price, price.length-1, capacity));
        System.out.println(recursiveDPSolution(price, price.length-1, capacity, dp_arr));
        tabulationSolution(price, capacity, dp_arr);
    }

    public static int recursiveSolution(int price[], int ind, int capacity){
        if(ind == 0){
            int cost = capacity * price[0];
            return cost;
        }

        int not_take_it = recursiveSolution(price, ind-1, capacity);
        int take_it = Short.MIN_VALUE;
        int rod_len = ind + 1;
        if(rod_len <= capacity){
            take_it = price[ind] + recursiveSolution(price, ind, capacity - rod_len);
        }

        return Math.max(take_it, not_take_it);
    }


    public static int recursiveDPSolution(int price[], int ind, int capacity, int dp_arr[][]){
        if(ind == 0){
            int cost = capacity * price[0];
            return cost;
        }
        if(dp_arr[ind][capacity] != -1){
            return dp_arr[ind][capacity];
        }

        int not_take_it = recursiveDPSolution(price, ind-1, capacity, dp_arr);
        int take_it = Short.MIN_VALUE;
        int rod_len = ind + 1;
        if(rod_len <= capacity){
            take_it = price[ind] + recursiveDPSolution(price, ind, capacity - rod_len, dp_arr);
        }

        return dp_arr[ind][capacity] = Math.max(take_it, not_take_it);
    }

    public static void tabulationSolution(int price[],int capacity, int dp_arr[][]){

        for(int cap = 0;cap <= capacity;cap++){
            dp_arr[0][cap] = cap * price[0];
        }

        for(int ind = 1;ind < price.length;ind++){
            for(int cap = 0;cap <= capacity;cap++){
                int not_take_it = dp_arr[ind-1][cap];
                int take_it = Short.MIN_VALUE;
                int rod_len = ind + 1;

                if(rod_len <= cap){
                    take_it = price[ind] + dp_arr[ind][cap - rod_len];
                }

                dp_arr[ind][cap] = Math.max(take_it, not_take_it);

            }
        }

        System.out.println(dp_arr[price.length-1][capacity]);
    }
}
