package com.SlidingWindow;

public class MaximumPointObtainFromCards {
    public static void main(String[] args) {

        int arr[] = {6, 2, 3, 4, 7, 2, 1, 7, 1};
        int k = 4;

        solution(arr, k);

    }

    //Time Complexity: 2(K)     Space Complexity: O(1)
    public static void solution(int arr[], int k){

        int left_sum = 0, right_sum = 0;
        for(int i=0;i<k;i++)    left_sum += arr[i];

        int maxi = left_sum;
        int right = arr.length-1;

        for(int i=k-1; i>=0; i--){

            left_sum -= arr[i];
            right_sum += arr[right];
            right --;

            maxi = Math.max(maxi, left_sum + right_sum);
        }

        System.out.println(maxi);




    }

}
