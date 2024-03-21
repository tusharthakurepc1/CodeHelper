package com.DynamicProgramming;

import java.util.Arrays;

public class NumberOfDiceRollWithTargetSum {
    static int mod = (int) (1e9 + 7);
    public static void main(String[] args) {
        int n = 30, k = 30, target = 500;

        int dp_arr[][] = new int[n+1][target+1];
        for(int temp[]: dp_arr) Arrays.fill(temp, -1);

        System.out.println(recursiveSolution(n, k, target, dp_arr));
        tabulationSolution(n, k, target);
    }

    public static int recursiveSolution(int n, int k, int target, int dp_arr[][]){
        if(n == 0 && target == 0)   return 1;
        if(n <= 0 || target <= 0)   return 0;

        if(dp_arr[n][target] != -1){
            return dp_arr[n][target] % mod;
        }

        int ans = 0;

        //try all the k sides
        for(int i=1; i<=k; i++){

            int temp = recursiveSolution(n-1, k, target-i, dp_arr);
            ans = (ans + temp) % mod;

        }


        return dp_arr[n][target] = ans % mod;
    }

    public static void tabulationSolution(int n, int k, int target){
        int dp_arr[][] = new int[n+1][target+1];

        for(int i=0;i<n;i++)    dp_arr[i][0] = 0;
        for(int j=0;j<target;j++)   dp_arr[0][j] = 0;

        dp_arr[0][0] = 1;

        for(int i=1;i<=n;i++){

            for(int j=1;j<=target;j++){

                int sum = 0;
                for(int sides=1;sides<=k;sides++){

                    if(j-sides >= 0){
                        int temp = dp_arr[i-1][j-sides];
                        sum = (sum + temp) % mod;
                    }

                }

                dp_arr[i][j] = sum % mod;

            }

        }



    }


}
