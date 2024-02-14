package com.CP;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 1, 5, 5, 7, 7, 10};

        lowerBound(arr, 11);
    }

    public static int binarySearch(int arr[], int key){
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int left = 0, right = arr.length-1;

        while(left <= right){
            int mid = (left + right)/2;

            if(arr[mid] == key){
                return mid;
            }
            else if(key < arr[mid]){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        return -1;
    }


    /*
     *     sqrt(10) : 3.1622776601683795
     *      n = 10;
     */
    public static void sqrtBinarySearch(int n){
        double left = 0, right = n;

        while(right - left > 0.000000000000001){
            double mid = (left + right) / 2;
            System.out.printf("%.15f \n" , mid);

            if(mid * mid < n){
                left = mid;
            }
            else {
                right = mid;
            }
        }





    }


    /*
     * arr: [3, 5, 8, 19, 24, 45, 60]
     * lb(6): 0     lb(19): 3      lb(100): 7   lb(1): 0
     * arr: [1, 1, 5, 5, 7, 7, 10]
     * lb(1): 0     lb(2): 2    lb(8): 6    lb(4): 3
     */
    public static void lowerBound(int arr[], int key){
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int left = 0, right = arr.length;

        while(left < right){
            int mid = (left + right)/2;

            if(arr[mid] == key){
                right = mid;
            }
            else if(key < arr[mid]){
                right = mid;
            }
            else{
                left = mid+1;
            }

        }

        System.out.println(left);
    }


    /*
     * arr: [1, 3, 5, 5, 7, 7, 10]
     * ub(2): 1     ub(5): 4    ub(8): 6    ub(13): 7   ub(0): 0
     */
    public static void upperBound(int arr[], int key){
        int left = 0, right = arr.length;

        while(left < right){
            int mid = (left + right) /2;


        }
    }
}
