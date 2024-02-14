package com.GraphDataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphDataStore {
    public static void main(String[] args) {
        storeUnDirGraphDataMeth2(5);
    }
    public static void storeUnDirGraphDataMeth1(int n){
        int adj_graph[][] = new int[n+1][n+1];

        adj_graph[1][2] = 1;
        adj_graph[2][1] = 1;    //remove if it is directed

        adj_graph[1][3] = 1;
        adj_graph[3][1] = 1;    //remove if it is directed

        adj_graph[2][4] = 1;
        adj_graph[4][2] = 1;    //remove if it is directed

        adj_graph[3][4] = 1;
        adj_graph[4][3] = 1;    //remove if it is directed

        adj_graph[2][5] = 1;
        adj_graph[5][2] = 1;    //remove if it is directed

        adj_graph[4][5] = 1;
        adj_graph[5][4] = 1;    //remove if it is directed


        for(int i=0;i<adj_graph.length;i++){
            System.out.println(Arrays.toString(adj_graph[i]));
        }
    }

    public static List<List<Integer>> storeUnDirGraphDataMeth2(int n){
        List<List<Integer>> adj_list = new ArrayList<>();

        for(int i=0;i<n+1;i++){
            adj_list.add(new ArrayList<>());
        }

        adj_list.get(1).add(2);
        adj_list.get(2).add(1);     //remove if it is directed.

        adj_list.get(1).add(3);
        adj_list.get(3).add(1);     //remove if it is directed.

        adj_list.get(2).add(4);
        adj_list.get(4).add(2);     //remove if it is directed.

        adj_list.get(3).add(4);
        adj_list.get(4).add(3);     //remove if it is directed.

        adj_list.get(2).add(5);
        adj_list.get(5).add(2);     //remove if it is directed.

        adj_list.get(4).add(5);
        adj_list.get(5).add(4);     //remove if it is directed.


//        for(int i=0;i<adj_list.size();i++){
//            System.out.println(adj_list.get(i));
//        }

        return adj_list;

    }

    public static List<List<Integer>> storeUnDirGraphDataMeth2Graph2(int n){
        List<List<Integer>> adj_list = new ArrayList<>();

        for(int i=0;i<n+1;i++){
            adj_list.add(new ArrayList<>());
        }

        adj_list.get(1).add(2);
        adj_list.get(2).add(1);     //remove if it is directed.

        adj_list.get(1).add(6);
        adj_list.get(6).add(1);     //remove if it is directed.

        adj_list.get(2).add(3);
        adj_list.get(3).add(2);     //remove if it is directed.

        adj_list.get(2).add(4);
        adj_list.get(4).add(2);     //remove if it is directed.

        adj_list.get(6).add(7);
        adj_list.get(7).add(6);     //remove if it is directed.

        adj_list.get(6).add(9);
        adj_list.get(9).add(6);     //remove if it is directed.

        adj_list.get(4).add(5);
        adj_list.get(5).add(4);     //remove if it is directed.

        adj_list.get(7).add(8);
        adj_list.get(8).add(7);     //remove if it is directed.

        adj_list.get(5).add(8);
        adj_list.get(8).add(5);     //remove if it is directed.


        return adj_list;

    }

}
