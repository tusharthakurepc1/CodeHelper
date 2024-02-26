package com.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        int arr[] = {10,9,2,5,3,7,101,18};
//        int arr[] = {4,10,4,3,8,9};
/*
 *  Subsequence means a set of element may not be contiguous which follow the order Ex:[10 2 4 18]
 *  In this problem you have to return the maximum length of subsequence having all the element in increasing order
 *
 *  Ex: There are two subsequence possible
 *      [2, 5, 7, 101] = 4
 *      [2, 5, 7, 18] = 4
 *
 *  Ans: 4
 */
        int dp_arr[][] = new int[arr.length+1][arr.length+1];
        for(int temp[]: dp_arr){
            Arrays.fill(temp, -1);
        }

        System.out.println(recursiveSolution(arr, 0, -1, dp_arr));



    }

    public static int recursiveSolution(int arr[], int ind, int prev, int dp_arr[][]){
        if(ind == arr.length){
            return 0;
        }
        if(prev != -1 && dp_arr[ind][prev] != -1){
            return dp_arr[ind][prev];
        }

        int not_take_it = recursiveSolution(arr, ind + 1, prev, dp_arr);
        int take_it = 0;

        if(prev == -1 || arr[prev] < arr[ind]) {
            take_it = 1 + recursiveSolution(arr, ind + 1, ind, dp_arr);
        }

        if(prev != -1) dp_arr[ind][prev] = Math.max(take_it, not_take_it);
        return Math.max(take_it, not_take_it);
    }


}
