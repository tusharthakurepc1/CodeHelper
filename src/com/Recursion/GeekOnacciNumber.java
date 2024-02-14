package com.Recursion;

public class GeekOnacciNumber {
    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 4};


        System.out.println(helper(arr, arr[3]));
    }

    public static int helper(int arr[], int ind){
        if(ind == 1){
            return arr[0];
        }
        if(ind == 2){
            return arr[1];
        }
        if(ind == 3){
            return arr[2];
        }

        return helper(arr, ind-1) + helper(arr, ind-2) + helper(arr, ind-3);
    }
}
