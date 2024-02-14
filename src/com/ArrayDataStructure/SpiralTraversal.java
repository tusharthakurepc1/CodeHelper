package com.ArrayDataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralTraversal {
    public static void main(String[] args) {
        int arr[][]={{1},{2},{3},{4},{5}};

//        spiralTraversalOptimalP1(arr);
        spiralTraversalGenerateMatrixP2(5);


    }

    public static void spiralTraversalOptimalP1(int arr[][]){
        int n=arr.length;
        int m=arr[0].length;
        List<Integer> res=new ArrayList<>();

        int top=0,bottom=n-1;
        int left=0,right=m-1;

        while(left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res.add(arr[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                res.add(arr[i][right]);
            }
            right--;
            if(top <= bottom){
                for (int i = right; i >= left; i--) {
                    res.add(arr[bottom][i]);
                }
                bottom--;
            }
            if(left <= right){
                for (int i = bottom; i >= top; i--) {
                    res.add(arr[i][left]);
                }
                left++;
            }
        }

        System.out.println(res);
    }


    public static void spiralTraversalGenerateMatrixP2(int size) {
        int arr[][]=new int[size][size];
        int n=size-1;
        int m=size-1;
        int count_main=1;

        int top=0,bottom=n;
        int left=0,right=m;

        while(left <= right && top <= bottom) {

            for (int i = left; i <= right; i++) {
                arr[top][i] = count_main;
                count_main++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                arr[i][right] = count_main;
                count_main++;
            }
            right--;
            if(top <= bottom){
                for (int i = right; i >= left; i--) {
                    arr[bottom][i] = count_main;
                    count_main++;
                }
                bottom--;
            }
            if(left <= right){
                for (int i = bottom; i >= top; i--) {
                    arr[i][left] = count_main;
                    count_main++;
                }
                left++;
            }
        }

        for(int i=0;i<arr.length;i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }

}
