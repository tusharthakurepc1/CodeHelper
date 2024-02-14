package com.ArrayDataStructure.Recursion;

import java.util.*;

public class SubSetSum {
    public static void main(String[] args) {
        int arr[]={1,2,3};

        List<List<Integer>> res=new ArrayList<>();

//        subSetSumA1(arr,0,1,new ArrayList<>(),res);
        subSetUnique(arr,0,new ArrayList<>(),res);

        System.out.println(res);


    }

    public static void subSetUnique(int arr[],int ind,List<Integer> processed,List<List<Integer>> res){
        if(ind == arr.length){
//            System.out.println(processed);
            List<Integer> res_t=new ArrayList<>(processed);
            Collections.sort(res_t);
            if(!res.contains(res_t)){
                res.add(res_t);
            }
            return;
        }

        int temp=arr[ind];

        processed.add(temp);
        subSetUnique(arr,ind+1,processed,res);
        processed.remove(processed.size()-1);

        subSetUnique(arr,ind+1,processed,res);
    }

    public static void subSetSumA1(int arr[],int ind,int target,List<Integer> processed,List<List<Integer>> res){
        if(ind >= arr.length){
            if (target == 0) {
//                System.out.println(processed);
                List<Integer> res_t=new ArrayList<>(processed);
                Collections.sort(res_t);
                if(!res.contains(res_t))
                    res.add(res_t);
            }
            return;
        }

        int temp=arr[ind];
        processed.add(temp);
        subSetSumA1(arr,ind+1,target-temp,processed,res);
        processed.remove(processed.size()-1);

        subSetSumA1(arr,ind+1,target,processed,res);

    }
}
