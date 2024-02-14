package com.Recursion;

import java.util.Arrays;

public class RecursiveBubbleSort {
    public static void main(String[] args) {
        int arr[] = {5,1,4,2,8};

        bubbleSort(arr, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }


    public static void bubbleSort(int arr[], int ind){
        if(ind == 0){
            return;
        }

//        Swap the smallest element with last
        for(int i=0;i<ind-1;i++){
            if(arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        bubbleSort(arr, ind-1);
    }
}
