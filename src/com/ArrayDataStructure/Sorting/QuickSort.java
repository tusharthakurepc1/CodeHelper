package com.ArrayDataStructure.Sorting;

import com.BasicLibTCT;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class QuickSort {
    public static void main(String[] args) {
        int arr[]={1,1,2,7,3};

//        quickSort(arr,0,arr.length-1);

        pivotSet(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

//    public static void quickSort(int arr[],int start,int end){
//        if(start >= end){
//            return;
//        }
//        int mid = pivotSet(arr,start,end);
//
//        quickSort(arr,start,mid-1);
//        quickSort(arr,mid+1,end);
//
//    }

    public static void pivotSet(int arr[],int start,int end){
        if(start >= end){
            return;
        }

        int low = start,high = end;
        int pivot = arr[(start + end)/2];

        while(start <= end){
            while(arr[start] < pivot){
                start++;
            }
            while(arr[end] > pivot){
                end--;
            }

            if(start <= end){
                BasicLibTCT.swap(arr,start,end);
                start++;
                end--;
            }

        }

        pivotSet(arr,low,end);
        pivotSet(arr,start,high);

    }
}
