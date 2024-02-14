package com.CP;

public class DP_Vacation {
    public static void main(String[] args) {
        int arr[][] = {
                {10 ,40 ,70},
                {20 ,50 ,80},
                {30 ,60 ,90}
        };

        for(int i=0;i<arr[arr.length-1].length;i++){
            System.out.println(helper(arr, arr[arr.length-1][i], arr.length-2));
        }
    }


    public static int helper(int arr[][], int prev, int row){
        if(row == 0){
            int maxi = Short.MIN_VALUE;
            for(int i=0;i<arr[0].length;i++){
                if(arr[row+1][i] == prev)   continue;
                maxi = Math.max(maxi, arr[0][i]);
            }

            System.out.println(maxi+" "+prev);
            return maxi;
        }

        int maxi = Short.MIN_VALUE;
        for(int i=0;i<3;i++){
            if(arr[row][i] == prev)   continue;

            maxi = arr[row][i] + Math.max(maxi, helper(arr, arr[row][i], row-1));
        }

        return maxi;
    }
}
