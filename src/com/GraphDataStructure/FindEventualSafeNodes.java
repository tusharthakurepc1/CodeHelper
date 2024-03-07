package com.GraphDataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindEventualSafeNodes {
    public static void main(String[] args) {
        int adj_list[][] = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };

        safeNodes(adj_list);
    }



    public static void safeNodes(int adj_list[][]){
        List<Integer> res = new ArrayList<>();

        for(int i=0;i< adj_list.length;i++){
            boolean visited[] = new boolean[adj_list.length];
            boolean path[] = new boolean[adj_list.length];

            if(!dfs(adj_list, i, path, visited)){
                res.add(i);
            }

        }

        System.out.println(res);
    }

    public static boolean dfs(int adj_list[][], int curr, boolean path[], boolean visited[]){

        path[curr] = true;
        visited[curr] = true;

        //Explore all the neighbours
        for(int el: adj_list[curr]){
            if(visited[el] && path[el]){
                return true;
            }
            if(!visited[el]){
                if(dfs(adj_list, el, path, visited)){
                    return true;
                }
            }
        }

        path[curr] = false;
        return false;
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
