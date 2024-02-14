package com.BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9};

//        peterAndComb(arr);
//        combinationsUnique(arr);
//        combinationRangePS(arr,2);

        combinationSumPS(arr,3,9);
    }

    public static void peterAndComb(int arr[]){
        boolean flag=false;

        int size=1 << arr.length;

        for(int i=0;i<size;i++){
            int sum=0;
            for(int j=0;j<arr.length;j++) {
                int n = i;
                if ((n & (1 << j)) == 0) {
                    sum -= arr[j];
                } else {
                    sum += arr[j];
                }
            }
            if(sum == 0){
                System.out.println("Yes");
                break;
            }
        }

    }

    public static void combinationsUnique(int arr[]){
        int size=1 << arr.length;
        List<List<Integer>> res=new ArrayList<>();

        for(int i=0;i<size;i++){
            List<Integer> res_t=new ArrayList<>();
            for(int j=0;j<arr.length;j++){
                int n=i;
                if((n & (1 << j)) != 0){
                    res_t.add(arr[j]);
                }
            }
            res.add(res_t);
        }

        System.out.println(res);

    }

    public static void combinationRangePS(int arr[],int k){
        int n=1 << arr.length;

        for(int i=0;i<n;i++){
            int temp=i;
            List<Integer> res_t=new ArrayList<>();
            int j=0;
            while(temp != 0){
                if(res_t.size() >= k)   break;
                if((temp & 1) == 1){
                    res_t.add(arr[j]);
                }
                j++;
                temp=temp>>1;
            }
            if(res_t.size() == k){
                System.out.println(res_t);
            }
        }

    }

    public static void combinationSumPS(int arr[],int k,int target){
        int n=1 << arr.length;

        for(int i=0;i<n;i++){
            int temp=i;
            List<Integer> res_t=new ArrayList<>();
            int len=0;
            while(temp != 0){
                if((temp & 1) == 1){
                    res_t.add(len);
                }
                len++;
                temp = temp >> 1;
            }
            System.out.println(res_t);

        }
    }
}
