package com.DynamicProgramming.Tree;

import java.util.Arrays;

public class UniqueBSTs {
    public static void main(String[] args) {

        int n = 3;
        int dp_arr[] = new int[n+1];
        Arrays.fill(dp_arr, -1);

        System.out.println(recursiveSolution(n, dp_arr));

        tabulationSolution(n);
    }

    public static int recursiveSolution(int n, int dp_arr[]){
        if(n == 0 || n == 1){
            return 1;
        }
        if(dp_arr[n] != -1){
            return dp_arr[n];
        }

        int ans = 0;
        for(int i=1; i<=n; i++){
            int left = recursiveSolution(i-1, dp_arr);
            int right = recursiveSolution(n-i, dp_arr);

            ans += left * right;
        }

        return dp_arr[n] = ans;
    }

    public static void tabulationSolution(int n){
        int dp_arr[] = new int[n+1];

        dp_arr[0] = dp_arr[1] = 1;

        // i represent n
        for(int i=2; i<=n; i++){
            int ans = 0;
            for(int j=1; j<=i; j++){

                int left = dp_arr[j-1];
                int right = dp_arr[i-j];

                ans += left * right;

            }

            dp_arr[i] = ans;
        }

        System.out.println(dp_arr[n]);
    }


}
