package com.CP;

import java.util.ArrayList;
import java.util.List;

public class TotalNumberOfConnectedComponentDirectedGraph {
    public static void main(String[] args) {
        int original_list[][] = {
                {},
                {2},
                {3},
                {1, 4},
                {5},
                {7},
                {5},
                {6}
        };

        System.out.println(totalComponentInDirectedGraph(original_list));

    }

//    Algo invented by @Kasaraju from INDIA
    public static int totalComponentInDirectedGraph(int arr[][]){
        List<Integer> topologicalSort = TopologicalOrder.topoSort(arr);
        List<Integer>[] reverse_edge = reverseEdge(arr);
//        System.out.println(topologicalSort);
        int count = 0;


        boolean visited[] = new boolean[arr.length];

        for(int el: topologicalSort){
            if(!visited[el]){
                count++;
                dfsReverseEdge(reverse_edge, visited, el);
            }
        }

        return count;
    }


    public static List<Integer>[] reverseEdge(int arr[][]){
        List<Integer> temp[] = new List[arr.length];
        for(int i=0;i<temp.length;i++)  temp[i] = new ArrayList<>();


        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                temp[arr[i][j]].add(i);
            }
        }

        return temp;
    }

    public static void dfsReverseEdge(List<Integer> list_rev[], boolean visited[], int curr){

        visited[curr] = true;
//        System.out.print(curr+" ");

        for(int child: list_rev[curr]){
            if(!visited[child]){
                dfsReverseEdge(list_rev, visited, child);
            }
        }
//        System.out.println();

    }

}
