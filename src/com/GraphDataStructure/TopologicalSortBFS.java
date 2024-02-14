package com.GraphDataStructure;

import java.util.*;

public class TopologicalSortBFS {
    public static void main(String[] args) {
        int v = 6, e = 4;
        int edges[][] = {
                {5,0},
                {5,2},
                {4,0},
                {4,1},
                {2,3},
                {3,1}
        };
        List<List<Integer>> adj_list = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj_list.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            adj_list.get(edges[i][0]).add(edges[i][1]);
        }

        topologicalSort(adj_list, edges);
    }

//    BFS
    public static void topologicalSort(List<List<Integer>> adj_list, int edges[][]){
        Queue<Integer> queue = new LinkedList<Integer>();

        int degreeOfNode[] = new int[adj_list.size()];

        for(int i=0;i<edges.length;i++){
            degreeOfNode[edges[i][1]]++;
        }

//        System.out.println(Arrays.toString(degreeOfNode));

        for(int i=0;i<degreeOfNode.length;i++){
            if(degreeOfNode[i] == 0){
                queue.offer(i);
            }
        }


        int res[] = new int[adj_list.size()];
        int counter = 0;
        while(!queue.isEmpty()){
            int temp = queue.peek();
            queue.poll();
            res[counter] = temp;
            counter++;


//            Traverse their neighbours and remove edges by subtract in-degree from degreeOfNode array
//            if degreeOfNode element having 0 in-degree the offer it to queue

            for(int el: adj_list.get(temp)){
                degreeOfNode[el]--;
                if(degreeOfNode[el] == 0){
                    queue.offer(el);
                }
            }


        }

        System.out.println(Arrays.toString(res));
    }
}
