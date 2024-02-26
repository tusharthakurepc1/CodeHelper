package com.DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaximumProductSubArray {
    public static void main(String[] args) {
//        int arr[] = {-3,-1,-1};
        int arr[] = {2,3,-2,4};

//        bruteForceSolution(arr);
        betterSolution(arr);
    }

    public static void bruteForceSolution(int arr[]){
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int prod = 1;

                for(int z = i;z<j+1;z++){
                    prod *= arr[z];
                }
                System.out.println(Arrays.toString(Arrays.copyOfRange(arr, i, j+1))+" Prod:"+prod);


                maxi = Math.max(maxi, prod);

            }
        }

        System.out.println(maxi);
    }

    public static void betterSolution(int arr[]){
                    // max , min
        int res[] = {arr[0], arr[0]};
        int ans = arr[0];

        System.out.println(Arrays.toString(res));

        for(int i=1;i<arr.length;i++){
            if(arr[i] == 0){
                res[0] = res[1] = 1;
                ans = Math.max(ans, arr[i]);
                continue;
            }
            int a = res[0] * arr[i];
            int b = res[1] * arr[i];

            if(a > b) {
                res[0] = a;
                res[1] = b;
            }
            else {
                res[1] = b;
                res[0] = a;
            }
            ans = Math.max(ans, res[0]);

            System.out.println(Arrays.toString(res));
        }

        System.out.println(ans);
    }
}
