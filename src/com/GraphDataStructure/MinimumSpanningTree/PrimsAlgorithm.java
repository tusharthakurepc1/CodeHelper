package com.GraphDataStructure.MinimumSpanningTree;

import com.GraphDataStructure.Pair;
import com.GraphDataStructure.Pair_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    public static void main(String[] args) {
        int v = 5;
        int e = 6;

        List<List<Integer>> edges = new ArrayList<>();

        // (x, y, weight)
        edges.add(new ArrayList<>(Arrays.asList(0, 1, 2)));
        edges.add(new ArrayList<>(Arrays.asList(0, 3, 6)));
        edges.add(new ArrayList<>(Arrays.asList(1, 3, 8)));
        edges.add(new ArrayList<>(Arrays.asList(1, 4, 5)));
        edges.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        edges.add(new ArrayList<>(Arrays.asList(2, 4, 7)));

        List<List<List<Integer>>> adj_list = new ArrayList<>();
        for(int i=0;i<v;i++)    adj_list.add(new ArrayList<>());


        for(int i=0;i<edges.size();i++){

            adj_list.get(edges.get(i).get(0)).add(new ArrayList<>(Arrays.asList(edges.get(i).get(1), edges.get(i).get(2))));
            adj_list.get(edges.get(i).get(1)).add(new ArrayList<>(Arrays.asList(edges.get(i).get(0), edges.get(i).get(2))));

        }

        System.out.println(adj_list);

        findMST(adj_list, v);
    }

    public static void findMST(List<List<List<Integer>>> adj_list, int v){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)-> a.y > b.y ? 1 : -1);
        boolean visited[] = new boolean[v];
        int sum = 0;

        //take the default starting with 0
        pq.offer(new Pair(0, 0));

        while(!pq.isEmpty()){

            int src = pq.peek().x;
            int wt = pq.peek().y;
            pq.poll();

            if(visited[src]){
                continue;
            }

            sum += wt;
            visited[src] = true;


            for(int i=0;i<adj_list.get(src).size();i++){

                int child_dest = adj_list.get(src).get(i).get(0);
                int child_wt = adj_list.get(src).get(i).get(1);

                if(!visited[child_dest]) {
                    pq.offer(new Pair(child_dest, child_wt));
                }

            }

        }


        System.out.println(sum);

    }


}
