package com.DynamicProgramming;

import java.util.Arrays;

public class TriangleMinPathSum {
    public static void main(String[] args) {
        int tri_grid[][] = {{2},{3,4},{6,5,7},{4,1,8,3}};
        int row = tri_grid.length, col =tri_grid[tri_grid.length-1].length;
        int dp_arr[][] = new int[row][col];
        for(int arr[]: dp_arr){
            Arrays.fill(arr, 0);
        }

//        System.out.println(recursiveSolution(tri_grid,0,0));
//        System.out.println(recursionDPSolution(tri_grid,dp_arr,0,0));
        tabulationSolution(tri_grid,dp_arr,row-1,col-1);
    }

    public static int recursiveSolution(int tri_grid[][],int row,int col){
        if(row == tri_grid.length-1){
            return tri_grid[row][col];
        }

        int down = tri_grid[row][col] + recursiveSolution(tri_grid,row + 1, col);
        int diagnol = tri_grid[row][col] + recursiveSolution(tri_grid,row + 1, col + 1);

        return Math.min(down, diagnol);
    }

    public static int recursionDPSolution(int tri_grid[][],int dp_arr[][],int row,int col){
        if(row == tri_grid.length-1){
            return tri_grid[row][col];
        }
        if(dp_arr[row][col] != -1){
            return dp_arr[row][col];
        }

        int down = tri_grid[row][col] + recursionDPSolution(tri_grid,dp_arr,row + 1, col);
        int diagnol = tri_grid[row][col] + recursionDPSolution(tri_grid,dp_arr,row + 1, col + 1);

        return dp_arr[row][col] = Math.min(down, diagnol);
    }

    public static void tabulationSolution(int tri_grid[][],int dp_arr[][],int row,int col){
        for(int j=0;j<=col;j++){
            dp_arr[row][j] = tri_grid[row][j];
        }

        for(int i=tri_grid.length-2;i >= 0; i--){
            for(int j = i; i >= 0; j--){

                int d = tri_grid[i][j] + dp_arr[i+1][j];
                int diag = tri_grid[i][j] + dp_arr[i+1][j+1];

                dp_arr[i][j] = Math.min(d, diag);
            }
        }





//        for(int i=0;i<=row;i++){
//            for(int j=0;j<=col;j++){
//                System.out.print(dp_arr[i][j]+" ");
//            }
//            System.out.println();
//        }

    }
}
