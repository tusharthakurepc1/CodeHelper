package com.CP;

import com.sun.xml.internal.stream.XMLInputFactoryImpl;

public class MaximumPathSum {
    public static void main(String[] args) {
        int arr[][] = {
            {0,6,0},
            {5,8,7},
            {0,9,0}
        };

        int ans = Short.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                ans = Math.max(ans, maximumPath(arr, i, j, new boolean[arr.length][arr[0].length]));
                System.out.println(ans);
            }
        }

        System.out.println("Ans: "+ans);
    }

    public static int maximumPath(int arr[][], int r, int c, boolean flag[][]){
        if(r < 0 || c < 0 || r >= arr.length || c >= arr[0].length){
            return 0;
        }


        if(!flag[r][c] && arr[r][c] != 0){
            flag[r][c] = true;
            int top = arr[r][c] + maximumPath(arr, r-1, c, flag);
            int right = arr[r][c] + maximumPath(arr, r, c+1, flag);
            int bottom = arr[r][c] + maximumPath(arr, r+1, c, flag);
            int left = arr[r][c] + maximumPath(arr, r, c-1, flag);
            flag[r][c] = false;

            return Math.max(top, Math.max(right, Math.max(bottom, left)));
        }

        return 0;
    }
}
