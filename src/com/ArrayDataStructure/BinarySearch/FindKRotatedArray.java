package com.ArrayDataStructure.BinarySearch;

import com.BasicLibTCT;

public class FindKRotatedArray {
    public static void main(String[] args) {
        int arr[]={2,2,2,2,2};

//        findRotation(arr);
        findRotationM2(arr);
    }

    public static void findRotation(int arr[]){     //Work only for unique elements in the array.
        int start=0,end=arr.length-1;
        int min=Integer.MAX_VALUE;
        int res=0;

        while(start <= end){
            int mid=(start + end)/2;

            if(arr[mid] <= arr[end]){
                //right side sorted.
                if(arr[mid] < min){
                    min=arr[mid];
                    res=mid;
                }
                end=mid-1;
            }
            else{
                //left side sorted.
                if(arr[start] < min){
                    min=arr[start];
                    res=start;
                }
                start=mid+1;
            }
        }
        System.out.println(res);
    }

    public static void findRotationM2(int arr[]){   //Working fine for duplicate elements.
        int start=0,end=arr.length-1;
        int min=Integer.MAX_VALUE;
        int ind=0;

        while(start <= end){
            int mid=(start + end)/2;

            if(arr[start] == arr[mid] && arr[mid] == arr[end]){
                min=arr[start];
                start++;
                end--;
                continue;
            }

            if(arr[start] < arr[end]){
                if(arr[start] < min){
                    min=arr[start];
                    ind=start;
                }
                break;
            }

            if(arr[mid] <= arr[end]){
                //right side sorted.
                if(arr[mid] < min){
                    min=arr[mid];
                    ind=mid;
                }
                end=mid-1;
            }
            else{
                //left side sorted.
                if(arr[start] < min){
                    min=arr[start];
                    ind=start;
                }
                start=mid+1;
            }
        }

        System.out.println(min+" "+ind);
    }
}
