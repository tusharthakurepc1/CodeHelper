package com.GraphDataStructure.ShortestPath;

import com.GraphDataStructure.Pair;

import java.util.*;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        int edges[][] = {
                {0, 1, 4},
                {0, 2, 4},
                {1, 0, 4},
                {1, 2, 2},
                {2, 0, 4},
                {2, 1, 2},
                {2, 3, 3},
                {2, 4, 1},
                {2, 5, 6},
                {3, 2, 3},
                {3, 5, 2},
                {4, 2, 1},
                {4, 5, 3},
                {5, 2, 6},
                {5, 3, 2},
                {5, 4, 3},
        };
        int nodes = 6;

        List<List<List<Integer>>> adj_list = new ArrayList<>();

        for(int i=0;i<nodes;i++)    adj_list.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            adj_list.get(edges[i][0]).add(new ArrayList<>(Arrays.asList(edges[i][1], edges[i][2])));
        }
        System.out.println(adj_list);

        dijkstraAlgorithm(adj_list, 0);
    }

    public static void dijkstraAlgorithm(List<List<List<Integer>>> adj_list, int source){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)-> (a.x > b.x) ? 1 : -1);

        int distance[] = new int[adj_list.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);

        pq.add(new Pair(0, source));
        distance[source] = 0;

        while(!pq.isEmpty()){
            int temp_dist = pq.peek().x;
            int temp_node = pq.peek().y;
            pq.poll();

            for(int i=0;i<adj_list.get(temp_node).size();i++){

                int child_node = adj_list.get(temp_node).get(i).get(0);
                int child_dist = adj_list.get(temp_node).get(i).get(1);

                int new_dist = temp_dist + child_dist;

                if(new_dist < distance[child_node]){
                    pq.offer(new Pair(new_dist, child_node));
                    distance[child_node] = new_dist;
                }

            }

        }

        System.out.println(Arrays.toString(distance));
    }


    //    Dijkstra Algorithm for single source multiple destination using Priority Queue(MIN heap)
    public static void dijkstraAlgorithm(int adj_list[][][], int source){

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b)-> a.x - b.x);
        pq.offer(new Pair(0, source));

        int distance[] = new int[adj_list.length];
        Arrays.fill(distance, (int)1e9);
        distance[source] = 0;
        System.out.println(Arrays.toString(distance));

        while(pq.size() != 0){

            Pair temp = pq.poll();
            int length = adj_list[temp.y].length;

            for(int i=0; i < length; i++){

                int temp_distance = temp.x + adj_list[temp.y][i][1];
                int temp_node_val = adj_list[temp.y][i][0];

                if(temp_distance < distance[temp_node_val]){
                    pq.add(new Pair(temp_distance, temp_node_val));
                    distance[temp_node_val] = temp_distance;
                }

            }

        }

        System.out.println(Arrays.toString(distance));

    }
}
