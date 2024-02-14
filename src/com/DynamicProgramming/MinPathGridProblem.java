package com.DynamicProgramming;

import java.util.Arrays;

public class MinPathGridProblem {
    public static void main(String[] args) {
        int grid[][] = {{1,3,1},{1,5,1},{4,2,1}};
        int row = grid.length, col =grid[0].length;
        int dp_arr[][] = new int[row][col];
        for(int arr[]: dp_arr){
            Arrays.fill(arr, -1);
        }

//        System.out.println(recursionSolution(grid,row-1,col-1));
        System.out.println(recursionDPSolution(grid,dp_arr,row-1,col-1));
        tabulationSolution(grid,dp_arr,row-1,col-1);
    }


    public static int recursionSolution(int grid[][],int row,int col){
        if(row == 0 && col == 0){
            return grid[row][col];
        }

        int left = Integer.MAX_VALUE, top = Integer.MAX_VALUE;

        if(col > 0) left =  recursionSolution(grid,row,col - 1);
        if(row > 0) top =  recursionSolution(grid,row - 1, col);

        int temp = grid[row][col] + Math.min(left, top);

        return temp;
    }

    public static int recursionDPSolution(int grid[][],int dp_arr[][],int row,int col){
        if(row == 0 && col == 0){
            return grid[row][col];
        }
        if(dp_arr[row][col] != -1){
            return dp_arr[row][col];
        }

        int left = Integer.MAX_VALUE, top = Integer.MAX_VALUE;

        if(col > 0) left =  recursionSolution(grid,row,col - 1);
        if(row > 0) top =  recursionSolution(grid,row - 1, col);

        int temp = grid[row][col] + Math.min(left, top);

        return dp_arr[row][col] =  temp;
    }

    public static void tabulationSolution(int grid[][],int dp_arr[][],int row,int col){

        for(int i=0;i<=row;i++){
            for(int j=0;j<=col;j++){
                if(i == 0 && j == 0){
                    dp_arr[i][j] = grid[i][j];
                }
                else{
                    int top = Integer.MAX_VALUE, left = Integer.MAX_VALUE;

                    if(i > 0)   top = dp_arr[i-1][j];
                    if(j > 0)   left = dp_arr[i][j-1];

                    dp_arr[i][j] = grid[i][j] + Math.min(top, left);
                }
            }
        }

        System.out.println(dp_arr[row][col]);

    }
}
