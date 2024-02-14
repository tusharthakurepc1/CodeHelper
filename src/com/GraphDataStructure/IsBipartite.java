package com.GraphDataStructure;

import java.util.*;

public class IsBipartite {
    public static void main(String[] args) {
//        List<List<Integer>> adj_list = new ArrayList<>();
//
//        adj_list.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
//        adj_list.add(new ArrayList<>(Arrays.asList(0, 2)));
//        adj_list.add(new ArrayList<>(Arrays.asList(0, 1, 3)));
//        adj_list.add(new ArrayList<>(Arrays.asList(0, 2)));

        int adj_list2[][] = {
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
        };

        int visited[] = new int[adj_list2.length];
        for(int i=0;i<visited.length;i++){
            if(visited[i] == -1){
//                if(!isBipartiteBFS(adj_list2, visited)){
                if(!isBipartiteDFS(adj_list2, visited, i)){
                    System.out.println("False");
                    return;
                }
            }
        }
        System.out.println("True");


    }

    public static boolean isBipartiteBFS(int [][]adj_list, int visited[]){
        Arrays.fill(visited, -1);
//        Two Color 0: Black and 1: White


        //Start traversal with 0th node
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = 0;


        while(!queue.isEmpty()){
            int temp = queue.poll();
            int[] neighbours = adj_list[temp];

            int reverse = -1;
            if(visited[temp] == 1)  reverse = 0;
            else    reverse = 1;

            for(int i=0;i<neighbours.length;i++){
                if(visited[neighbours[i]] == visited[temp]){
                    return false;     //Not a Bipartite graph
                }
                if(visited[neighbours[i]] == -1){
                    visited[neighbours[i]] = reverse;
                    queue.offer(neighbours[i]);
                }
            }


        }


        return true;

    }

    public static boolean isBipartiteDFS(int [][]adj_list, int visited[], int ind){
        Stack<Integer> stack = new Stack<>();
        stack.push(ind);
        visited[ind] = 0;

        while(!stack.isEmpty()){
            int temp = stack.pop();
            int neighbours[] = adj_list[temp];

            int reverse = -1;
            if(visited[temp] == 1)  reverse = 0;
            else    reverse = 1;

            for(int i=0;i<neighbours.length;i++){
                if(visited[neighbours[i]] == visited[temp]){
                    return false;
                }

                if(visited[neighbours[i]] == -1){
                    visited[neighbours[i]] = reverse;
                    stack.push(neighbours[i]);
                }
            }


        }


        return true;
    }
}
