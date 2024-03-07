package com.GraphDataStructure.ShortestPath;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        int arr[][] = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };


        System.out.println(shortestDistance(arr));

    }

    public static int shortestDistance(int arr[][]){
        PriorityQueue<Pair_Matrix> pq = new PriorityQueue<>((a, b)-> (a.dist > b.dist)? 1: -1);
        int n = arr.length;
        if(arr[0][0] != 0){
            return -1;
        }

        pq.offer(new Pair_Matrix(1, 0, 0));
        int distance[][] = new int[n][n];
        for(int temp[]: distance){
            Arrays.fill(temp, (int)1e9);
        }
        distance[0][0] = 1;

        while(!pq.isEmpty()){

            int temp_dist = pq.peek().dist;
            int temp_x = pq.peek().x;
            int temp_y = pq.peek().y;
            if(temp_x == n-1 && temp_y == n-1){
                return temp_dist;
            }

            pq.poll();

            int deltaX[] = {-1, -1, 0, 1, 1, 1, 0, -1};
            int deltaY[] = {0, 1, 1, 1, 0, -1, -1, -1};

            for(int i=0;i<8;i++){
                int x = temp_x + deltaX[i];
                int y = temp_y + deltaY[i];
                int child_dist = temp_dist + 1;

                if(x >= 0 && x < n && y >=0 && y < n && arr[x][y] == 0 && child_dist < distance[x][y]){
                    distance[x][y] = child_dist;
                    if(x == n-1 && y == n-1)    return child_dist;
                    pq.offer(new Pair_Matrix(child_dist, x, y));
                }
            }

        }

        return -1;
    }

}

class Pair_Matrix{
    int dist;
    int x;
    int y;

    Pair_Matrix(int _dist, int _x, int _y){
        this.dist = _dist;
        this.x = _x;
        this.y = _y;
    }
}
