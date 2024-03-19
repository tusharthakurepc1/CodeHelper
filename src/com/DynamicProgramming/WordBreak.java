package com.DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class WordBreak {
    public static void main(String[] args) {
        int adj_matrix[][] = {
                {0, 2, -1, -1},
                {1, 0, 3, -1},
                {-1, -1, 0, -1},
                {3, 5, 4, 0}
        };
        int n = adj_matrix.length;

        floydWarshallAlgo(adj_matrix, n);

    }

    public static void floydWarshallAlgo(int adj_matrix[][], int n){

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(adj_matrix[i][j] == -1)  adj_matrix[i][j] = (int)1e9;
            }
        }

        for(int v=0;v<n;v++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){

                    adj_matrix[i][j] = Math.min(adj_matrix[i][j], adj_matrix[i][v] + adj_matrix[v][j]);

                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(adj_matrix[i][j] == (int)1e9)  adj_matrix[i][j] = -1;
            }
        }


        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(adj_matrix[i]));
        }

    }
}
