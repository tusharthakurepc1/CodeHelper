package com.ArrayDataStructure;

import java.util.Arrays;

public class MergingArray {
    public static void main(String[] args) {
        int arr1[]={4,0,0,0,0,0};
        int arr2[]={1,2,3,5,6};

        mergeArray(arr1,arr2);
//        optimalMergeArray(arr1,arr2);
    }
    public static void mergeArray(int arr1[],int arr2[]){
        int i=0,j=0,k=0;

        int res[]=new int[arr1.length+arr2.length];

        while(i < arr1.length && j < arr2.length){
            if(arr1[i] <= arr2[j]){
                res[k]=arr1[i];
                i++;
                k++;
            }
            else{
                res[k]=arr2[j];
                j++;
                k++;
            }
        }

        while(i < arr1.length){
            res[k]=arr1[i];
            i++;
            k++;
        }

        while(j < arr2.length){
            res[k]=arr2[j];
            j++;
            k++;
        }

        System.out.println(Arrays.toString(res));
    }

    public static void optimalMergeArray(int arr1[],int arr2[]){
        int i=0,j=0;
        int m=arr1.length;
        int n=arr2.length;

        while(i < m && j < n){
            if(arr1[i] > arr2[j]){
                int temp=arr1[i];
                arr1[i]=arr2[j];
                arr2[j]=temp;
                j++;
            }
            else if(arr1[i] == arr2[j]){
                int temp=arr1[i];
                arr1[i]=arr2[j];
                arr2[j]=temp;
                i++;
            }
            else{
                i++;
            }
        }

//        i=m-n;
//        j=0;
//        while(i < arr1.length){
//            arr1[i]=arr2[j];
//            i++;
//            j++;
//        }


        arr2=Arrays.copyOf(arr1,arr1.length);
        System.out.println(Arrays.toString(arr2));
    }
}
