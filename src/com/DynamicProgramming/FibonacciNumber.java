package com.DynamicProgramming;

import java.util.Arrays;

public class FibonacciNumber {
    public static void main(String[] args) {

        int n = 5;
//        System.out.println(recursiveSolution(n));

        int dp_arr[] = new int[n+1];
        for(int i=0;i<dp_arr.length;i++)    dp_arr[i] = -1;

//        System.out.println(Arrays.toString(dp_arr));
//        System.out.println(dpRecursiveSolution(5,dp_arr));
        dpIterativeSolution(5);
    }

    public static int recursiveSolution(int n){
        if(n <= 1){
            return n;
        }

        return recursiveSolution(n-1) + recursiveSolution(n-2);
    }

    public static int dpRecursiveSolution(int n,int dp_arr[]){
        if(n <= 1){
            return n;
        }
        if(dp_arr[n] != -1){
            return dp_arr[n];
        }


        dp_arr[n] = dpRecursiveSolution(n-1,dp_arr) + dpRecursiveSolution(n-2,dp_arr);
        return dp_arr[n];
    }

    public static void dpIterativeSolution(int n){
        int prev2 = 0;
        int prev1 = 1;

        for(int i=2;i<n+1;i++){
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        System.out.println(prev1);

    }
}
