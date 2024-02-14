package com.CP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopologicalOrder {
    public static void main(String[] args) {
        int arr[][] = {
                {1, 2},
                {},
                {3},
                {4},
                {},
                {1, 4}
        };

        topoSort(arr);
    }

    public static List<Integer> topoSort(int arr[][]){
        List<Integer> res = new ArrayList<>();

        boolean visited[] = new boolean[arr.length];
        for(int i=0;i<arr.length;i++){
            if(!visited[i]) {
                dfs(arr, visited, i, res);
            }
        }

        Collections.reverse(res);
        return res;
    }


    public static void dfs(int list[][], boolean visited[], int curr, List<Integer> res){
        visited[curr] = true;

        for(int child : list[curr]){
            if(!visited[child]){
                dfs(list, visited, child, res);
            }
        }

//        System.out.println(curr);
        res.add(curr);

    }
}
