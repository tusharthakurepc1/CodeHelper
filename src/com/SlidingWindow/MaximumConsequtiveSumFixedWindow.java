package com.SlidingWindow;

public class MaximumConsequtiveSumFixedWindow {
    public static void main(String[] args) {
        int arr[] = {-1, 2, 3, 3, 4, 5, -1};
        int window_size = 4;

        getMax(arr, window_size);

    }

    public static void getMax(int arr[], int window_size){
        int start = 0, end = window_size-1;
        int sum = 0;
        for(int i=start; i<=end; i++)    sum += arr[i];
        int maxi = sum;

        while(end < arr.length-1){
            sum -= arr[start];
            start++;
            end++;
            sum += arr[end];

            maxi = Math.max(maxi, sum);
        }

        System.out.println(maxi);
    }
}
