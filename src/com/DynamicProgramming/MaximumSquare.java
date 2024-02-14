package com.DynamicProgramming;

import java.util.Arrays;

public class MaximumSquare {
    public static void main(String[] args) {
        int grid[][] = {
                {0, 1},
                {1, 0}
        };

        System.out.println(helper(grid));

    }
    public static int helper(int arr[][]){
        int n = arr.length;
        int m = arr[0].length;
        int dp[][] = new int[n][m];

        for(int i=0;i<n;i++){
            dp[i][0] = arr[i][0];
        }
        for(int j=0;j<m;j++){
            dp[0][j] = arr[0][j];
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(arr[i][j] == 0)  dp[i][j] = 0;
                else{
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                }
            }
        }
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                maxi = Math.max(dp[i][j], maxi);

        for(int temp[]: dp){
            System.out.println(Arrays.toString(temp));
        }

        return maxi;

    }

}
