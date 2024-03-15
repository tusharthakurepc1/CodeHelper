package com.GraphDataStructure.ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public static void main(String[] args) {
        int edges[][] = {
                {1, 2, 1},
        };

        int source = 2;
        int n = 3;

        List<List<List<Integer>>> adj_list = new ArrayList<>();
        for(int i=0;i<n;i++)    adj_list.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            adj_list.get(edges[i][0]).add(new ArrayList<>(Arrays.asList(edges[i][1], edges[i][2])));
        }

        System.out.println(adj_list);

        getMinimumTime(adj_list, source, n);
    }

    public static void getMinimumTime(List<List<List<Integer>>> adj_list, int source, int n){
        PriorityQueue<Pair_2> pq = new PriorityQueue<>((a, b)-> a.first > b.first ? 1 : -1);
        int distance[] = new int[n];

        Arrays.fill(distance, (int)1e9);
        distance[source] = 0;
        pq.offer(new Pair_2(0, source));


        while(!pq.isEmpty()){

            int temp_distance = pq.peek().first;
            int temp_node = pq.peek().second;
            pq.poll();

            for(int i=0;i < adj_list.get(temp_node).size();i++){

                int child_node = adj_list.get(temp_node).get(i).get(0);
                int child_distance = adj_list.get(temp_node).get(i).get(1);

                int new_distance = temp_distance + child_distance;

                if(new_distance < distance[child_node]){
                    distance[child_node] = new_distance;
                    pq.offer(new Pair_2(new_distance, child_node));
                }

            }

        }

        int res = -1;
        for(int i=0;i<n;i++){
            if(distance[i] == (int)1e9) continue;
            res = distance[i];
        }

        System.out.println(Arrays.toString(distance));
        

    }
}


class Pair_2{
    int first;
    int second;

    Pair_2(int _a, int _b){
        this.first = _a;
        this.second = _b;
    }
}

