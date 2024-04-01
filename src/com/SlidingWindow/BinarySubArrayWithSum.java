package com.SlidingWindow;

public class BinarySubArrayWithSum {
    public static void main(String[] args) {
        int arr[] = {1,0,1,0,1};
        int target = 2;

        solution(arr, target);
    }

    public static void solution(int arr[], int target){
        int start = 0;
        int end = 0;
        int sum = 0;

        int count = 0;

        while(start <= end && end < arr.length){

            if(sum == target)   count += 1;

            if(sum > target){
                sum -= arr[start];
                start++;
            }
            else{
                sum += arr[end];
                end++;
            }

        }

        System.out.println(count);

    }

}
