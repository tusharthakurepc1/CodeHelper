package com.Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int arr[] = {2,3,6,7};

// LeetCode Qno: 39
        List<List<Integer>> res = new ArrayList<>();
        recursiveLogic(arr, 7, arr.length-1, new ArrayList<>(), res);

        System.out.println(res);
    }


    public static void recursiveLogic(int arr[], int target, int ind, List<Integer> res_t, List<List<Integer>> res){
        if(target <= 0){
            if(target == 0){
                List<Integer> temp = new ArrayList<>(res_t);
                Collections.sort(temp);
                res.add(temp);
            }
            return;
        }
        if(ind < 0){
            if(target == 0){
                List<Integer> temp = new ArrayList<>(res_t);
                Collections.sort(temp);
                res.add(temp);
            }
            return;
        }

//        Take the element at ind
        res_t.add(arr[ind]);
        recursiveLogic(arr, target - arr[ind], ind, res_t, res);
        res_t.remove(res_t.size()-1);

//        Don't take the element
        recursiveLogic(arr, target, ind-1, res_t, res);
    }
}
