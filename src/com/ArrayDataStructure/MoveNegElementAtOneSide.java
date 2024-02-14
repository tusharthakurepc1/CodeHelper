package com.ArrayDataStructure;

import java.util.Arrays;

public class MoveNegElementAtOneSide {
    public static void main(String[] args) {
        int arr[]={5,2,-4,1,6,-6,-2};
        int temp=0;
        int pivot=0,i=-1,j=0;

        while(j<arr.length){
            if(arr[j] < pivot){
                i++;
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
            j++;
        }

        System.out.println(Arrays.toString(arr));
    }
}
