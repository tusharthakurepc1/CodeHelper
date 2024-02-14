package com.CP;

public class DP_Frog1 {
    public static void main(String[] args) {

        int arr[] = {10, 30, 40, 20};
        int n = arr.length;


        System.out.println(helper(arr, n-1));
    }
    public static int helper(int arr[], int ind){
        if(ind == 0){
            return arr[0];
        }
        if(ind == 1){
            return Math.abs(arr[1] - arr[0]);
        }

        int one_step = Math.abs(arr[ind] - helper(arr, ind-1));
        int two_step = Math.abs(arr[ind] - helper(arr, ind-2));

        return Math.min(one_step, two_step);
    }

}
