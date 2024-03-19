package com.GraphDataStructure.ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFordAlgorithm {
    public static void main(String[] args) {

        int edges[][] = {
            {3, 2, 6},
            {5, 3, 1},
            {0, 1, 5},
            {1, 5, -3},
            {1, 2, -2},
            {3, 4, -2},
            {2, 4, 3}
        };
        int n = 6;

/*
*   Bellman ford algorithm is a shortest path finding algo
*   Condition to work with Bellman ford algo is graph should be directed only.
*
*   It used for calculate having negative weight
*
* 1. relax all edges n-1 times sequentially
*       relax meaning(similar as dijkstra)  :    if(dis[u] + wt < dis[v])
*                               dis[v] = dis[u] + wt;
*/

        bellmanFordAlgo(edges, n);


    }

    public static void bellmanFordAlgo(int edges[][], int n){
        int distance[] = new int[n];
        Arrays.fill(distance, (int)1e9);
        distance[0] = 0;

        for(int i=0;i<n-1;i++){
            //For n-1 times iteration

            for(int j=0;j<edges.length;j++){

                int source = distance[edges[j][0]];
                int dest = distance[edges[j][1]];

                if(source == (int)1e9)  continue;

                int new_dis = source + edges[j][2];

                if(new_dis < dest){
                    distance[edges[j][1]] = new_dis;
                }

            }
        }

        System.out.println(Arrays.toString(distance));

    }

}
