package com.GraphDataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class FindNumberOfIsland {
    public static void main(String[] args) {
        int grid[][] = {
                {0,1,1,0},
                {0,1,1,0},
                {0,0,1,0},
                {0,0,0,0},
                {1,1,0,1}
        };

        bfs(grid);
    }

    public static void bfs(int grid[][]){
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int count = 0;

        for(int i=0;i<visited.length;i++){
            for(int j=0;j<visited[0].length;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    count++;
                    System.out.println("I am"+i+" "+j);
                    helper(grid, visited, i, j);
                }
            }
        }

        System.out.println(count);
    }

    public static void helper(int grid[][], boolean visited[][], int i, int j){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i, j));
        visited[i][j] = true;

        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            temp.coordinates();

//            Check for all the eight neighbours
            int x = temp.x;
            int y = temp.y;

            if(x > 0){
                if(!visited[x-1][y]){
                    queue.offer(new Pair(x-1, y));  //Top
                    visited[x-1][y] = true;
                }
            }
            if(y > 0){
                if(!visited[x][y-1] && grid[x][y-1] == 1){
                    queue.offer(new Pair(x, y-1));  //Left
                    visited[x][y-1] = true;
                }
            }
            if(y < grid[0].length-1){
                if(!visited[x][y+1] && grid[x][y+1] == 1){
                    queue.offer(new Pair(x, y+1));  //Right
                    visited[x][y+1] = true;
                }
            }
            if(x < grid.length-1){
                if(!visited[x+1][y] && grid[x+1][y] == 1){
                    queue.offer(new Pair(x+1, y));  //Bottom
                    visited[x+1][y] = true;
                }
            }

            if(x > 0 && y >0){
                if(!visited[x-1][y-1] && grid[x-1][y-1] == 1){
                    queue.offer(new Pair(x-1, y-1));    //Top Left
                    visited[x-1][y-1] = true;
                }
            }
            if(x > 0 && y < grid[0].length-1){
                if(!visited[x-1][y+1] && grid[x-1][y+1] == 1){
                    queue.offer(new Pair(x-1, y+1));    //Top Right
                    visited[x-1][y+1] = true;
                }
            }
            if(y < grid[0].length-1 && x < grid.length-1){
                if(!visited[x+1][y+1] && grid[x+1][y+1] == 1){
                    queue.offer(new Pair(x+1, y+1));    //Bottom Right
                    visited[x+1][y+1] = true;
                }
            }
            if(x < grid.length-1 && y > 0){
                if(!visited[x+1][y-1] && grid[x+1][y-1] == 1){
                    queue.offer(new Pair(x+1, y-1));    //Bottom Left
                    visited[x+1][y-1] = true;
                }
            }
        }

    }
}


