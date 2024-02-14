package com.DynamicProgramming;

import java.util.Arrays;

public class NinjaProblem {
    public static void main(String[] args) {
        int arr[][] = {{10,50,1},{5,100,11}};

//        int res [] = {0};
//        recursiveSolution(arr,arr.length-1,arr.length,0,res);
//        System.out.println(res[0]);

//        System.out.println(recursiveSolution(arr,arr.length-1,3));

        int dp_arr[][] = new int[arr.length][4];
        for (int[] row: dp_arr)
            Arrays.fill(row, -1);

        System.out.println(dpOptimalRecursiveSolution(arr,arr.length-1,3,dp_arr));

        for(int i=0;i<dp_arr.length;i++){
            System.out.println(Arrays.toString(dp_arr[i]));
        }
    }
    public static void recursiveSolution(int arr[][],int ind,int prev,int sum,int max[]){
        if(ind < 0){
            max[0] = Math.max(max[0],sum);
            return;
        }

        int n = arr[ind].length;
        for(int i=0;i<n;i++){
            if(i != prev){
                recursiveSolution(arr,ind-1,i,sum + arr[ind][i],max);
            }
        }

    }

    public static int recursiveSolution(int arr[][],int day,int prev){
        if(day == 0){
            int max_task = 0;

            for(int i = 0 ; i < 3 ; i++){
                if(i != prev){
                    max_task = Math.max(max_task,arr[day][i]);
                }
            }

            return max_task;
        }


        int max_task = 0;
        for(int i=0;i<3;i++){
            if(prev != i){
                int temp = arr[day][i] + recursiveSolution(arr, day-1,i);
                max_task = Math.max(max_task, temp);
            }
        }

        return max_task;
    }

    public static int dpOptimalRecursiveSolution(int arr[][],int day,int prev,int dp_arr[][]){
        if(day == 0){
            int maxi = 0;

            for(int i = 0; i < 3; i++){
                if(i != prev){
                    maxi = Math.max(maxi, arr[0][i]);
                }
            }
            return maxi;
        }

        if(dp_arr[day][prev] != -1){
            return dp_arr[day][prev];
        }

        int maxi = 0;

        for(int i=0;i < 3;i++){
            if(i != prev){
                int temp = arr[day][i] + dpOptimalRecursiveSolution(arr,day-1,i,dp_arr);
                maxi = Math.max(maxi, temp);
            }
        }
        dp_arr[day][prev] = maxi;
        return maxi;
    }
}
