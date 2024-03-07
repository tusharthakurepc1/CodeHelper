package com.GraphDataStructure.ShortestPath;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    public static void main(String[] args) {
        int arr[][] ={
                {1,10,6,7,9,10,4,9},
        };

        System.out.println(getMinimumEffort(arr));
    }

    public static int getMinimumEffort(int arr[][]){
        int n = arr.length;
        int m = arr[0].length;
        PriorityQueue<Pair_Matrix> pq = new PriorityQueue<>((a, b)-> a.dist > b.dist? 1: -1);
        int distance[][] = new int[n][m];

        for(int temp[]: distance){
            Arrays.fill(temp, (int)1e9);
        }
        distance[0][0] = 0;
        pq.offer(new Pair_Matrix(0, 0, 0));

        while(!pq.isEmpty()){
            int temp_diff = pq.peek().dist;
            int temp_x = pq.peek().x;
            int temp_y = pq.peek().y;
            pq.poll();

            if(temp_x == n-1 && temp_y == m-1){
                return temp_diff;
            }

            int deltaX[] = {-1, 0, 1, 0};
            int deltaY[] = {0, 1, 0, -1};

            for(int i=0;i<4;i++){
                int x = temp_x + deltaX[i];
                int y = temp_y + deltaY[i];

                if(x >= 0 && y >= 0 && x < n && y < m){

                    int diff = Math.abs(arr[x][y] - arr[temp_x][temp_y]);
                    int new_diff = Math.max(diff, temp_diff);

                    if(new_diff < distance[x][y]){
                        distance[x][y] = new_diff;
                        pq.offer(new Pair_Matrix(new_diff, x, y));
                    }

                }


            }

        }


        return 0;
    }
}
