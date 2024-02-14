package com.DynamicProgramming;

public class FrogJump {
    public static void main(String[] args) {
        int heights[] = {7,4,4,2,6,6,3,4};
        int dp_arr[] = new int[heights.length];

//        System.out.println(recursiveSolution(heights.length-1,heights));
        System.out.println(recursiveSolutionWithKJumps(heights.length-1,heights,3));
    }
    public static int recursiveSolution(int ind,int heights[]){
        if(ind <= 0){
            return 0;
        }

        int left_res = recursiveSolution(ind-1, heights) + Math.abs(heights[ind] - heights[ind-1]);
        int right_res = Integer.MAX_VALUE;
        if(ind > 1){
            right_res = recursiveSolution(ind-2, heights) + Math.abs(heights[ind] - heights[ind-2]);
        }

        return Math.min(left_res,right_res);
    }

    public static int recursiveSolutionWithKJumps(int ind,int heights[],int k){
        if(ind <= 0){
            return 0;
        }

        int mini = Integer.MAX_VALUE;

        for(int i=1;i<k;i++){
            if(ind - i >= 0){
                int temp = recursiveSolutionWithKJumps(ind-i, heights, k) + Math.abs(heights[ind] - heights[ind - i]);
                mini = Math.min(temp,mini);
            }
        }

        return mini;

    }



}
