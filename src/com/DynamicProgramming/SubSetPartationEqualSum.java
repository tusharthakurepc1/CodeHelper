package com.DynamicProgramming;

public class SubSetPartationEqualSum {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 5};
        int sum = 0;
        for(int i=0;i<arr.length;i++)   sum += arr[i];


        int dp_arr[][] = new int[arr.length][sum+1];

        if(sum % 2 != 0){
            System.out.println("NO");
        }
        else{
            System.out.println(subSetSumK(arr, dp_arr, arr.length-1, sum/2));
        }

    }

    public static boolean subSetSumK(int arr[], int dp_arr[][], int ind, int target){
        if(ind < 0){
            return false;
        }
        if(target == 0){
            return true;
        }
        if(dp_arr[ind][target] != -1){
            if(dp_arr[ind][target] == 1)    return true;
            else    return false;
        }

        boolean not_take_it = subSetSumK(arr, dp_arr, ind-1, target);
        boolean take_it = false;
        if(target >= arr[ind])  take_it = subSetSumK(arr, dp_arr, ind-1 ,target - arr[ind]);

        if(not_take_it || take_it)  dp_arr[ind][target] = 1;
        else    dp_arr[ind][target] = 0;

        return not_take_it || take_it;
    }
}
