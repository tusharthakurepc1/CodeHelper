package com.DynamicProgramming;

import com.sun.javafx.image.IntPixelGetter;

import java.util.*;

public class CountSquareSubMatrices_1277 {
    public static void main(String[] args) {
        int arr[][] = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };

        Map<Integer, Integer> map = new HashMap<>();

        map.put(10, 20);
        map.put(1, 20);

        map.forEach((a, b)->{
            System.out.println();
        });

//        dpSolution(arr);
    }

    public static void dpSolution(int arr[][]){
        int dp_arr[][] = new int[arr.length][arr[0].length];
        int total_square = 0;

        for(int i=0;i<arr.length;i++){   dp_arr[i][0] = arr[i][0];  total_square += dp_arr[i][0]; }
        System.out.println(total_square);
        for(int j=0;j<arr[0].length;j++){    dp_arr[0][j] = arr[0][j];   }
        for(int j=1;j<arr[0].length;j++)    total_square += dp_arr[0][j];

        System.out.println(total_square);

        for(int i=1;i<arr.length;i++){
            for(int j=1;j<arr[0].length;j++){
                if(arr[i][j] == 0){
                   dp_arr[i][j] = 0;
                   continue;
                }

//                Find minimum of diagonal, left and top
                int mini = Math.min(dp_arr[i-1][j], Math.min(dp_arr[i][j-1], dp_arr[i-1][j-1]));

                dp_arr[i][j] = mini + 1;
                total_square += dp_arr[i][j];

            }
        }

        for(int temp[]: dp_arr){
            System.out.println(Arrays.toString(temp));
        }

        System.out.println(total_square);

    }
}
