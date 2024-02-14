package com.ArrayDataStructure;

import java.util.Arrays;

public class SortArray0s1s2s {
    public static void main(String[] args) {
        int arr[]={2,0,2,1,1,0};
        //Don't use sorting Algo

//        method1(arr);
//        method2(arr);
//        binarySort(arr);
        temp(arr);

    }

    public static void method1(int arr[]){

//        int arr[]={0,1,2,1,1,2,1,0,0,2};
        int zeros=0,ones=0,twos=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0) zeros++;
            if(arr[i] == 1) ones++;
            if(arr[i] == 2) twos++;
        }

//        int res[]=new int[arr.length];
        int i=0;
        for(int j=0;j<zeros;j++)    arr[i++]=0;
        for(int j=0;j<ones;j++)     arr[i++]=1;
        for(int j=0;j<twos;j++)     arr[i++]=2;

        System.out.println(Arrays.toString(arr));
    }

    public static void method2(int arr[]){
        int start=0,mid=0,end=arr.length-1;

        while(mid < arr.length && mid <= end){
            if (arr[mid] == 0) {
                swap(arr,start,mid);
                start++;
                mid++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else if(arr[mid] == 2){
                swap(arr,mid,end);
                end--;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int arr[],int i1,int i2){
        int temp=arr[i1];
        arr[i1]=arr[i2];
        arr[i2]=temp;
    }


    public static void binarySort(int arr[]){

        int start=0,end=arr.length-1;

        while(start < end){
            if(arr[start] == 0){
                start++;
            }
            else if(arr[start] == 1){
                swap(arr,start,end);
                end--;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void temp(int arr[]){
        int c1=0,c2=0,c3=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0) c1++;
            else if(arr[i] == 1)    c2++;
            else if(arr[i] == 2)    c3++;
        }

        int arr_res[]=new int[arr.length];
        int a=0;
        for(int i=1;i<=c1;i++){   arr_res[a]=0;   a++;    }
        for(int i=1;i<=c2;i++){   arr_res[a]=1;   a++;    }
        for(int i=1;i<=c3;i++){   arr_res[a]=2;   a++;    }

        System.out.println(Arrays.toString(arr_res));
    }
}
