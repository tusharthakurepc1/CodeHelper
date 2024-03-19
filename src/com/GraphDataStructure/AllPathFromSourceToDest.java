package com.GraphDataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPathFromSourceToDest {
    public static void main(String[] args) {
        int adj_list[][] = {
                {4, 3, 1},
                {3, 2, 4},
                {3},
                {4},
                {}
        };

        List<List<Integer>> res = new ArrayList<>();

        dfs(adj_list, 0, new ArrayList<>(), adj_list.length-1, res);
        System.out.println(res);
    }



    public static void dfs(int adj_list[][], int curr, List<Integer> processed, int dest, List<List<Integer>> res){
        if(curr == dest){
            processed.add(curr);
            res.add(new ArrayList<>(processed));
            processed.remove(processed.size()-1);
            return;
        }

        processed.add(curr);

        for(int child: adj_list[curr]){
            dfs(adj_list, child, processed, dest, res);
        }

        processed.remove(processed.size()-1);

    }
}
