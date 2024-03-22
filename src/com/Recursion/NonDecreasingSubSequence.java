package com.Recursion;

import java.util.ArrayList;
import java.util.List;

public class NonDecreasingSubSequence {
    public static void main(String[] args) {
        int arr[] = {4,6,7,7};

        List<List<Integer>> res = new ArrayList<>();
        recursiveSolution(arr, 0, -1, new ArrayList<>(), res);

        System.out.println(res);


    }

    public static void recursiveSolution(int arr[], int ind, int prev, List<Integer> res_t, List<List<Integer>> res){
        if(ind == arr.length){
            if(res_t.size() >= 2 && !res.contains(res_t)){
                res.add(new ArrayList<>(res_t));
            }
            return;
        }

        //not-take case
        recursiveSolution(arr, ind + 1, ind, res_t, res);

        //take case if the prev value is smaller
        if(ind == 0 || arr[prev] <= arr[ind]){
            res_t.add(arr[ind]);
            recursiveSolution(arr, ind + 1, ind, res_t, res);
            res_t.remove(res_t.size()-1);
        }


    }

}
