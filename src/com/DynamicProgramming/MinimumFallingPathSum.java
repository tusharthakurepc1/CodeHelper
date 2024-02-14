package com.DynamicProgramming;

import java.util.Arrays;
//problem having variable starting and ending points
public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int grid[][] = {{2,1,3},{6,5,4},{7,8,9}};
        int row = grid.length;
        int col = grid[0].length;

        int dp_arr[][] = new int[row][col];
        for(int arr[]: dp_arr){
            Arrays.fill(arr, -1);
        }

//        int min_path = Integer.MAX_VALUE;
//        for(int i=0;i<col;i++){
//            min_path = Math.min(min_path, recursiveDPSolution(grid, dp_arr, row-1, i));
//        }
//        System.out.println(min_path);

        tabulationSolution(grid,dp_arr,row,col);
    }


    public static int recursiveSolution(int grid[][], int row, int col){
        if(col < 0 || col >= grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(row == 0){
            return grid[row][col];
        }

        int top = 0, t_left = 0, t_right = 0;

        top = recursiveSolution(grid, row - 1, col);
        t_left = recursiveSolution(grid, row - 1, col - 1);
        t_right = recursiveSolution(grid, row - 1, col + 1);


        return grid[row][col] + Math.min(top, Math.min(t_left, t_right));
    }

    public static int recursiveDPSolution(int grid[][],int dp_arr[][], int row, int col){
        if(col < 0 || col >= grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(row == 0){
            return grid[row][col];
        }

        if(dp_arr[row][col] != -1){
            return dp_arr[row][col];
        }
        int top = 0, t_left = 0, t_right = 0;

        top = recursiveDPSolution(grid, dp_arr, row - 1, col);
        t_left = recursiveDPSolution(grid, dp_arr, row - 1, col - 1);
        t_right = recursiveDPSolution(grid, dp_arr, row - 1, col + 1);

        int temp =  grid[row][col] + Math.min(top, Math.min(t_left, t_right));
        return dp_arr[row][col] = temp;
    }

    public static void tabulationSolution(int grid[][],int dp_arr[][],int row,int col){

        for(int i=0;i<col;i++){
            dp_arr[0][i] = grid[0][i];
        }

        for(int i=1;i<row;i++){
            for(int j=0;j<col;j++){
                int u = 0, ul = grid[i][j], ur = grid[i][j];

                u = grid[i][j] + dp_arr[i - 1][j];

                if(j-1 >= 0)    ul += dp_arr[i-1][j-1];
                else    ul = Integer.MAX_VALUE;

                if(j+1 < col) ur += dp_arr[i-1][j+1];
                else ur = Integer.MAX_VALUE;

                dp_arr[i][j] = Math.min(u, Math.min(ul, ur));
            }
        }

        int min_path = Integer.MAX_VALUE;
        for(int j=0;j<col;j++){
            min_path = Math.min(min_path, dp_arr[row-1][j]);
        }

        System.out.println(min_path);

//        for(int i=0;i<row;i++){
//            System.out.println(Arrays.toString(dp_arr[i]));
//        }

    }


}
