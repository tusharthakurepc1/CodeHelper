package com.SlidingWindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaximumSlidingWindow {
    public static void main(String[] args) {
        int arr[] = {1,3,-1,-3,5,3,6,7};

//        bruteForce(arr,3);
        optimalSolution(arr,3);
    }

    public static void bruteForce(int arr[],int k){
        int res[] = new int[arr.length-k+1];

        for(int i=0;i<arr.length-k+1;i++){
            int local_max = arr[i];
            for(int j=i;j<=i+k-1;j++){
                if(arr[j] > local_max)  local_max = arr[j];
            }
            res[i] = local_max;
        }

        System.out.println(Arrays.toString(res));
    }

    public static void optimalSolution(int arr[],int k){
        Deque<Integer> dequeue = new ArrayDeque<>();
        int res[] = new int[arr.length-k+1];
        int res_iter = 0;

        for(int i=0;i<arr.length;i++){
            if(!dequeue.isEmpty() && dequeue.peekFirst() == i-k){
                dequeue.pollFirst();
            }

            while(!dequeue.isEmpty() && arr[dequeue.peekLast()] <= arr[i]){
                dequeue.pollLast();
            }

            dequeue.offerLast(i);

            if(i >= k-1){
                res[res_iter++] = arr[dequeue.peekFirst()];
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
