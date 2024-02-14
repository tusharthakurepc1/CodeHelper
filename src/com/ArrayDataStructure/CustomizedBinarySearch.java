package com.ArrayDataStructure;

import java.util.Arrays;

public class CustomizedBinarySearch {
    public static void main(String[] args) {
        int arr[]={3,4,10,11,13,19,25};

        LeftRotateArray.leftRotateDthElementOptimal(arr,3);

        System.out.println(customizedBinarySearch(arr,10));

        System.out.println(Arrays.toString(arr));
    }

    public static int customizedBinarySearch(int arr[],int key){
        int start=0,end=arr.length-1;
        int mid=0;

        while(start <= end){
            mid=(start+end)/2;

            if(arr[mid] == key){
                return mid;
            }
            else if(arr[start] <= arr[mid]){
                if(arr[start]<=key && key <= arr[mid]){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            else{
                if(key >= arr[mid] && key <= arr[end]){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
        }

        return -1;
    }

}
