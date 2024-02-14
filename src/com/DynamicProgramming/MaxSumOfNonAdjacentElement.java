package com.DynamicProgramming;

import java.util.List;

public class MaxSumOfNonAdjacentElement {
    public static void main(String[] args) {
        int arr[] = {2, 1, 4, 9};
        int dp_arr[] = new int[arr.length];

        for(int i=0;i<dp_arr.length;i++)    dp_arr[i] = -1;

        System.out.println(dpRecursiveSolution(arr.length-1,arr,dp_arr));
    }
    public static int recursionSolution(int ind, List<Integer> nums){
        if(ind == 0){
            return nums.get(0);
        }
        if(ind < 0){
            return 0;
        }

        int take_it = recursionSolution(ind-2,nums) + nums.get(ind);
        int not_take_it = recursionSolution(ind-1,nums);

        return Math.max(take_it,not_take_it);
    }

    public static int dpRecursiveSolution(int ind,int arr[],int dp_arr[]){
        if(ind == 0){
            return arr[ind];
        }
        if(ind < 0){
            return 0;
        }

        if(dp_arr[ind] != -1){
            return dp_arr[ind];
        }

        int take_it = dpRecursiveSolution(ind-2,arr,dp_arr) + arr[ind];
        int not_take_it = dpRecursiveSolution(ind-1,arr,dp_arr);

        dp_arr[ind] = Math.max(take_it,not_take_it);

        return dp_arr[ind];
    }



}
