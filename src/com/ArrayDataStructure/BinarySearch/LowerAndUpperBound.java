package com.ArrayDataStructure.BinarySearch;

public class LowerAndUpperBound {
    public static void main(String[] args) {
        int arr[]={2,4,8,8,8,8,11,13};

        lowerBoundBinarySearch(arr,5);
        upperBoundBinarySearch(arr,5);

//        binarySearchInsertPosition(arr,9);
//        floorValueInArray(arr,10);
//        ceilValueInArray(arr,10);

    }

    public static void lowerBoundBinarySearch(int arr[],int x){
        int lb=arr.length;
        int left=0,right=arr.length-1;

        while(left <= right){
            int mid=(left + right)/2;

            if(arr[mid] < x){
                left=mid+1;
            }
            else{
                lb=mid;
                right=mid-1;
            }
        }

        System.out.println(lb);
    }

    public static void upperBoundBinarySearch(int arr[],int x){
        int up=arr.length;
        int left=0,right=arr.length-1;

        while(left <= right){
            int mid=(left+right)/2;

            if(arr[mid] > x){
                up=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }

        System.out.println(up);
    }

    public static void binarySearchInsertPosition(int arr[],int element){
        lowerBoundBinarySearch(arr,element);
    }

    public static void floorValueInArray(int arr[],int x){
        int start=0,end=arr.length-1;
        int floor_val=-1;

        while(start <= end){
            int mid=(start + end)/2;

            if(arr[mid] <= x){
                floor_val=arr[mid];
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        System.out.println(floor_val);
    }

    public static void ceilValueInArray(int arr[],int x){
        int start=0,end=arr.length-1;
        int ceil_value=-1;

        while(start <= end){
            int mid=(start + end)/2;

            if(arr[mid] >= x){
                ceil_value=arr[mid];
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        System.out.println(ceil_value);
    }
}
