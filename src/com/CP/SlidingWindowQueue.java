package com.CP;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowQueue {
    public static void main(String[] args) {
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        slidingWindowBruteForce(arr, k);
    }

    public static void slidingWindowBruteForce(int arr[], int k){
        int len = arr.length - k + 1;
        int res[] = new int[len];

        for(int i=0;i<len;i++){
            int maxi = arr[i];
            for(int j=i+1;j<i+k;j++){
                maxi = Math.max(maxi, arr[j]);
            }

            res[i] = maxi;
        }

        System.out.println(Arrays.toString(res));
    }

    public static void slidingWindowOptimal(int arr[], int k){
        Deque<Integer> deque = new ArrayDeque<>();
        int res[] = new int[arr.length-k];
        int res_i = 0;

        for(int i=0;i<arr.length;i++){

            if(!deque.isEmpty() && i-k == deque.peekFirst()){
                deque.pollFirst();
            }

            while(!deque.isEmpty() && arr[deque.peekLast()] < arr[i]){
                deque.pollLast();
            }

            deque.offerLast(arr[i]);

            if(i >= k-1){
                res[res_i++] = arr[deque.peekFirst()];
            }
        }

        System.out.println(Arrays.toString(res));
    }
}
