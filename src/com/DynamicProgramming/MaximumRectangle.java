package com.DynamicProgramming;

import java.util.Arrays;
import java.util.Stack;

public class MaximumRectangle {
    public static void main(String[] args) {
        int arr[][] = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };

        int dp_arr[][] = new int[arr.length][arr[0].length];
        for(int j=0;j<dp_arr[0].length;j++){
            dp_arr[0][j] = arr[0][j];
        }
        int max_area = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){

            if(i > 0){
                for(int j=0;j<dp_arr[i].length;j++){
                    if(arr[i][j] != 0){
                        dp_arr[i][j] = arr[i][j] + dp_arr[i-1][j];
                    }
                }
            }

            max_area = Math.max(max_area, getLargestRectangle(dp_arr[i]));

        }

        System.out.println(max_area);
    }

    public static int getLargestRectangle(int arr[]){
        int lse[] = nextLeftSmaller(arr);
        int rse[] = nextRightSmaller(arr);

        int maxi = Integer.MIN_VALUE;

        for(int i=0;i< arr.length;i++){
            int temp = (rse[i] - lse[i] + 1) * arr[i];

            maxi = Math.max(maxi, temp);
        }

        return maxi;
    }

    public static int[] nextLeftSmaller(int arr[]){
        int res[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<arr.length;i++){

            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            if(!stack.isEmpty())
                res[i] = stack.peek()+1;
            else
                res[i] = 0;


            stack.push(i);

        }
//        System.out.println(Arrays.toString(res));

        return res;
    }

    public static int[] nextRightSmaller(int arr[]){
        int res[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=arr.length-1;i>=0;i--){

            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            if(!stack.isEmpty())
                res[i] = stack.peek()-1;
            else
                res[i] = arr.length-1;

            stack.push(i);
        }
//        System.out.println(Arrays.toString(res));

        return res;
    }

}
