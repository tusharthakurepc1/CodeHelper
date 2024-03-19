package com.GraphDataStructure.ShortestPath;

import java.util.Arrays;

public class FindCityWithSmallestNoOfThresholdDistance {
    public static void main(String[] args) {
        int edges[][] = {
                {0, 1, 3},
                {1, 2, 1},
                {1, 3, 4},
                {2, 3, 1}
        };
        int n = 4;

        int adj_matrix[][] = new int[n][n];

        for(int row[]: adj_matrix){
            Arrays.fill(row, Short.MAX_VALUE);
        }

        for(int e[]: edges){
            adj_matrix[e[0]][e[1]] = adj_matrix[e[1]][e[0]] = e[2];
        }

        for(int i=0;i<n;i++){
            adj_matrix[i][i] = 0;
        }

        floydWarshallAlgo(adj_matrix, n,4);

    }

    public static void floydWarshallAlgo(int adj_matrix[][], int n, int threshold_val){

        for(int v=0; v<n; v++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    adj_matrix[i][j] = Math.min(adj_matrix[i][j], adj_matrix[i][v] + adj_matrix[v][j]);
                }
            }
        }

        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(adj_matrix[i]));
        }

//        Final traversal
        int res = n;
        int node = -1;

        for(int i=0;i<n;i++){
            int temp = 0;
            for(int j=0;j<n;j++){

                if(adj_matrix[i][j] <= threshold_val){
                    temp++;
                }
            }
            if(temp <= res){
                res = temp;
                node = i;
            }
        }


        System.out.println(node);

    }


}
