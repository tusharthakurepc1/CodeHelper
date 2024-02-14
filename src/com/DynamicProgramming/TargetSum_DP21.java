package com.DynamicProgramming;

import java.util.Arrays;

public class TargetSum_DP21 {
    public static void main(String[] args) {
        int arr[] = {0,0,0,1};
        int target = 1;
        int dp_arr[][] = new int[arr.length+1][target+1];
        for(int arr_t [] :dp_arr){
            Arrays.fill(arr_t, -1);
        }

//        System.out.println(recursiveSolution(arr,arr.length-1, target));
//        System.out.println(recursiveSolutionM2(arr,arr.length-1, target, 0));
    }

    public static int recursiveSolution(int arr[],int ind, int target){
        if(ind == 0){
            if(target == arr[ind])  return 1;
            else if(target == -arr[ind]) return 1;
            else return 0;
        }

        int pos = 0, neg = 0;
        pos = recursiveSolution(arr, ind - 1, target + arr[ind]);
        neg = recursiveSolution(arr, ind - 1, target - arr[ind]);

        System.out.println("POS: "+pos +" NEG: "+ neg + " Sum : "+(pos + neg));
        return pos + neg;
    }

    public static int recursiveSolutionM2(int arr[],int ind, int target, int sum){
        if(ind < 0){
            if(sum == target)   return 1;
            else    return 0;
        }

        int pos = recursiveSolutionM2(arr,ind-1, target, sum + arr[ind]);

        int neg = recursiveSolutionM2(arr, ind-1 ,target, sum - arr[ind]);

        return pos + neg;

    }


}
