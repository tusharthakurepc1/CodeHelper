package com.ArrayDataStructure.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationProblems {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9};
        int processed[]={};

        List<List<Integer>> res=new ArrayList<>();

//        combinationUnique(arr,processed,processed.length);
//        combinationSum(arr,processed,8,res);
//        combinationSumQ2(arr,processed, 7,res);

//        combinationSumQ2M2(arr,0,5,new ArrayList<>(),res);
//        combinationSumQ3M2(arr,0,5,new ArrayList<>(),res);
//        Arrays.sort(arr);
//        combinationSumQ3M3Optimal(arr,0,5,new ArrayList<>(),res);

//        combinationRange(arr,processed,0,2,res);

        combinationSumQ4M1(arr,0,7,3,new ArrayList<>());
//        System.out.println(res);
    }

    public static void combinationRange(int arr[],int processed[],int index,int k,List<List<Integer>> res){
        if(index == arr.length){
            if(processed.length == k){
                List<Integer> res_t=new ArrayList<>();
                for(int el:processed)   res_t.add(el);
                Collections.sort(res_t);

                if(!res.contains(res_t)){
                    res.add(res_t);
                }
                // System.out.println(Arrays.toString(processed));
            }
            return;
        }

        int temp=arr[index];
        combinationRange(arr,processed,index+1,k,res);

        processed=Arrays.copyOf(processed,processed.length+1);
        processed[processed.length-1]=temp;
        combinationRange(arr,processed,index+1,k,res);

    }

    public static void combinationUnique(int arr[],int processed[],int count){
        if(arr.length <=0){
            System.out.println(Arrays.toString(processed));
            return;
        }
        int temp=arr[0];

        arr=Arrays.copyOfRange(arr,1,arr.length);
        combinationUnique(arr,processed,count);

        processed=Arrays.copyOf(processed,count+1);
        processed[count]=temp;
        count++;

        combinationUnique(arr,processed,count);

    }

    public static void combinationSum(int arr[],int processed[],int target,List<List<Integer>> res){
        if(target == 0){
            List<Integer> res_t=new ArrayList<>();
            for(int el:processed)   res_t.add(el);

            Collections.sort(res_t);
            if(!res.contains(res_t)){
                res.add(res_t);
            }
            return;
        }
        if(target < 0 || arr.length <= 0){
            return;
        }

        int temp=arr[0];

        combinationSum(Arrays.copyOfRange(arr,1,arr.length),processed,target,res);

        int processed_temp[]=Arrays.copyOf(processed,processed.length+1);
        processed_temp[processed_temp.length-1]=temp;
        combinationSum(Arrays.copyOfRange(arr,1,arr.length),processed_temp,target-temp,res);

    }

    public static void combinationSumQ2(int arr[],int processed[],int target,List<List<Integer>> res){
        if(target == 0){
//            System.out.println(Arrays.toString(processed));
            List<Integer> res_t=new ArrayList<>();
            for(int el:processed){
                res_t.add(el);
            }
            Collections.sort(res_t);
            if(!res.contains(res_t)){
                res.add(res_t);
            }
            return;
        }
        if(target < 0 || arr.length <= 0){
            return;
        }

        int temp=arr[0];


        if(temp <= target) {
            int processed_temp[] = Arrays.copyOf(processed, processed.length + 1);
            processed_temp[processed_temp.length - 1] = temp;
            combinationSumQ2(arr, processed_temp, target - temp,res);
        }

        combinationSumQ2(Arrays.copyOfRange(arr,1,arr.length),processed,target,res);


    }

    public static void combinationSumQ2M2(int arr[],int i,int target,List<Integer> processed,List<List<Integer>> res){
        if (i == arr.length) {
            if(target == 0){
                List<Integer> res_t=new ArrayList<>(processed);
                Collections.sort(res_t);
                if(!res.contains(res_t))
                    res.add(res_t);
            }
            return;
        }

        int temp=arr[i];
        if(temp <= target){
            processed.add(temp);
            combinationSumQ2M2(arr,i,target-temp,processed,res);
            processed.remove(processed.size()-1);
        }

        combinationSumQ2M2(arr,i+1,target,processed,res);
    }

    public static void combinationSumQ3M2(int arr[],int i,int target,List<Integer> processed,List<List<Integer>> res){
        if(i == arr.length){
            if(target == 0){
                List<Integer> res_t=new ArrayList<>(processed);
                Collections.sort(res_t);
                if(!res.contains(res_t))
                    res.add(res_t);
//                System.out.println(processed);
            }
            return;
        }

        int temp=arr[i];

        if(temp <= target){
            processed.add(temp);
            combinationSumQ3M2(arr,i+1,target-temp,processed,res);
            processed.remove(processed.size()-1);
        }

        combinationSumQ3M2(arr,i+1,target,processed,res);

    }

    public static void combinationSumQ3M3Optimal(int arr[],int ind,int target,List<Integer> processed,
                                                 List<List<Integer>> res){
        if(target == 0){
            List<Integer> res_t=new ArrayList<>(processed);
            if(!res.contains(res_t)){
                res.add(res_t);
            }
            return;
        }

        for(int i=ind;i<arr.length;i++){
            if(i > ind && arr[i] == arr[i-1])   continue;
            if(arr[i] > target) break;

            processed.add(arr[i]);
            combinationSumQ3M3Optimal(arr,i+1,target-arr[i],processed,res);
            processed.remove(processed.size()-1);
        }

    }

    public static void combinationSumQ4M1(int arr[],int count,int target,int k,List<Integer> processed){
        if(count >= arr.length){
            if(target == 0 && processed.size() == k){
                System.out.println(processed+" "+target);
            }
            return;
        }

        int temp=arr[count];

        if(temp <= target){
            processed.add(temp);
            combinationSumQ4M1(arr,count+1,target - temp,k,processed);
            processed.remove(processed.size()-1);
        }
        combinationSumQ4M1(arr,count+1,target,k,processed);

    }
}
