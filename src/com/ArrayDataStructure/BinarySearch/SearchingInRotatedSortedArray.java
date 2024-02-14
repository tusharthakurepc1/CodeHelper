package com.ArrayDataStructure.BinarySearch;

public class SearchingInRotatedSortedArray {
    public static void main(String[] args) {
        int arr[]={1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};


//        binarySearchM1(arr,2);
        binarySearchM2(arr,2);
    }

    public static void binarySearchM1(int arr[],int key){   //Work only for unique elements Time O(log n)
        int start=0,end=arr.length-1;

        while(start <= end){
            int mid=(start + end)/2;

            if(arr[mid] == key){
                System.out.println(mid);
                break;
            }

            else if(arr[mid] <= arr[end]){
                //Right Side Sorted.
                if(arr[mid] <= key && key <= arr[end]){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }

            else{
                //Left Side Sorted.
                if(arr[start] <= key && key <= arr[mid]){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
        }

    }

    public static void binarySearchM2(int arr[],int key){
        int start=0,end=arr.length-1;

        while(start <= end){
            int mid=(start + end)/2;
            if(arr[mid] == key){
                System.out.println(mid);
                return;
            }

            if(arr[start] == arr[mid] && arr[mid] == arr[end]){
                start++;
                end--;
                continue;
            }
            if(arr[mid] <= arr[end]){
                //right Sorted.
                if(arr[mid] <= key && key <= arr[end]){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
            else{
                //right sorted.
                if(arr[start] <= key && key <= arr[end]){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }


        }
    }
}
