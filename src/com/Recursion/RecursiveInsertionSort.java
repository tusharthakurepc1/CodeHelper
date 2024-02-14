package com.Recursion;

import java.util.Arrays;

public class RecursiveInsertionSort {
    public static void main(String[] args) {
        int arr[] = {4,1,3,9,7};

        insertionSort(arr, 0);

        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int arr[], int ind){
        if(ind == arr.length){
            return;
        }

//        Slide element toward the left

        int temp = arr[ind];
        int i=ind-1;
        while(i >= 0 && arr[i] > temp){
            arr[i+1] = arr[i];
            i--;
        }
        arr[i+1] = temp;

        insertionSort(arr, ind+1);
    }
}
