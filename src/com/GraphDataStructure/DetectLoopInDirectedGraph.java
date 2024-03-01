package com.GraphDataStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DetectLoopInDirectedGraph {
    public static void main(String[] args) {
        int edges[][] = {
                {0,1},
                {1,2},
                {2,3},
                {3,0}
        };
        int v = 4;
        int e = 4;

        List<List<Integer>> adj_list = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj_list.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            adj_list.get(edges[i][0]).add(edges[i][1]);
        }


        System.out.println(adj_list);

        System.out.println(detectLoopDirected(adj_list, v, e));
    }

    public static boolean detectLoopDirected(List<List<Integer>> adj_list, int vertices, int edges){
        boolean visited[] = new boolean[vertices];
        boolean path[] = new boolean[vertices];

        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                if(dfs(adj_list, visited, path, i)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean dfs(List<List<Integer>> adj_list, boolean visited[], boolean path[], int ind){
        visited[ind] = true;
        path[ind] = true;

        List<Integer> neighbours = adj_list.get(ind);

        for(int i=0;i<neighbours.size();i++){
            if(visited[neighbours.get(i)] && path[neighbours.get(i)]){
                return true;
            }
            if(!visited[neighbours.get(i)]){
                if(dfs(adj_list, visited, path, neighbours.get(i))){
                    return true;
                }
            }
        }

        path[ind] = false;
        return false;
    }
}
