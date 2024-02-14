package com.GraphDataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectLoopInUndirectedGraph {
    public static void main(String[] args) {
        List<List<Integer>> adj_list = new ArrayList<>();
        for(int i=0;i<4;i++){
            adj_list.add(new ArrayList<>());
        }

        adj_list.get(0).add(1);
        adj_list.get(1).add(0);

        adj_list.get(1).add(2);
        adj_list.get(2).add(1);

        adj_list.get(2).add(3);
        adj_list.get(3).add(2);

        adj_list.get(3).add(0);
        adj_list.get(0).add(3);

        System.out.println(adj_list);

        System.out.println(detectCycle(adj_list, adj_list.size()));
    }
    public static boolean detectCycle(List<List<Integer>> adj_list, int V){
        Queue<PairOfTwo> queue = new LinkedList<>();
        boolean visited[] = new boolean[V];

        queue.offer(new PairOfTwo(0, -1));
        visited[0] = true;

        while(!queue.isEmpty()){
//            System.out.println(queue);
            PairOfTwo temp = queue.poll();
            int node = temp.node;
            int parent = temp.parent;

            int length = adj_list.get(node).size();
            for(int i = 0;i<length;i++){
                if(adj_list.get(node).get(i) != parent){
                    if(visited[adj_list.get(node).get(i)]){
                        return true;
                    }
                    queue.offer(new PairOfTwo(adj_list.get(node).get(i), node));
                    visited[adj_list.get(node).get(i)] = true;
                }
            }
        }

        return false;
    }
}

class PairOfTwo{
    public int node;
    public int parent;

    PairOfTwo(int _node, int _parent){
        this.node = _node;
        this.parent = _parent;
    }
}
