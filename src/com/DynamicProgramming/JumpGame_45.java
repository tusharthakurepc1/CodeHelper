package com.DynamicProgramming;

public class JumpGame_45 {
    public static void main(String[] args) {
        int arr[] = {2,3,0,1,4};

        System.out.println(recursiveSolution(arr, 0));

    }

    public static int recursiveSolution(int arr[], int ind){
        if(ind >= arr.length-1){
            return 0;
        }
        if(arr[ind] == 0){
            return Short.MAX_VALUE;
        }


        int mini = Short.MAX_VALUE;
        for(int i=1;i<=arr[ind];i++){

            mini = Math.min(mini, recursiveSolution(arr, ind+i));

        }

        return mini + 1;

    }

    public static int recursiveSolution(int arr[], int ind, int dp_arr[]){
        if(ind >= arr.length-1){
            return 0;
        }
        if(arr[ind] == 0){
            return Short.MAX_VALUE;
        }
        if(dp_arr[ind] != -1){
            return dp_arr[ind];
        }

        int mini = Short.MAX_VALUE;
        for(int i=1;i<=arr[ind];i++){
            mini = Math.min(mini, recursiveSolution(arr, ind+i, dp_arr));
        }

        return dp_arr[ind] = mini + 1;

    }
}
