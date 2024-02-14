package com.DynamicProgramming;

import java.util.Arrays;

public class ChocolateNinja_Problem {
    public static void main(String[] args) {
        int grid[][] = {{2,3,1,2},{3,4,2,2},{5,6,3,5}};
        int row = grid.length;
        int col = grid[0].length;

        int dp_arr[][][] = new int[row][col][col];
        for(int two_arr[][] :dp_arr){
            for(int one_arr[] :two_arr){
                Arrays.fill(one_arr, -1);
            }
        }

//        System.out.println(recursiveSolution(grid,0,0,col-1,row,col));

        System.out.println(recursiveDPSolution(grid,0,0,col-1,row,col,dp_arr));
    }


    public static int recursiveSolution(int grid[][],int r,int c1,int c2,int row,int col){
        if(c1 < 0 || c1 >= col || c2 < 0 || c2 >= col){
            return Integer.MIN_VALUE;
        }
        if(r == row-1){
            if(c1 == c2){
                return grid[r][c1];
            }
            else{
                return grid[r][c1] + grid[r][c2];
            }
        }

//        Explore all paths
        int maxi = Short.MIN_VALUE;
        for(int dj1 = -1; dj1 <= 1; dj1++){
            for(int dj2 = -1; dj2 <= 1; dj2++){
                int val = 0;
                if(c1 == c2)    val = grid[r][c1];
                else{
                    val = grid[r][c1] + grid[r][c2];
                }

                val += recursiveSolution(grid,r+1, c1+dj1, c2+dj2, row,col);
                maxi = Math.max(maxi, val);
            }
        }

        return maxi;
    }


    public static int recursiveDPSolution(int grid[][],int r,int c1,int c2,int row,int col,int dp_arr[][][]){
        if(c1 < 0 || c1 >= col || c2 < 0 || c2 >= col){
            return Integer.MIN_VALUE;
        }
        if(r == row-1){
            if(c1 == c2){
                return grid[r][c1];
            }
            else{
                return grid[r][c1] + grid[r][c2];
            }
        }
        if(dp_arr[r][c1][c2] != -1){
            return dp_arr[r][c1][c2];
        }

//        Explore all paths
        int maxi = Short.MIN_VALUE;
        for(int dj1 = -1; dj1 <= 1; dj1++){
            for(int dj2 = -1; dj2 <= 1; dj2++){
                int val = 0;
                if(c1 == c2)    val = grid[r][c1];
                else{
                    val = grid[r][c1] + grid[r][c2];
                }

                val += recursiveDPSolution(grid,r+1, c1+dj1, c2+dj2, row,col, dp_arr);
                maxi = Math.max(maxi, val);
            }
        }

        return dp_arr[r][c1][c2] = maxi;
    }

}
