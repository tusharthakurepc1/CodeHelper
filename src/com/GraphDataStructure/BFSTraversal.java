package com.GraphDataStructure;

import java.util.*;

public class BFSTraversal {
    public static void main(String[] args) {
        List<List<Integer>> adj_list= GraphDataStore.storeUnDirGraphDataMeth2Graph2(10);

//        System.out.println(adj_list);
        traversalBFS(adj_list,10);
    }

    public static void traversalBFS(List<List<Integer>> adj_list,int v){
        boolean processed_nodes[] = new boolean[v];
        List<Integer> res = new ArrayList<>();
        System.out.println(adj_list);

        System.out.println(Arrays.toString(processed_nodes));

        for(int i=1;i<processed_nodes.length;i++){
            if (!processed_nodes[i]) {
                helper(i,processed_nodes,adj_list,res);
            }
        }

        System.out.println(res);
    }

    public static void helper(int node,boolean processed[],List<List<Integer>> adj_list,List<Integer> res){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        processed[node] = true;

        while(!queue.isEmpty()){
            int temp = queue.poll();
            res.add(temp);

            for(int el: adj_list.get(temp)){
                if(!processed[el]){
                    processed[el] = true;
                    queue.offer(el);
                }
            }
        }
    }
}
