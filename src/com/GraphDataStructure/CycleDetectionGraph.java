package com.GraphDataStructure;

public class CycleDetectionGraph {
    public static void main(String[] args) {
        int list[][] = {
                {},
                {2, 4},
                {1},
                {1, 4},
                {1, 3, 5},
                {4}
        };

        cycleDetectionUndirected(list);
    }

    public static void cycleDetectionUndirected(int arr[][]){
        boolean vis[] = new boolean[arr.length];

        for(int i=0;i<arr.length;i++){
            if(!vis[i]){
                if(dfs(i, -1, arr, vis)){
                    System.out.println("Cycle detected");
                    return;
                }
            }
        }

        System.out.println("Not having cycle");

    }

    public static boolean dfs(int curr, int parent, int list[][], boolean vis[]){

        vis[curr] = true;

        for(int child: list[curr]){
            if(vis[child] && parent != child){
                return true;
            }
            else if(child != parent){
                dfs(child, curr, list, vis);
            }
        }

        return false;

    }
}
