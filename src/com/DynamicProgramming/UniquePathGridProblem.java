package com.DynamicProgramming;

import java.util.Arrays;

public class UniquePathGridProblem {
    public static void main(String[] args) {
        int grid[][] = {{0,1},{0,0}};

        int row = grid.length, col =grid[0].length;
        int dp_arr[][] = new int[row][col];
        for(int arr[]: dp_arr){
            Arrays.fill(arr, -1);
        }

//        System.out.println(reccDPSolution(row-1,col-1,dp_arr));
//        tabulationDPSolution(row-1,col-1,dp_arr);
//        spaceOptimizationSolution(row-1,col-1);



//        System.out.println(uniquePathReccSolution(grid.length-1,grid[0].length-1,grid));
        uniquePathSpaceOptimization(grid.length-1,grid[0].length-1,grid,dp_arr);
//        System.out.println(uniquePathDPReccSolution(grid.length-1, grid[0].length-1,grid,dp_arr));

    }
    public static int reccSolution(int row,int col){
        if(row < 0 || col < 0){
            return 0;
        }
        if(row == 0 && col == 0){
            return 1;
        }

        int top = reccSolution(row-1, col);
        int left = reccSolution(row, col-1);

        return left + top;
    }

    public static int reccDPSolution(int row,int col,int dp_arr[][]){
        if(row < 0 || col < 0){
            return 0;
        }
        if(row == 0 && col == 0){
            return 1;
        }

        if(dp_arr[row][col] != -1){
            return dp_arr[row][col];
        }

        int top = reccDPSolution(row-1, col, dp_arr);
        int left = reccDPSolution(row, col-1, dp_arr);

        return dp_arr[row][col] = left + top;
    }

    public static int tabulationDPSolution(int row,int col,int dp_arr[][]){
//        Time Complexity = O(n^2)  Space Complexity = O(n^2)

        for(int i=0;i<=row;i++){
            for(int j=0;j<=col;j++){
                if(i == 0 && j == 0)    dp_arr[i][j] = 1;
                else{
                    int up = 0, left = 0;

                    if(i > 0)    up = dp_arr[i-1][j];
                    if(j > 0)   left = dp_arr[i][j-1];

                    dp_arr[i][j] = up + left;
                }
            }
        }
        return dp_arr[row][col];
    }

    public static void spaceOptimizationSolution(int row,int col){

        int prev[] = new int[col+1];
        Arrays.fill(prev, 0);
        for(int i=0;i<=row;i++){
            int curr[] = new int[col+1];
            Arrays.fill(curr, 0);

            for(int j=0;j<=col;j++){
                if(i == 0 && j == 0){
                    curr[j] = 1;
                    continue;
                }

                int left = 0, top = 0;

                if(j > 0)   left = curr[j-1];
                top = prev[j];

                curr[j] = left + top;
            }
            prev = curr;
        }

        System.out.println(prev[col]);

    }

    public static int uniquePathReccSolution(int row,int col,int grid[][]){
        if (row >= 0 && col >=0 && grid[row][col] == 1) {
            return 0;
        }
        if(row == 0 && col == 0){
            return 1;
        }
        if(row < 0 || col < 0){
            return 0;
        }

        int left = 0, top = 0;
        if(col > 0)    left = uniquePathReccSolution(row, col-1, grid);
        if(row > 0)    top = uniquePathReccSolution(row-1, col, grid);

        return left + top;
    }

    public static void uniquePathSpaceOptimization(int row,int col,int grid[][],int dp_arr[][]){

        for(int i=0;i<=row;i++){
            for(int j=0;j<=col;j++){
                if(grid[i][j] == 1){
                    dp_arr[i][j] = 0;
                    continue;
                }
                if(i == 0 && j == 0){
                    dp_arr[i][j] = 1;
                }
                else{
                    int left = 0, top = 0;
                    if(j > 0)   left = dp_arr[i][j-1];
                    if(i > 0)   top = dp_arr[i-1][j];

                    dp_arr[i][j] = left + top;
                }
            }
        }

        System.out.println(dp_arr[row][col]);
    }

    public static int uniquePathDPReccSolution(int row,int col,int grid[][],int dp_arr[][]){
        if (row >= 0 && col >=0 && grid[row][col] == 1) {
            return 0;
        }
        if(row == 0 && col == 0){
            return 1;
        }
        if(row < 0 || col < 0){
            return 0;
        }
        if(dp_arr[row][col] != -1){
            return dp_arr[row][col];
        }

        int left = 0, top = 0;
        if(col > 0)    left = uniquePathDPReccSolution(row, col-1, grid, dp_arr);
        if(row > 0)    top = uniquePathDPReccSolution(row-1, col, grid, dp_arr);

        return dp_arr[row][col] = left + top;
    }
}
