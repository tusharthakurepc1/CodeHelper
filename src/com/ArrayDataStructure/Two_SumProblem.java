package com.ArrayDataStructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Two_SumProblem {
    public static void main(String[] args) {
        int arr[]={3,4,1,9,6,6,2};

//        bruteForce(arr,10);
        betterSol(arr,10);
//        optimal_greedyApproach(arr,10);

    }
    public static void bruteForce(int arr[],int k){     //O(N^2)
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(i==j)    continue;

                if(arr[i] + arr[j] == k){
                    System.out.println("("+i+" "+j+")");
                    return;
                }
            }
        }
        System.out.println("-1");
    }

    public static void betterSol(int arr[],int key){
        Map<Integer,Integer> m1=new HashMap<>();

        int temp=0;
        for(int i=0;i<arr.length;i++){
            temp=key-arr[i];
            if(m1.containsKey(temp)){
                System.out.println(m1.get(temp)+" "+i);
//                return;
            }
            else{
                m1.put(arr[i],i);
            }
        }

    }

    public static void optimal_greedyApproach(int arr[],int key){
        Arrays.sort(arr);
        int left= 0,right=arr.length-1;
        int sum=0;

        for(int i=0;i<arr.length;i++){
            sum=arr[left]+arr[right];
            if(sum == key){
                System.out.println("Exists");
                return;
            }
            else if(sum > key){
                right--;
            }
            else{
                left++;
            }
        }
        System.out.println("-1");


    }
}
