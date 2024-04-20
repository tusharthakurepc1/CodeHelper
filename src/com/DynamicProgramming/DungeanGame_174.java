package com.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class DungeanGame_174 {
    public static void main(String[] args) {
        int arr[][] = {
            {-2, -3, 3},
            {-5, -10, 1},
            {10, 30, -5}
        };

        for(int i=1; i<200; i++)
            if(solution(arr, 0, 0, i)){
                System.out.println(i);
                break;
            }


    }

    public static boolean solution(int arr[][], int row, int col, int sum){
        if(row == arr.length - 1 && col == arr[row].length - 1 && sum > 0){
            sum += arr[row][col];
            if(sum > 0) return true;
            return false;
        }
        if(sum <= 0 || row >= arr.length || col >= arr[row].length){
            return false;
        }

        boolean res = false;

        //move bottom
        if(row < arr.length - 1){
            res = res || solution(arr, row + 1, col, sum + arr[row][col]);
        }

        //move right
        if(col < arr[row].length - 1){
            res = res || solution(arr, row, col + 1, sum + arr[row][col]);
        }

//        System.out.println(sum + " [" + row+", "+col+"]");
        return res;
    }


}
