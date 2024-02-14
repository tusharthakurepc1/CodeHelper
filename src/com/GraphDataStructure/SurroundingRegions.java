package com.GraphDataStructure;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;
import java.util.Stack;

public class SurroundingRegions {
    public static void main(String[] args) {
        char adj_matrix[][] = {
//                {'x','x','x','x'},
//                {'x','o','x','x'},
//                {'x','o','o','x'},
//                {'x','o','x','x'},
//                {'x','x','o','o'}

//                {'o'}

                {'o','o','o'},
                {'o','o','o'},
                {'o','o','o'}
        };

        surroundingRegions(adj_matrix);
    }

    public static void surroundingRegions(char adj_matrix[][]){
//        Traverse for the boundary of the adjacency matrix
        int left = 0, right = adj_matrix[0].length;
        int top = 0, bottom = adj_matrix.length;
        boolean visited[][] = new boolean[adj_matrix.length][adj_matrix[0].length];

        while(left < right){
//            Right
            // System.out.print(adj_matrix[0][left]+" ");
            if(adj_matrix[0][left] == 'O'){
                dfs(adj_matrix, visited, 0, left);
            }
            left+=1;
        }
        left = 0;

        // System.out.println();
        while(top < bottom){
//            Bottom
            // System.out.print(adj_matrix[top][adj_matrix[0].length-1]);
            if(adj_matrix[top][adj_matrix[0].length-1] == 'O'){
                dfs(adj_matrix, visited, top, adj_matrix[0].length-1);
            }
            top+=1;
        }
        top = 0;

        // System.out.println();
        right--;
        while(left < right){
//            Left
            // System.out.print(adj_matrix[adj_matrix.length-1][right]+" ");
            if(adj_matrix[adj_matrix.length-1][right] == 'O'){
                dfs(adj_matrix, visited, adj_matrix.length-1, right);
            }
            right-=1;
        }

        System.out.println();
        bottom--;
        while(top < bottom){
//            Top
            // System.out.print(adj_matrix[bottom][0]+" ");
            if(adj_matrix[bottom][0] == 'O'){
                dfs(adj_matrix, visited, bottom ,0);
            }
            bottom-=1;
        }

        for(int i=0;i< visited.length;i++){
            for(int j=0;j<visited[0].length;j++){

                if(!visited[i][j]){
                    adj_matrix[i][j] = 'X';
                }
                else{
                    adj_matrix[i][j] = 'O';
                }

            }
        }

    }

    public static void dfs(char adj_matrix[][], boolean visited[][], int row, int col){
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(row, col));
        visited[row][col] = true;

        while(!stack.isEmpty()){
            Pair temp = stack.pop();
            int x = temp.x;
            int y = temp.y;
            adj_matrix[x][y] = 'X';

            int deltaX[] = {-1, 0, 1, 0};
            int deltaY[] = {0, 1, 0, -1};

            for(int i=0;i<4;i++){
                int new_x = x + deltaX[i];
                int new_y = y + deltaY[i];

                if(new_x >= 0 && new_x < adj_matrix.length && new_y >= 0 && new_y < adj_matrix[0].length
                        && adj_matrix[new_x][new_y] == 'O' && !visited[new_x][new_y]){

                    stack.push(new Pair(new_x, new_y));
                    visited[new_x][new_y] = true;

                }
            }
        }
    }
}
