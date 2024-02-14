package com.DynamicProgramming;

import java.util.Arrays;

public class SubSetSumEqualToK_2D {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        int k = 4;
        int dp_arr[][] = new int[arr.length][k + 1];

        for(int temp[]: dp_arr){
            Arrays.fill(temp, -1);
        }

//        System.out.println(recursiveSolution_M2(arr,arr.length-1,k));
//        System.out.println(recursiveDPSolution(arr,dp_arr, arr.length-1,k));

//        tabulationSolution(arr,k);
        tabulationSol(arr, k);
    }

    public static boolean recursiveSolution_M2(int arr[],int ind, int target){
        if(target == 0){
            return true;
        }
        if(ind < 0){
            return false;
        }

        boolean take_it = false;
        if(target >= arr[ind]) take_it = recursiveSolution_M2(arr, ind-1, target - arr[ind]);
        boolean not_take_it = recursiveSolution_M2(arr, ind-1, target);

        return take_it || not_take_it;

    }

    public static boolean recursiveDPSolution(int arr[],int dp_arr[][],int ind, int target){
        if(target == 0){
            return true;
        }
        if (ind < 0) {
            return false;
        }
        if (dp_arr[ind][target] != -1){
            if(dp_arr[ind][target] == 1)    return true;
            else    return false;
        }

        boolean take_it = false;
        if(target >= arr[ind]) take_it = recursiveDPSolution(arr,dp_arr,ind-1, target - arr[ind]);
        boolean not_take_it = recursiveDPSolution(arr,dp_arr, ind-1, target);

        boolean res = take_it || not_take_it;
        if(res)     dp_arr[ind][target] = 1;
        else    dp_arr[ind][target] = 0;

        return res;
    }

    public static void tabulationSolution(int arr[],int k){
        boolean dp_arr[][] = new boolean[arr.length][k + 1];
        int ind = arr.length-1;
//        Base case 2 in which we just true the flag which having index is 0 and having the target will be zero at index 1 so make dp flag true for 0th and 1st index of arr because 1st index will tell on that point of time you have target zero.
        for(int i=0;i<k;i++){
            dp_arr[i][0] = true;
        }
        dp_arr[0][arr[0]] = true;

        for(int i=1;i<arr.length-1;i++){
            for(int target = 1;target <= k;target++){
                boolean not_take_it = dp_arr[i-1][target];

                boolean take_it = false;
                if(arr[i] <= target)   take_it = dp_arr[i-1][target - arr[i]];

                dp_arr[i][target] = not_take_it || take_it;

            }
        }
        System.out.println(dp_arr[ind][k]);

    }

    public static void tabulationSol(int arr[],int k){
        boolean dp_arr[][] = new boolean[arr.length][k+1];

        for(int i=0;i< dp_arr.length;i++){
            dp_arr[i][0] = true;
        }
        dp_arr[0][arr[0]] = true;

        for(int ind = 0;ind<arr.length;ind++){
            for(int target = 1;target <= k;target++){
                boolean not_take_it = false, take_it = false;

                if(ind > 0) not_take_it = dp_arr[ind-1][target];
                if(ind > 0 && target >= arr[ind])  take_it = dp_arr[ind-1][target - arr[ind]];

                dp_arr[ind][target] = take_it || not_take_it;

            }
        }
        System.out.println(dp_arr[arr.length-1][k]);



    }

}
