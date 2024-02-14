package com.TreeDataStructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelWeight {
    public static void main(String[] args) {

        int arr[] = {10, 8, 20, 9, 6, 17};
        int n = 6;


        helper(arr, n);
    }

    public static void helper(int arr[], int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(arr[0]);
        int ind = 0;
        float res = Short.MIN_VALUE;
        System.out.println(res);

        while(!queue.isEmpty()){
            int length = queue.size();

            float node_sum = 0;
            int total_node = 0;

            for(int i=0;i<length;i++){
                int temp = queue.poll();
                total_node += 1;
                node_sum += temp;


//                Left child
                int left = ind * 2 + 1;
                if(left < n){
                    queue.offer(arr[left]);
                }
                int right = ind * 2 + 2;
                if(right < n){
                    queue.offer(arr[right]);
                }
                ind += 1;
            }

            float res_t = node_sum / total_node;
            System.out.println(res_t);

            res = Math.max(res, res_t);
        }

        System.out.println(res);

    }


}
