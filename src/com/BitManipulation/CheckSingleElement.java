package com.BitManipulation;

public class CheckSingleElement {
    public static void main(String[] args) {
        int arr[]={2,2,5,4,5,9,9};

        bruteForce(arr);
    }
    public static void bruteForce(int arr[]){
        int res=0;

        for(int i=0;i<arr.length;i++){
            System.out.println(res);
            res=res ^ arr[i];
        }

        System.out.println(res);
    }
}
