package com.GraphDataStructure;

import java.util.*;

public class DFSTraversal {
    public static void main(String[] args) {
        List<List<Integer>> adj_list = GraphDataStore.storeUnDirGraphDataMeth2Graph2(10);
        System.out.println(adj_list);

        List<Integer> res = traversalDFS(adj_list, 10);

        System.out.println(res);
    }

    public static List<Integer> traversalDFS(List<List<Integer>> adj_list, int v){
        boolean processed_nodes[] = new boolean[v];
        List<Integer> res = new ArrayList<>();

        for(int i = 1; i < processed_nodes.length; i++){
            if(!processed_nodes[i]){
                helper(i, processed_nodes, adj_list, res);
            }
        }
        return res;
    }

    public static void helper(int node,boolean processed[],List<List<Integer>> adj_list, List<Integer> res){
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        processed[node] = true;

        while(!stack.isEmpty()){
            int temp = stack.pop();
            res.add(temp);

            for(int el: adj_list.get(temp)){
                if(!processed[el]){
                    processed[el] = true;
                    stack.push(el);
                }

            }

        }
    }
}
