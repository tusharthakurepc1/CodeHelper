package com.CP;

import sun.java2d.pipe.SpanClipRenderer;

import java.util.*;

public class Tree {
    public static void main(String[] args) {
//        TreeStructure tree1 = new TreeStructure();
//        tree1.display();
//        tree1.dfs();
//        tree1.bfs();


    }

    public static void numberOfIsland(char arr[][]){
        int count = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j] == '1'){
                    count++;
                    dfs_call(arr, i, j);
                }
            }
        }
        System.out.println(count);
    }

    public static void dfs_call(char arr[][], int row, int col){
        if(row < 0 || row >= arr.length || col < 0 || col >= arr[0].length){
            return;
        }
        if(arr[row][col] == '0'){
            return;
        }

        arr[row][col] = '0';

//        Move top
        dfs_call(arr, row-1, col);
//        Move right
        dfs_call(arr, row, col+1);
//        Move Bottom
        dfs_call(arr, row+1, col);
//        Move Left
        dfs_call(arr, row, col-1);

    }


}

class TreeStructure{
    int e = 8;
    int arr[][] = null;
    List<List<Integer>> list = null;
    Map<Integer, Integer> parents = null;

    TreeStructure(){
        this.arr = new int[][]{
                {1, 2},
                {1, 3},
                {1, 4},
                {2, 5},
                {3, 6},
                {3, 7},
                {6, 8}
        };

        list = new ArrayList<>();
        for(int i=0;i<e+1;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<arr.length;i++){
            list.get(arr[i][0]).add(arr[i][1]);
        }

//        Get the parents
        parents =  new HashMap<>();
        parents.put(1, -1);
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.get(i).size();j++){
                parents.put(list.get(i).get(j), i);
            }
        }

    }

    public void display(){
        for(int []temp:arr){
            System.out.println(Arrays.toString(temp));
        }
        System.out.println(list);
        System.out.println(parents);
    }

    public void dfs(){
        for(int i=0;i<list.size();i++){
            if(list.get(i).size() != 0){
                dfs_call(i, list);
                System.out.println();
                return;
            }
        }
    }
    public static void dfs_call(int current, List<List<Integer>> list){
        System.out.print(current+" ");
        for(int i=0;i<list.get(current).size();i++){
            dfs_call(list.get(current).get(i), list);
        }
    }

    public void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while(!queue.isEmpty()){
            int temp = queue.poll();
            System.out.print(temp+" ");
            int len = list.get(temp).size();

            for(int i=0;i<len;i++){
                queue.offer(list.get(temp).get(i));
            }
        }
        System.out.println();
    }

}
