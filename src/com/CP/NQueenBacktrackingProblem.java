package com.CP;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NQueenBacktrackingProblem {
    public static boolean board[][];

    public static void main(String[] args) {
        int n = 5;
        board = new boolean[n][n];

        nQueen(0, n);

    }

    public static void displayBoard(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                char res = (board[i][j]) ? 'Q': '.';

                System.out.print(res);
            }
            System.out.println();
        }
        System.out.println();
    }

    /*
     *            * * *
     *            * Q *
     *            * * *
     *      In this way a queen move in the chess board
     */
    public static void nQueen(int row, int n){
        if(row == n){
            displayBoard();
            return;
        }

        for(int i=0;i<n;i++){
            if(isValid(row, i)){
                board[row][i] = true;

                nQueen(row+1, n);

                board[row][i] = false;
            }

        }


    }

    public static boolean isValid(int row, int col){
//      for col search
        for(int i=0;i<=row;i++){
            if(board[i][col]){
                return false;
            }
        }

//        Check for left top diagnol
        int i = row, j = col;
        while(i >= 0 && j >=0){
            if(board[i][j]){
                return false;
            }
            i--; j--;
        }

        i = row;    j = col;
        while(i >= 0 && j < board.length){
            if(board[i][j]){
                return false;
            }
            i--;    j++;
        }

        return true;
    }


}
