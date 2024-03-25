package com.DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingPathInMatrix {
    public static void main(String[] args) {
        int arr[][] = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };

        getMaxPath(arr);

    }

    public static void getMaxPath(int arr[][]){

        int maxi = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                boolean vis[][] = new boolean[arr.length][arr[0].length];
                int dp_arr[][] = new int[arr.length][arr[0].length];
                for(int temp[]: dp_arr){
                    Arrays.fill(temp, -1);
                }
                vis[i][j] = true;
                int temp = 1 + recursiveSolution(arr, vis, i, j, dp_arr);
//                System.out.println(temp + " ("+i+" "+j+")");
                maxi = Math.max(maxi, temp);
            }
        }

        System.out.println(maxi);
    }

    public static int recursiveSolution(int arr[][], boolean vis[][], int row, int col, int dp_arr[][]){
        if(dp_arr[row][col] != -1){
            return dp_arr[row][col];
        }

        //move in all the four direction
        int deltaX[] = {-1, 0, 1, 0};
        int deltaY[] = {0, 1, 0, -1};
        int path_sum = 0;

        for(int i=0;i<4;i++){
            int new_row = row + deltaX[i];
            int new_col = col + deltaY[i];


            if(new_row >= 0 && new_col >= 0 && new_row < arr.length && new_col < arr[0].length){

                if(!vis[new_row][new_col] && arr[row][col] < arr[new_row][new_col]){

                    vis[new_row][new_col] = true;
                    int temp = 1 + recursiveSolution(arr, vis, new_row, new_col, dp_arr);
                    vis[new_row][new_col] = false;

                    path_sum = Math.max(path_sum, temp);

                }

            }

        }

        return dp_arr[row][col] = path_sum;
    }

}
