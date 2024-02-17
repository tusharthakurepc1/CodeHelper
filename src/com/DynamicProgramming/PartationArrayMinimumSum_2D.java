package com.DynamicProgramming;

import java.util.Arrays;

public class PartationArrayMinimumSum_2D {
//    This algo is working for only some of the test case.
    public static void main(String[] args) {
//        int arr[] = {-36, 36};
//        int arr[] = {2,-1,0,4,-2,-9};
        int arr[] = {3,9,7,3};

        int res[] = new int[]{Integer.MAX_VALUE};

        int sum = 0;
        for(int i=0;i<arr.length;i++)   sum += arr[i];
        System.out.println("Sum: "+sum);


//        System.out.println(recursiveSol(arr, arr.length-1, sum, sum));
        recursiveSolution(arr, 0, 0, sum, res);
        System.out.println(res[0]);
    }

    public static void recursiveSolution(int arr[], int ind, int processed, int total_sum, int res[]){
        if(ind >= arr.length){
            return;
        }


        int t = Math.abs(processed - (total_sum-processed));
        if(t != total_sum)
            res[0] = Math.min(res[0], t);

//        take it case
        recursiveSolution(arr, ind+1, processed+arr[ind], total_sum, res);

//        leave it case
        recursiveSolution(arr, ind+1, processed, total_sum, res);

    }

    public static void solution(int arr[],int total_sum){
        boolean dp_arr[][] = new boolean[arr.length][total_sum+1];

        for(int i=0;i<arr.length;i++){
            dp_arr[i][0] = true;
        }
        if(arr[0] <= total_sum)  dp_arr[0][arr[0]] = true;

        for(int i=1;i<arr.length;i++){
            for(int j=1;j<=total_sum;j++){
                boolean not_taken = false, taken = false;

                not_taken = dp_arr[i-1][j];
                if(j > arr[i]) taken = dp_arr[i-1][j-arr[i]];

                dp_arr[i][j] = taken || not_taken;
            }
        }


//        for(boolean arr_s[]: dp_arr){
//            System.out.println(Arrays.toString(arr_s));
//        }
        int mini = Short.MAX_VALUE;

        for(int i = 0;i<total_sum/2;i++){
            if(dp_arr[arr.length-1][i] == true){
                mini = Math.min(mini, Math.abs((total_sum - i) - i));
            }
        }

        System.out.println(mini);
    }

    public static int recursiveSol(int arr[], int ind, int target, int sum){
        if(ind < 0){
            int temp = sum - target;
            return Math.abs(target - temp);
        }

        int take_it = 0, not_take_it = 0;

        take_it = recursiveSol(arr, ind-1, target - arr[ind], sum);
        not_take_it = recursiveSol(arr, ind-1, target, sum);

        return Math.abs(Math.min(take_it, not_take_it));
    }

}
