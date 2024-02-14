package com.Recursion;

import java.util.Arrays;

public class SumTriangle {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};

        sumTriangle(arr);
    }


    public static void sumTriangle(int arr[]){
        if(arr.length == 1){
            System.out.println(Arrays.toString(arr));
            return;
        }

//        Processing
        int temp[] = new int[arr.length - 1];
        for(int i=1;i<arr.length;i++){
            temp[i-1] = arr[i-1] + arr[i];
        }

        sumTriangle(temp);

        System.out.println(Arrays.toString(arr));
    }
}
