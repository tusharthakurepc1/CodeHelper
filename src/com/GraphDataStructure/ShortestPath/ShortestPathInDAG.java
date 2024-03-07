package com.GraphDataStructure.ShortestPath;

import java.util.*;

import com.GraphDataStructure.Pair;

public class ShortestPathInDAG {
    public static void main(String[] args) {
//        Edges format edges[i] = (source, destination, weight)
        int edges[][] = {
                {0,1,2},
                {0,4,1},
                {4,5,4},
                {4,2,2},
                {1,2,3},
                {2,3,6},
                {5,3,1},
        };
        int v = 6;

        List<List<List<Integer>>> adj_list = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj_list.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            if(!adj_list.get(edges[i][0]).contains(edges[i][1])){
                adj_list.get(edges[i][0]).add(new ArrayList<>(Arrays.asList(edges[i][1], edges[i][2])));
            }
        }

        System.out.println(adj_list);

        shortestDistance(adj_list, v, 4);

    }

    public static void shortestDistance(List<List<List<Integer>>> adj_list, int nodes, int source){
        int distance[] = new int[nodes];
        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean visited[] = new boolean[nodes];

        bfs(adj_list, visited, distance, source);
    }

    public static void bfs(List<List<List<Integer>>> adj_list, boolean visited[], int distance[], int start){
        Queue<Pair> queue = new LinkedList<>();
//        Pair hold (node_number, edges_sum)
        queue.offer(new Pair(start, 0));
        distance[start] = 0;

        while(!queue.isEmpty()){

            Pair temp = queue.poll();
//            distance[temp.x] = temp.y;
            visited[temp.x] = true;

            //Explore all the child of temp
            int child_no = 0;
            for(List<Integer> el: adj_list.get(temp.x)){

                if(!visited[el.get(0)]){
                    int cost = temp.y + adj_list.get(temp.x).get(child_no++).get(1);
                    queue.offer(new Pair(el.get(0), cost));
                    distance[el.get(0)] = Math.min(distance[el.get(0)], cost);
                }

            }

        }

        for(int i=0;i<distance.length;i++){
            if(distance[i] == Integer.MAX_VALUE){
                distance[i] = -1;
            }
        }

        System.out.println(Arrays.toString(distance));

    }

}
