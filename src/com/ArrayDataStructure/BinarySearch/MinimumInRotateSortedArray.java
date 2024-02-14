package com.ArrayDataStructure.BinarySearch;

public class MinimumInRotateSortedArray {
    public static void main(String[] args) {
        int arr[]={7};


        minimumEle(arr);
    }
    public static void minimumEle(int arr[]){
        int start=0,end=arr.length-1;
        int min=Integer.MAX_VALUE;
        while(start <= end){
            int mid=(start + end)/2;

            if(arr[mid] <= arr[end]){
                //right side sorted.
                if(arr[mid] < min){
                    min=arr[mid];
                }
                end=mid-1;
            }
            else{
                //left side sorted.
                if(arr[start] < min){
                    min=arr[start];
                }
                start=mid+1;
            }

        }
        System.out.println(min);
    }

    public static void optimalMinimumEle(int arr[]){
        int start=0,end=arr.length-1;
        int min=Integer.MAX_VALUE;

        while(start <= end){
            if(arr[start] <= arr[end]){
                if(arr[start] < min){
                    min=arr[start];
                }
                break;
            }
            int mid=(start + end)/2;

            if(arr[mid] <= arr[end]){
                //right side sorted.
                if(arr[mid] < min){
                    min=arr[mid];
                }
                end=mid-1;
            }
            else{
                //left side sorted.
                if(arr[start] < min){
                    min=arr[start];
                }
                start=mid+1;
            }

        }
    }
}
