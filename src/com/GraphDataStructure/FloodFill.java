package com.GraphDataStructure;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {
        int adj_mat[][] = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };


        floodFill(adj_mat, 1, 1, 2);
    }

    public static void floodFill(int[][] adj_matrix, int sr, int sc, int new_color){
        boolean visited[][] = new boolean[adj_matrix.length][adj_matrix[0].length];

        bfs(adj_matrix, visited, sr, sc, new_color);

        for(int[] temp: adj_matrix){
            System.out.println(Arrays.toString(temp));
        }
    }

    public static void bfs(int adj_matrix[][], boolean visited[][], int row, int col, int new_color){
        Queue<Pair> queue = new LinkedList<>();
        int previous_color = adj_matrix[row][col];
        if(previous_color != new_color){

            queue.offer(new Pair(row, col));
            visited[row][col] = true;

            while(!queue.isEmpty()){
                Pair temp = queue.poll();
                int x = temp.x;
                int y = temp.y;
                adj_matrix[x][y] = new_color;

//                Add neighbour to the queue

                int deltaX[] = {-1, 0, 1, 0};
                int deltaY[] = {0, 1, 0, -1};


                for(int i=0;i< deltaX.length;i++){
                    int new_x = x + deltaX[i];
                    int new_y = y + deltaY[i];

                    if(new_x >= 0 && new_x < adj_matrix.length && new_y >=0 && new_y < adj_matrix[0].length
                           && adj_matrix[new_x][new_y] == previous_color && !visited[new_x][new_y]){
                        queue.offer(new Pair(new_x, new_y));
                        visited[new_x][new_y] = true;
                    }

                }

            }

        }


    }
}
