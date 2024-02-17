package com.DynamicProgramming;

import java.util.Arrays;

public class JumpGame_55 {
    public static void main(String[] args) {
        int arr[] = {2,3,1,1,4};

        int dp_arr[] = new int[arr.length+1];
        Arrays.fill(dp_arr, -1);

        System.out.println(recursiveM2Solution(arr, 0, dp_arr));
        System.out.println("DP");
        System.out.println(Arrays.toString(dp_arr));

    }

    public static boolean recursiveSolution(int arr[], int ind){
        if(ind >= arr.length-1){
            return true;
        }
        if(arr[ind] == 0){
            return false;
        }

        for(int i=1;i<=arr[ind];i++){

            boolean res_temp = recursiveSolution(arr, ind+i);


            if(res_temp){
                return true;
            }
        }

        return false;
    }

    public static boolean recursiveM2Solution(int arr[], int ind, int dp_arr[]){
        if(ind >= arr.length-1){
            return true;
        }
        if(arr[ind] == 0){
            return false;
        }
        if(dp_arr[ind] != -1){
            if(dp_arr[ind] == 1) return true;
            else    return false;
        }

        boolean res_temp = false;
        for(int i=1;i<=arr[ind];i++){

            res_temp = recursiveM2Solution(arr, ind+i, dp_arr);

            if(res_temp){
                break;
            }
        }
        if(res_temp)    dp_arr[ind]= 1;
        else    dp_arr[ind] = 0;


        return res_temp;
    }
}
