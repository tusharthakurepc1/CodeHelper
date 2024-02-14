package com.StackDataStructure;

import com.BasicLibTCT;
import java.util.Stack;

import java.util.Arrays;

public class LargestRectangle {
    public static void main(String[] args) {
        int arr[]={2,1,5,6,2,3,1};


//        bruteForce(arr);
//        nextLeftSmaller(arr);
//        nextRightSmaller(arr);
        optimalSolution(arr);
    }
    public static void bruteForce(int arr[]){
        int max_area = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int left = i , right = i;

            while(left > 0 && arr[left-1] >= arr[i]){
                left--;
            }
            while(right < arr.length-1 && arr[i] <= arr[right+1]){
                right++;
            }
            int area = ((right - left) + 1) * arr[i];
            max_area = BasicLibTCT.max(area, max_area);
        }

        System.out.println(max_area);
    }

    public static int[] nextLeftSmaller(int arr[]){
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[arr.length];

        for(int i=0;i<arr.length;i++){

            while(!stack.empty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.empty())
                res[i] = 0;
            else
                res[i] = stack.peek() + 1;

            stack.push(i);
        }
        return res;
    }

    public static int[] nextRightSmaller(int arr[]){
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[arr.length];

        for(int i=arr.length-1;i>=0;i--){
            while(!stack.empty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.empty())
                res[i] = arr.length-1;
            else
                res[i] = stack.peek()-1;
            stack.push(i);

        }

        return res;
    }

    public static void optimalSolution(int arr[]){
        int left_smaller[] = nextLeftSmaller(arr);
        int right_smaller[] = nextRightSmaller(arr);

        int max_area = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){

            int area = (right_smaller[i] - left_smaller[i] +1) * arr[i];

            max_area = BasicLibTCT.max(max_area, area);
        }

        System.out.println(max_area);

    }
}
