package com.Recursion;

import java.util.Arrays;

public class NQueen_II {
    public static int[][] board = null;

    public static void main(String[] args) {
        int n = 9;

        board = new int[n][n];

        System.out.println(solution(0, n));
    }

    public static int solution(int ind, int n){
        if(ind == n){
            return 1;
        }

        int ans = 0;
        for(int i=0;i<n;i++){

            board[ind][i] = 1;

            if(checkBoard(ind, i)){
                ans = ans + solution(ind + 1, n);
            }

            board[ind][i] = 0;

        }

        return ans;
    }

    public static void displayBoard(){
        for(int i=0;i< board.length;i++){
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println("--------------------------");
    }

    public static boolean checkBoard(int row, int col){

        int t_row = row - 1, t_col = col;

        //checking col
        while(t_row >= 0){
            if(board[t_row][t_col] == 1){
                return false;
            }
            t_row -= 1;
        }


        //checking top-left
        t_row = row - 1;
        t_col = col - 1;
        while(t_row >= 0 && t_col >= 0){
            if(board[t_row][t_col] == 1){
                return false;
            }

            t_row--;
            t_col--;
        }


        //checking top-right
        t_row = row - 1;
        t_col = col + 1;
        while(t_row >= 0 && t_col < board.length){
            if(board[t_row][t_col] == 1){
                return false;
            }

            t_row--;
            t_col++;
        }

        return true;
    }
}
