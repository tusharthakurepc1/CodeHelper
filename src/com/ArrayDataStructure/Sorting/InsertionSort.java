package com.ArrayDataStructure.Sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[]={83,28,29,10,15,75};

        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int arr[]){

        for(int i=1; i<arr.length; i++){
            int key=arr[i];
            int j=i-1;
            while(j >= 0 && key < arr[j]){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

    }


}
