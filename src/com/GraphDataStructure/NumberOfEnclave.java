package com.GraphDataStructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclave {
    public static void main(String[] args) {
        int adj_matrix[][] = {
                {0,0,0,1,1,1,0,1,0,0},
                {0,0,0,1,1,1,0,1,0,0}
        };

        noOfEnclave(adj_matrix);
    }


    public static void noOfEnclave(int adj_matrix[][]){
        boolean visited[][] = new boolean[adj_matrix.length][adj_matrix[0].length];

        for(int i=0;i<adj_matrix[0].length;i++){
            if(adj_matrix[0][i] == 1){
//                System.out.println(adj_matrix[0][i]);
                dfs(adj_matrix, visited, 0, i);
            }
        }

        for(int i=1;i<adj_matrix.length;i++){
            if(adj_matrix[i][adj_matrix[0].length-1] == 1){
//                System.out.println(adj_matrix[i][adj_matrix[0].length-1]);
                dfs(adj_matrix, visited, i, adj_matrix[0].length-1);
            }
        }

        for(int i=adj_matrix[0].length-2;i>=0;i--){
            if(adj_matrix[adj_matrix.length-1][i] == 1){
//                System.out.println(adj_matrix[adj_matrix.length-1][i]);
                dfs(adj_matrix, visited, adj_matrix.length-1, i);
            }
        }

        for(int i=adj_matrix.length-1;i>=0;i--){
            if(adj_matrix[i][0] == 1){
//                System.out.println(adj_matrix[i][0]);
                dfs(adj_matrix, visited, i, 0);
            }
        }

        int res = 0;
        for(int i=0;i<adj_matrix.length;i++){
            for(int j=0;j<adj_matrix[0].length;j++){
                if(adj_matrix[i][j] == 1 && !visited[i][j]){
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    public static void dfs(int adj[][], boolean visited[][], int row, int col){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(row, col));

        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            int x = temp.x;
            int y = temp.y;
            temp.coordinates();
            visited[x][y] = true;

            int deltaX[] = {-1, 0, 1, 0};
            int deltaY[] = {0, 1, 0, -1};

            for(int i=0;i<4;i++){
                int new_x = x + deltaX[i];
                int new_y = y + deltaY[i];

                if(new_x >= 0 && new_x < adj.length && new_y >= 0 && new_y <= adj[0].length
                    && adj[new_x][new_y] == 1 && !visited[new_x][new_y]){
                    queue.offer(new Pair(new_x, new_y));
                    visited[new_x][new_y] = true;
                }

            }

        }


    }
}
