package com.DynamicProgramming;

import java.util.Arrays;

public class MaxLengthOfRepeatedSubArray {
    public static void main(String[] args) {
        int arr1[] = {0,1,1,1,1};
        int arr2[] = {1,0,1,0,1};

        //expected answer is: 2     arr1: [0,1]     arr2: [1, 2]        mention the index

        int dp_arr[][] = new int[arr1.length+1][arr2.length+1];
        for(int temp[]: dp_arr){
            Arrays.fill(temp, -1);
        }

        int res[] = {0};
        recursiveSolution(arr1, 0, arr2, 0, 0, res);
        System.out.println(res[0]);

        System.out.println(betterSolution(arr1, 0, arr2, 0, dp_arr));
    }

    public static void recursiveSolution(int arr1[], int ind1, int arr2[], int ind2, int temp, int res[]){
        if(ind1 == arr1.length || ind2 == arr2.length){
            return;
        }

        if(arr1[ind1] == arr2[ind2]){
            res[0] = Math.max(res[0], temp+1);
            //take it
            recursiveSolution(arr1, ind1+1, arr2, ind2+1, temp+1, res);

            //not-take it
            recursiveSolution(arr1, ind1+1, arr2, ind2, 0, res);
            recursiveSolution(arr1, ind1, arr2, ind2+1, 0, res);
        }
        else{
            recursiveSolution(arr1, ind1+1, arr2, ind2, 0, res);
            recursiveSolution(arr1, ind1, arr2, ind2+1, 0, res);
        }

    }


    public static int betterSolution(int arr1[], int ind1, int arr2[], int ind2, int dp_arr[][]){
        if(ind1 == arr1.length || ind2 == arr2.length){
            return 0;
        }
//        if(dp_arr[ind1][ind2] != -1){
//            return dp_arr[ind1][ind2];
//        }

        if(arr1[ind1] == arr2[ind2]){

            //take it
            int a = 1 + betterSolution(arr1, ind1+1, arr2, ind2+1, dp_arr);

            //not-take it
            int b = betterSolution(arr1, ind1+1, arr2, ind2, dp_arr);
            int c = betterSolution(arr1, ind1, arr2, ind2+1, dp_arr);

            return dp_arr[ind1][ind2] = Math.max(a, Math.max(b, c));
        }
        else{
            int a = betterSolution(arr1, ind1+1, arr2, ind2, dp_arr);
            int b = betterSolution(arr1, ind1, arr2, ind2+1, dp_arr);

            return dp_arr[ind1][ind2] = Math.max(a, b);
        }

    }
}
