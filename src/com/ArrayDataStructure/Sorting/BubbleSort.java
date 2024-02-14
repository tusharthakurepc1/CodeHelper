package com.ArrayDataStructure.Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[]={83,28,29,10,15,75};

        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //    i=0:(0 1 2 3 4 5)  i=1:(0 1 2 3 4)   i=2:(0 1 2 3)  i=3:(0 1 2)  i=4:(0 1)
    public static void bubbleSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
