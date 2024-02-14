package com.Recursion;

import java.util.Arrays;

public class MinimumAndMaximumElement {
    public static void main(String[] args) {
        int arr[] = {1, 4, 3, -5, -4, 8, 6};


        System.out.println(minimumSolution(arr, arr.length-1));
        System.out.println(maxiumumSolution(arr, arr.length-1));
    }
    public static int minimumSolution(int arr[], int ind){
        if(ind == 0){
            return arr[0];
        }

        return Math.min(arr[ind], minimumSolution(arr, ind-1));
    }

    public static int maxiumumSolution(int arr[], int ind){
        if(ind == 0){
            return arr[0];
        }

        return Math.max(arr[ind], maxiumumSolution(arr, ind-1));
    }

}
