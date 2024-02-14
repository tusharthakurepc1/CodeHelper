package com.StackDataStructure;

import java.util.*;
import java.util.Stack;

public class NextGraterElement {
    public static void main(String[] args) {
        int arr[]={1,8,-1,-100,-1,222,1111111,-111111};
        int disp[]={4,1,2};

//        optimalSolution(arr,disp);
//        rotatedOptimalSolution(arr);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println(queue.peek());
        System.out.println(queue);

    }

    public static int getMax(int arr[]){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }

        return max;
    }

    public static void optimalSolution(int arr[],int disp[]){
        Stack<Integer> stack = new Stack<>();
        int nge[] = new int[getMax(arr) + 1];

        for(int i=arr.length-1;i>=0;i--){

            while(!stack.empty() && stack.peek() <= arr[i]){
                stack.pop();
            }
            if(stack.empty())
                nge[arr[i]] = -1;
            else
                nge[arr[i]] = stack.peek();

            stack.push(arr[i]);

        }

        int res[] = new int[disp.length];
        for(int i=0;i<res.length;i++){
            res[i] = nge[disp[i]];
        }


        System.out.println(Arrays.toString(nge));
    }

    public static void optimalSolutionM2(int arr[],int disp[]){
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=arr.length-1;i>=0;i--){

            while(!stack.empty() && stack.peek() <= arr[i]){
                stack.pop();
            }
            if(stack.empty())
                map.put(arr[i], -1);
            else
                map.put(arr[i], stack.peek());

            stack.push(arr[i]);

        }
        System.out.println(map);
        int res[] = new int[disp.length];
        for(int i=0;i<disp.length;i++){
            res[i] = map.get(disp[i]);
        }
        System.out.println(Arrays.toString(res));

    }

    public static void rotatedOptimalSolution(int arr[]){
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[arr.length];

        for(int i=arr.length-1;i>=0;i--){

            while(!stack.empty() && stack.peek() <= arr[i]){
                stack.pop();
            }
            if(stack.empty())
                res[i] = -1001;
            else
                res[i] = stack.peek();

            stack.push(arr[i]);
        }
        System.out.println(Arrays.toString(res));
        for(int i=arr.length-1;i>=0;i--){
            if(res[i] == -1001){
                while(!stack.isEmpty() && stack.peek() <= arr[i]){
                    stack.pop();
                }

                if(stack.empty())
                    res[i] = -1;
                else
                    res[i] = stack.peek();

                stack.push(arr[i]);
            }
        }

        System.out.println(Arrays.toString(res));
    }
}
