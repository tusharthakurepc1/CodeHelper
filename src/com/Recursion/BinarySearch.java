package com.Recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1,5,6,9,11,12,19};


        System.out.println(binarySearch(arr, 20, 0, arr.length-1));
    }

    public static int binarySearch(int arr[],int key,int start, int end){
        if(start > end){
            return -1;
        }

        int mid = (start + end)/2;
        if(arr[mid] == key){
            return mid;
        }
        else if(key < arr[mid]){
            return binarySearch(arr, key, start, mid-1);
        }
        else{
            return binarySearch(arr, key, mid+1, end);
        }
    }
}
