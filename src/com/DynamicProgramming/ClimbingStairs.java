package com.DynamicProgramming;

import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 44;
        int dp_arr[] = new int[n+1];
        Arrays.fill(dp_arr, -1);
        System.out.println(recursiveDPSolution(n,dp_arr));
        System.out.println(recursiveSolution(n));

    }

    public static int recursiveSolution(int n){
        if(n == 0){
            return 1;
        }

        int step_1 = 0, step_2 = 0;

        if(n >= 1)  step_1 = recursiveSolution(n - 1);
        if(n >= 2)  step_2 = recursiveSolution(n - 2);

        return step_1 + step_2;
    }

    public static int recursiveDPSolution(int n, int dp_arr[]){
        if(n == 0){
            return 1;
        }
        if(dp_arr[n] != -1){
            return dp_arr[n];
        }

        int step_1 = 0, step_2 = 0;

        if(n >= 1)  step_1 = recursiveDPSolution(n - 1, dp_arr);
        if(n >= 2)  step_2 = recursiveDPSolution(n - 2, dp_arr);

        return dp_arr[n] = step_1 + step_2;
    }

}
