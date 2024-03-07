package com.GraphDataStructure.ShortestPath;

import com.GraphDataStructure.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm__Path {
    public static void main(String[] args) {
        int edges[][] = {
                {0, 1, 2},
                {0, 3, 1},
                {3, 2, 3},
                {1, 2, 4},
                {1, 4, 5},
                {2, 4, 1},
        };
        int nodes = 5;

        List<List<List<Integer>>> adj_list = new ArrayList<>();

        for(int i=0;i<nodes;i++)    adj_list.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            adj_list.get(edges[i][0]).add(new ArrayList<>(Arrays.asList(edges[i][1], edges[i][2])));
            adj_list.get(edges[i][1]).add(new ArrayList<>(Arrays.asList(edges[i][0], edges[i][2])));
        }
        System.out.println(adj_list);

        getPathDijkstraAlgorithm(adj_list, 0, nodes-1);
    }

    public static void getPathDijkstraAlgorithm(List<List<List<Integer>>> adj_list, int source, int destination){
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b)-> (a.x > b.x)? 1: -1);
        int distance[] = new int[adj_list.size()];
        int parent[] = new int[adj_list.size()];

        for(int i=0;i<parent.length;i++)    parent[i] = i;
        Arrays.fill(distance, (int)1e9);
        distance[source] = 0;

        pq.offer(new Pair(0, source));

        while(!pq.isEmpty()){
            int temp_node = pq.peek().y;
            int temp_dist = pq.peek().x;
            pq.poll();

            for(int i=0;i<adj_list.get(temp_node).size();i++){

                int child_node = adj_list.get(temp_node).get(i).get(0);
                int child_dist = adj_list.get(temp_node).get(i).get(1);

                int total_dist = temp_dist + child_dist;

                if(total_dist < distance[child_node]){
                    pq.offer(new Pair(total_dist, child_node));
                    distance[child_node] = total_dist;

                    parent[child_node] = temp_node;
                }

            }

        }

        System.out.println(Arrays.toString(distance));
        System.out.println(Arrays.toString(parent));
        List<Integer> path = new ArrayList<>();

        int temp = parent[destination];
        path.add(destination);

        while(temp != source){
            path.add(0, temp);
            temp = parent[temp];
            if(temp == destination) return;
        }
        path.add(0, source);

        System.out.println(path);

    }

}
