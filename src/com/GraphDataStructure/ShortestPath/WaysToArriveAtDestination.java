package com.GraphDataStructure.ShortestPath;

import com.GraphDataStructure.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class WaysToArriveAtDestination {
    public static void main(String[] args) {

        int edges[][] = new int[][]{
                {0, 6, 7},
                {0, 1, 2},
                {1, 2, 3},
                {1, 3, 3},
                {6, 3, 3},
                {3, 5, 1},
                {6, 5, 1},
                {2, 5, 1},
                {0, 4, 5},
                {4, 6, 2}
        };
        int n = 7;
        List<List<List<Integer>>> adj_list = new ArrayList<>();
        for(int i=0;i<n;i++)    adj_list.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            adj_list.get(edges[i][0]).add(new ArrayList<>(Arrays.asList(edges[i][1], edges[i][2])));
            adj_list.get(edges[i][1]).add(new ArrayList<>(Arrays.asList(edges[i][0], edges[i][2])));
        }

        System.out.println(adj_list);

        getMinimumDistance(adj_list, 0, n);

    }

    public static void getMinimumDistance(List<List<List<Integer>>> adj_list, int source, int n){
        int mod = (int)(1e9 + 7);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.x > b.x) ? 1 : -1);
        pq.offer(new Pair(0, source));

        int distance[] = new int[n];
        int total_path[] = new int[n];
        for(int i=0;i<n;i++){
            distance[i] = Integer.MAX_VALUE;
            total_path[i] = 0;
        }

        distance[source] = 0;
        total_path[source] = 1;


        while(!pq.isEmpty()){

            int temp_dist = pq.peek().x;
            int temp_node = pq.peek().y;
            pq.poll();

            for(int i=0;i<adj_list.get(temp_node).size();i++){

                int node = adj_list.get(temp_node).get(i).get(0);
                int dist = adj_list.get(temp_node).get(i).get(1);

                int new_dist = temp_dist + dist;

                if(new_dist < distance[node]){
                    total_path[node] = total_path[temp_node];
                    distance[node] = new_dist;
                    pq.offer(new Pair(new_dist, node));
                }
                else if(new_dist == distance[node]){
                    total_path[node] = (total_path[temp_node] + total_path[node]) % mod;
                }

            }

        }

        System.out.println(Arrays.toString(distance));
        System.out.println(Arrays.toString(total_path));


    }


}
