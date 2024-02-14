package com.CP;

import com.BasicLibTCT;

public class PathSum {
    public static void main(String[] args) {
        int n = 5, m = 3;   //N >= M

        System.out.println(dpSolution(n-1, m-1, new int[n][m]));

        optimalApproach(n, m);
    }

    public static int dpSolution(int row, int col, int dp_arr[][]){
        if(row == 0 && col == 0){
            return 1;
        }
        if(row < 0 || col < 0){
            return 0;
        }


        int up = 0, left = 0;

        up = dpSolution(row-1, col, dp_arr);
        left = dpSolution(row, col-1, dp_arr);

        return dp_arr[row][col] = up + left;
    }

    public static void optimalApproach(int n, int m){
/*
 *  Brute Force complexity having exponential O(2^n)
 *  Using DP complexity boil down to polynomial O(n^2)
 *  Now we use combination nCr to calculate the total ways to reach (0, 0) to (n-1, m-1)
 *  Having the O(n) using combination is to make sure that the N >= M
 */
        long total_ways = BasicLibTCT.combinations(n, m);
        System.out.println(total_ways);
    }
}
