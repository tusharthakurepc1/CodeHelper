package com.GraphDataStructure.ShortestPath;

import com.GraphDataStructure.Pair;

import java.util.*;

public class CheapestFlightWithInKStops {
    public static void main(String[] args) {
        int edges[][] = {
                {0, 1, 5},
                {0, 3, 2},
                {3, 1, 2},
                {1, 2, 5},
                {1, 4, 1},
                {4, 2 ,1}
        };

        int n = 5;
        int source = 0, destination = 2;
        int k = 2;

        List<List<List<Integer>>> adj_list = new ArrayList<>();
        for(int i=0;i<n;i++)    adj_list.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            adj_list.get(edges[i][0]).add(new ArrayList<>(Arrays.asList(edges[i][1], edges[i][2])));
        }

        System.out.println(adj_list);

        shortestDistance(adj_list, source, destination, k, n);
    }

    public static void shortestDistance(List<List<List<Integer>>> adj_list, int source, int destination, int k, int n){
        //hops, distance, node
        Queue<Pair_3> queue = new LinkedList<>();
        int distance[] = new int[n];

        Arrays.fill(distance, (int)1e9);
        distance[source] = 0;
        queue.offer(new Pair_3(0, 0, source));

        while(!queue.isEmpty()){

            int temp_hop = queue.peek().first;
            int temp_distance = queue.peek().second;
            int temp_node = queue.peek().third;
            queue.poll();

            if(temp_hop > k)    continue;

            for(int i=0;i<adj_list.get(temp_node).size();i++){

                int child_node = adj_list.get(temp_node).get(i).get(0);
                int child_distance = adj_list.get(temp_node).get(i).get(1);

                int new_distance = temp_distance + child_distance;
                int new_hop = temp_hop + 1;

                if(new_distance < distance[child_node] && new_hop <= k+1){
                    distance[child_node] = new_distance;
                    queue.offer(new Pair_3(new_hop, new_distance, child_node));
                }

            }

        }
        System.out.println(Arrays.toString(distance));

    }

}

class Pair_3{
    int first;
    int second;
    int third;

    Pair_3(int _a, int _b, int _c){
        this.first = _a;
        this.second = _b;
        this.third = _c;
    }
}
