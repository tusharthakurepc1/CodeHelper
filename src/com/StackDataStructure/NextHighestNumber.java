package com.StackDataStructure;

import java.util.Arrays;

public class NextHighestNumber {
    public static void main(String[] args) {
        int arr[]={4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6};

//        bruteForce(arr);
        betterSolution(arr);
//        circularArrayBruteSolution(arr);
        circularArrayBetterSolution(arr);
    }

    public static void bruteForce(int arr[]){   //Time O(N^2)   Space O(1)
        int res[]=new int[arr.length];

        for(int i=0;i<arr.length;i++){
            boolean flag=true;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j] > arr[i]){
                    res[i] = arr[j];
                    flag = false;
                    break;
                }
            }
            if(flag){
                res[i] = -1;
            }
        }

        System.out.println(Arrays.toString(res));
    }

    public static void betterSolution(int arr[]){   //Time O(N) Space O(N)
        Stack stack=new Stack(arr.length);
        int res[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty() && arr[i] >= stack.peek()){
                stack.pop();
            }

            if(stack.isEmpty()){
                res[i] = -1;
            }
            else{
                res[i]= stack.peek();
            }

            stack.push(arr[i]);
        }
        stack.displayStack();
        System.out.println(Arrays.toString(res));
    }


    public static void circularArrayBruteSolution(int arr[]){
        int res[]=new int[arr.length];

        for(int i=0;i<(2*arr.length);i++){
            for(int j=i+1;j<(2*arr.length);j++){
                if(arr[j % arr.length] > arr[i % arr.length]){
                    res[i % arr.length] = arr[j % arr.length];
                    break;
                }
            }
            if (res[i % arr.length] == 0) {
                res[i % arr.length] = -1;
            }

        }

        System.out.println(Arrays.toString(res));


    }

    public static void circularArrayBetterSolution(int arr[]){
        Stack stack=new Stack(arr.length*2);
        int res[]=new int[arr.length];

        for(int i=2*arr.length;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() <= arr[i % arr.length]){
                stack.pop();
            }

            if(i < arr.length){
                if(stack.isEmpty()){
                    res[i] = -1;
                }
                else{
                    res[i] = stack.peek();
                }
            }

            stack.push(arr[i % arr.length]);
        }
        System.out.println(Arrays.toString(res));
    }
}
