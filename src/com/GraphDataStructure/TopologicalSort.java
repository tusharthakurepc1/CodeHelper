package com.GraphDataStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {
        int v = 6, e = 4;
        int edges[][] = {
                {5,0},
                {5,2},
                {4,0},
                {4,1},
                {2,3},
                {3,1}
        };
        List<List<Integer>> adj_list = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj_list.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            adj_list.get(edges[i][0]).add(edges[i][1]);
        }


        System.out.println(adj_list);
        topologicalSort(adj_list, v);
    }

    public static void topologicalSort(List<List<Integer>> adj_list, int v){
        boolean visited[] = new boolean[v];
        Stack<Integer> res = new Stack<>();

        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                dfs(adj_list, visited, i, res);
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!res.isEmpty()){
            result.add(res.pop());
        }

        System.out.println(result);
    }

    private static void dfs(List<List<Integer>> adj_list, boolean visited[], int ind, Stack<Integer> res){
        visited[ind] = true;

//        Traverse for the depth
        List<Integer> neighbours = adj_list.get(ind);
        for(int i=0;i<neighbours.size();i++){
            if(!visited[neighbours.get(i)]){
                dfs(adj_list, visited, neighbours.get(i), res);
            }
        }

        res.push(ind);
    }

}
