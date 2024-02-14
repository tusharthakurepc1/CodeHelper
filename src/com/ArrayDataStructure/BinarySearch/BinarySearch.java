package com.ArrayDataStructure.BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[]={4,5,7,9,10,19,43,90};

//        System.out.println(binarySearchIterative(arr,43));
        System.out.println(binarySearchRecursive(arr,0,arr.length,43));
    }

    public static int binarySearchIterative(int arr[],int key){
        int left=0,right=arr.length-1;

        while(left <= right){
            int mid = (left + right)/2;

            if(arr[mid] == key)  return mid;

            else if(arr[mid] < key){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int left, int right, int key){
        int mid=(left+right)/2;

        if(arr[mid] == key)     return mid;

        else if(arr[mid] < key){
            return binarySearchRecursive(arr,mid+1,right,key);
        }
        else{
            return binarySearchRecursive(arr,left,mid-1,key);
        }
    }


}
