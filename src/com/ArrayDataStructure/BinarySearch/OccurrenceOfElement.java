package com.ArrayDataStructure.BinarySearch;

public class OccurrenceOfElement {
    public static void main(String[] args) {
        int arr[]={5,7,7,8,8,10};

//        searchRangeLinearApproach(arr,8);
//        searchRangeBinarySearchApproach(arr,8);
        searchRangeBinarySearchApproachM2(arr,8);
    }

    public static void searchRangeLinearApproach(int arr[],int element){
        int first=-1,last=-1;

        for(int i=0;i<arr.length;i++){
            if(arr[i] == element && first == -1 && last == -1){
                first = i;
                last =i;
            }
            else if(arr[i] == element){
                last++;
            }
        }
        System.out.println(first+" "+last);
    }

    public static void searchRangeBinarySearchApproach(int[] arr, int target) {
        System.out.println(lowerBoundFirstOcc(arr,target)+" "+upperBoundLastOcc(arr,target));
    }

    public static int lowerBoundFirstOcc(int arr[],int target){
        int start=0,end=arr.length-1;
        int lb=arr.length;

        while(start <= end){
            int mid=(start + end)/2;

            if(arr[mid] >= target){
                lb=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }

        if(lb == arr.length || arr[lb] != target){
            return -1;
        }
        return lb;
    }

    public static int upperBoundLastOcc(int arr[],int target){
        int ub=arr.length;
        int start=0,end=arr.length-1;

        while(start <= end){
            int mid=(start + end)/2;

            if(arr[mid] > target){
                ub=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }

        if(ub == arr.length && arr.length != ub){
            return -1;
        }
        else if(ub > 0 && arr[ub-1] != target){
            return -1;
        }


        return ub-1;
    }

    public static void searchRangeBinarySearchApproachM2(int[] arr, int target) {
        int lb=lowerBoundFirstOccA2(arr,target);
        if(lb == -1){
            System.out.println("-1 -1");
        }
        else{
            int ub=upperBoundLastOccM2(arr,target);
            System.out.println(lb+" "+ub);
        }
    }

    public static int lowerBoundFirstOccA2(int arr[],int target){
        int lb=-1;
        int start=0,end=arr.length-1;

        while(start <= end){
            int mid=(start + end)/2;

            if(arr[mid] == target){
                lb=mid;
                end=mid-1;
            }
            else if(arr[mid] > target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }


        return lb;
    }

    public static int upperBoundLastOccM2(int arr[],int target){
        int ub=-1;
        int start=0,end=arr.length-1;

        while(start <= end){
            int mid=(start + end)/2;

            if(arr[mid] == target){
                ub=mid;
                start=mid+1;
            }
            else if(arr[mid] < target){
                start=mid+1;
            }
            else {
                end=mid-1;
            }
        }


        return ub;
    }
}
