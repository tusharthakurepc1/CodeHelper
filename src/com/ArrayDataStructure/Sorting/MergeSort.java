package com.ArrayDataStructure.Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr[]={83,28,29,10,15,75};

        System.out.println(Arrays.toString(mergeSort(arr)));
    }

    public static int[] mergeSort(int arr[]){
        if(arr.length <= 1){
    //            System.out.println(Arrays.toString(arr));
            return arr;
        }

        int partition=(arr.length-1)/2;
        int arr_left[]=mergeSort(Arrays.copyOfRange(arr,0,partition+1));

        int arr_right[]=mergeSort(Arrays.copyOfRange(arr,partition+1,arr.length));

        return mergeArray(arr_left,arr_right);

    }

    public static int[] mergeArray(int left[],int right[]){
        int arr[]=new int[left.length+right.length];
        int i=0,j=0,k=0;

        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                arr[k]=left[i];
                i++;
                k++;
            }
            else{
                arr[k]=right[j];
                j++;
                k++;
            }
        }
        while(i < left.length){
            arr[k]=left[i];
            i++;
            k++;
        }
        while(j < right.length){
            arr[k]=right[j];
            j++;
            k++;
        }

        return arr;
    }

}
