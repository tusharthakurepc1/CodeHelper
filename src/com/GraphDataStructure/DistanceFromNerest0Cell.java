package com.GraphDataStructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceFromNerest0Cell {
    public static void main(String[] args) {
        int adj_matrix[][] = {
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };


        nearestDistance(adj_matrix);
    }

    public static void nearestDistance(int adj_matrix[][]){
        Queue<Pair> queue = new LinkedList<>();
        boolean visited[][] = new boolean[adj_matrix.length][adj_matrix[0].length];

        for(int i=0;i<adj_matrix.length;i++){
            for(int j=0;j<adj_matrix[0].length;j++){
                if(adj_matrix[i][j] == 0){
                   queue.offer(new Pair(i, j));
                   visited[i][j] = true;
                }
            }
        }

        int level = 0;
        while(!queue.isEmpty()){
            int length = queue.size();
            boolean flag = true;

            for(int i=0;i<length;i++){
                Pair temp = queue.poll();
                int x = temp.x;
                int y = temp.y;


                int deltaX[] = {-1, 0, 1, 0};
                int deltaY[] = {0, 1, 0, -1};

                for(int j = 0;j<deltaX.length;j++){
                    if(flag){
                        level++;
                        flag = false;
                    }
                    int new_x = x + deltaX[j];
                    int new_y = y + deltaY[j];

                    if(new_x >=0 && new_x < adj_matrix.length && new_y >=0 && new_y < adj_matrix[0].length
                        && adj_matrix[new_x][new_y] == 1 && !visited[new_x][new_y]){

                        queue.offer(new Pair(new_x, new_y));
                        visited[new_x][new_y] = true;
                        adj_matrix[new_x][new_y] = level;
                    }

                }
            }

        }


        for(int[] temp: adj_matrix){
            System.out.println(Arrays.toString(temp));
        }

    }
}
