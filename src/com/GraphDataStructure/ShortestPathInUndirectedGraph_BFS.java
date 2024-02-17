package com.GraphDataStructure;

import java.util.*;

public class ShortestPathInUndirectedGraph_BFS {
    private Pair temp;

    public static void main(String[] args) {
        int arr[][] = {
                {0, 1},
                {0, 3},
                {1, 3},
                {0, 1},
                {1, 2},
                {3, 4},
                {4, 5},
                {5, 6},
                {2, 6},
                {6, 7},
                {6, 8},
                {7, 8}
        };
        int v = 9;


        List<List<Integer>> adj_list = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj_list.add(new ArrayList<>());
        }

        for(int i=0;i<arr.length;i++){
            if(!adj_list.get(arr[i][0]).contains(arr[i][1])){
                adj_list.get(arr[i][0]).add(arr[i][1]);
            }
            if(!adj_list.get(arr[i][1]).contains(arr[i][0])){
                adj_list.get(arr[i][1]).add(arr[i][0]);
            }
        }

        System.out.println(adj_list);

        shortestDistance(adj_list, v, 2);

    }

    public static void shortestDistance(List<List<Integer>> list, int v, int source){
        int distance[] = new int[v];
        boolean visited[] = new boolean[v];
        Arrays.fill(distance, Integer.MAX_VALUE);

        bfs(list, distance, visited, source);

    }

    //x contain node and y contain cost
    public static void bfs(List<List<Integer>> list, int dis[], boolean visited[], int node){
        Queue<Pair> queue = new LinkedList<>();
        visited[node] = true;
        dis[node] = 0;
        queue.offer(new Pair(node, 0));

        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            visited[temp.x] = true;

            for(int child: list.get(temp.x)){

                if(!visited[child]){
                    int cost = Math.min(dis[child], temp.y+1);
                    dis[child] = cost;
                    queue.offer(new Pair(child, cost));
                }

            }

        }

        System.out.println(Arrays.toString(dis));
    }
}

