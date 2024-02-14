package com.Recursion;

public class IsSorted {
    public static void main(String[] args) {
        int arr[] = {3, 4, 19, 21, 34, 90};

        System.out.println(isSorted(arr, arr.length-1));
    }

    public static boolean isSorted(int arr[], int ind){
        if(ind == 0){
            return true;
        }
        if(arr[ind-1] <= arr[ind]){
            return isSorted(arr, ind - 1);
        }
        return false;
    }
}
