package com.GraphDataStructure;

import java.util.*;

public class NoOfProvinces {
    public static void main(String[] args) {
        int adj_matrix[][] = {{1,1,0},{1,1,0},{0,0,1}};

//        for(int temp[]: adj_matrix){
//            System.out.println(Arrays.toString(temp));
//        }

        List<List<Integer>> adj_list = new ArrayList<>();
        for(int i=0;i<adj_matrix.length;i++){
            adj_list.add(new ArrayList<>());
        }

        for(int i=0;i<adj_matrix.length;i++){
            for(int j=0;j<adj_matrix[i].length;j++){
                if(i == j)  continue;
                if(adj_matrix[i][j] == 1){
                    adj_list.get(i).add(j);
                }
            }
        }
        System.out.println(adj_list);

        System.out.println(dfs(adj_list));
    }

    public static int dfs(List<List<Integer>> adj_list){
        boolean visited[] = new boolean[adj_list.size()];
        int count = 0;

        for(int i = 0;i<visited.length;i++){
            if(!visited[i]){
                count++;
                helper(adj_list, visited, i);
            }
        }

        return count;
    }

    public static void helper(List<List<Integer>> adj_list, boolean visited[], int key){
        Stack<Integer> stack = new Stack<>();
        stack.push(key);
        visited[key] = true;

        while(!stack.isEmpty()){
            System.out.print(stack+"  ");
            int temp = stack.pop();
            System.out.println(temp+1+" ");

            for(int el: adj_list.get(temp)){
                if(!visited[el]){
                    stack.push(el);
                    visited[el] = true;
                }
            }

        }

    }
}
