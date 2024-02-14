package com.CP;

import java.util.*;

public class PartationArrayIntoMaxSum {
    public static void main(String[] args) {
        int arr[] = {8,8,10};
        int k = 1;

        System.out.println(Arrays.toString(arr));
        partitionSum(arr, k);
    }

    public static void partitionSum(int arr[], int k){
        Deque<Integer> queue = new ArrayDeque<>();
        int res[] = new int[arr.length];
        int res_iter = 0;

        for(int i=0;i<k;i++){
            if(!queue.isEmpty() &&  queue.peek() < arr[i]){
                queue.poll();
            }
            queue.offer(arr[i]);
        }
        res[res_iter++] = queue.peek();

        for(int i=1;i<arr.length - (k/2)-1;i++){
//            Check is the peek element belongs to the sliding window
            int prev_index_el = i - (k/2) -1;
            if(!queue.isEmpty() && prev_index_el >= 0 && queue.peekFirst() == arr[prev_index_el]){
                queue.pollFirst();
            }

//            Check if the queue follow monotonic property.
            int new_index_el = i + (k/2) +1;
//            System.out.println(arr[new_index_el]);
            while(!queue.isEmpty() && new_index_el < arr.length && queue.peekLast() <= arr[new_index_el]){
                queue.pollLast();
            }

            queue.offerLast(arr[new_index_el]);

            res[i] = queue.peek();
        }

        for(int i=res.length- (k/2)-1;i<res.length;i++){
            int prev_index_el = i - (k/2) -1;
            if(!queue.isEmpty() && prev_index_el >= 0 && queue.peekFirst() == arr[prev_index_el]){
                queue.pollFirst();
            }

            queue.offerLast(arr[i]);
            res[i] = queue.peek();
        }


        System.out.println("Qu: "+queue);
//        System.out.println(queue.peek());
        System.out.println(Arrays.toString(res));
        int sum = 0;
        for(int el: res){
            sum+=el;
        }
        System.out.println("Sum: "+sum);
    }

}
