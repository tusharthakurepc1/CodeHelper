package com.GraphDataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindEventualSafeNodes {
    public static void main(String[] args) {
        int adj_list[][] = {
                {},
                {0, 2, 3, 4},
                {3},
                {4},
                {}
        };

//        safeNodes(adj_list);
        System.out.println(detectCycleUndirected(adj_list, new boolean[adj_list.length], 1));

    }

    public static void safeNodes(int adj_list[][]){
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<adj_list.length;i++){
            if(!detectCycleUndirected(adj_list, new boolean[adj_list.length], i)){
                res.add(i);
            }
        }

        Collections.sort(res);
        System.out.println(res);
    }

    public static boolean detectCycleUndirected(int adj_list[][], boolean visited[], int ind){
        //DFS-- Recursive
        visited[ind] = true;

        for(int i=0;i<adj_list[ind].length;i++){
//            Traverse Neighbours
            if(visited[adj_list[ind][i]] && visited[ind]){
                return true;
            }
            if(!visited[adj_list[ind][i]]){
                boolean temp = detectCycleUndirected(adj_list, visited, adj_list[ind][i]);
                System.out.println(temp +" "+ ind);
                if(temp){
                    return true;
                }
            }
        }
        visited[ind] = false;

        return false;
    }
}
