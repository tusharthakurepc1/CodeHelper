package com.ArrayDataStructure;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

//        int n= sc.nextInt();
        int arr[]={1,2,3,4,5,6};

//        reverse(arr);
        reversePosCount(arr,0,arr.length);
        reversePosA2Optimal(arr,2,4);
        System.out.println(Arrays.toString(arr));


    }
    public static void reverse(int arr[]){
        int temp=0;
        for(int i=0;i<arr.length/2;i++){
            temp=arr[i];
            arr[i]=arr[(arr.length-1)-i];
            arr[(arr.length-1)-i]=temp;
        }
    }
    public static void reversePosCount(int arr[],int start,int count){
        int end=start+count-1;
        int temp=0,iter=0;

        if(start >= arr.length || end >= arr.length || count > arr.length){
            return;
        }
        for(int i=start;i<start+(count/2);i++){
            temp=arr[i];
            arr[i]=arr[end-iter];
            arr[end-iter]=temp;
            iter++;
        }

    }

    public static void reversePosA2Optimal(int arr[], int start, int end){
        int temp=0;
        while(start <= end){
            temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}
