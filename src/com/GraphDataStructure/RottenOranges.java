package com.GraphDataStructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int adj_matrix[][] = {
                {0, 1, 2},
                {0, 2, 2},
                {2, 1, 1},
        };


//        int ans = Integer.MAX_VALUE;
//        for(int i=0;i<adj_matrix.length;i++){
//            for(int j=0;j<adj_matrix[0].length;j++){
//                if(adj_matrix[i][j] == 2){
//                    System.out.println(rottenOranges(adj_matrix, i, j)-1);
//                    return;
//                }
//            }
//        }

        System.out.println(rottenOrangesM2(adj_matrix));

    }


    public static int rottenOrangesM2(int adj_matrix[][]){
        Queue<Pair> queue = new LinkedList<>();
        boolean visited[][] = new boolean[adj_matrix.length][adj_matrix[0].length];
        int counter = 0;

        for(int i=0;i<adj_matrix.length;i++){
            for(int j=0;j<adj_matrix[0].length;j++){
                if(adj_matrix[i][j] == 2){
//                    Apply for the bfs
                    queue.offer(new Pair(i, j));
                }
            }
        }

        while(!queue.isEmpty()){
            int length = queue.size();
            boolean flag = true;

            for(int i=0;i<length;i++){


                Pair temp = queue.poll();
                int x = temp.x;
                int y = temp.y;
                temp.coordinates();

                int deltaX[] = {-1, 0, 1, 0};
                int deltaY[] = {0, 1, 0, -1};

                for(int j = 0;j<deltaX.length;j++){
                    int new_x = x + deltaX[j];
                    int new_y = y + deltaY[j];

                    if(new_x >= 0 && new_x < adj_matrix.length && new_y >= 0 && new_y < adj_matrix[0].length &&
                        adj_matrix[new_x][new_y] == 1 && !visited[new_x][new_y]){
                        if(flag){
                            flag = false;
                            counter++;
                        }
                        queue.offer(new Pair(new_x, new_y));
                        adj_matrix[new_x][new_y] = 2;
                        visited[new_x][new_y] = true;
                    }
                }


            }
        }


        for(int i=0;i<adj_matrix.length;i++){
            for(int j=0;j<adj_matrix[0].length;j++){
                if(adj_matrix[i][j] == 1){
                    return -1;
                }
            }
        }
        return counter;
    }


    /*
    This algo is work only if there is one rotten orange in the beginning of the matrix
     */
    public static int rottenOranges(int adj_matrix[][], int row, int col){
        boolean visited[][] = new boolean[adj_matrix.length][adj_matrix[0].length];
        Queue<Pair> queue = new LinkedList<>();
        int result = 0;

        queue.offer(new Pair(row, col));
        visited[row][col] = true;
        adj_matrix[row][col] = 2;

        while(!queue.isEmpty()){
            int length = queue.size();
            result++;

            for(int i=0;i<length;i++){          //For Each Level
                Pair temp = queue.poll();
                int x = temp.x;
                int y = temp.y;

//            Add neighbours to the queue

                int deltaX[] = {-1, 0, 1, 0};
                int deltaY[] = {0, 1, 0, -1};

                for(int j = 0;j<deltaX.length;j++){
                    int new_x = x + deltaX[j];
                    int new_y = y + deltaY[j];

                    if(new_x >= 0 && new_x < adj_matrix.length && new_y >= 0 && new_y < adj_matrix[0].length
                        && adj_matrix[new_x][new_y] == 1 && !visited[new_x][new_y]){
                        queue.offer(new Pair(new_x, new_y));
                        visited[new_x][new_y] = true;
                        adj_matrix[new_x][new_y] = 2;
                    }

                }

            }
        }

        return result;
    }

    public static int[][] copyOfAdj(int [][]adj_matrix){
        int copy[][] = new int[adj_matrix.length][adj_matrix[0].length];
        for(int i=0;i<adj_matrix.length;i++){
            for(int j=0;j<adj_matrix[0].length;j++){
                copy[i][j] = adj_matrix[i][j];
            }
        }
        return copy;
    }
}
