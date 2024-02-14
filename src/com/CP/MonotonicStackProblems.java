package com.CP;

import java.util.Arrays;
import java.util.Stack;

public class MonotonicStackProblems {
    public static void main(String[] args) {
        int arr[] = {4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6};

        nextLargestElementBruteForce(arr);
        nextLargestElementOptimal(arr);

    }

    public static void nextLargestElementBruteForce(int arr[]){
        int res[] = new int[arr.length];
        Arrays.fill(res, -1);

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] < arr[j]){
                    res[i] = arr[j];
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(res));


    }

    public static void nextLargestElementOptimal(int arr[]){
        int res[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty() && arr[i] >= stack.peek()){
                stack.pop();
            }

            if(stack.isEmpty()) res[i] = -1;
            else    res[i] = stack.peek();

            if(!stack.isEmpty() && arr[i] < stack.peek()){
                stack.push(arr[i]);
            }
            else if(stack.isEmpty()){
                stack.push(arr[i]);
            }

        }

        System.out.println(Arrays.toString(res));

    }


}
