package com.ArrayDataStructure.Recursion;

import java.util.Arrays;

public class Permutation_Problems {
    public static void main(String[] args) {
        int arr[]={1,2,3};
        int res[]={};

        permutationUnique(arr,0);
    }

    public static void permutationUnique(int arr[],int count){
        if(count == arr.length-1){
            System.out.println(Arrays.toString(arr));
        }

        for(int i=count;i<arr.length;i++){
            swap(arr,i,count);

            permutationUnique(arr,count+1);

            swap(arr,i,count);
        }

    }

    public static void swap(int arr[],int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
