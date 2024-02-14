package com.CP;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SudokoSolver {
    public static void main(String[] args) {
        int n = 9;

        char board[][] = {
                {'5', '3', '0', '0', '7', '0', '0', '0', '0'},
                {'6', '0', '0', '1', '9', '5', '0', '0', '0'},
                {'0', '9', '8', '0', '0', '0', '0', '6', '0'},
                {'8', '0', '0', '0', '6', '0', '0', '0', '3'},
                {'4', '0', '0', '8', '0', '3', '0', '0', '1'},
                {'7', '0', '0', '0', '2', '0', '0', '0' ,'6'},
                {'0', '6', '0', '0', '0', '0', '2', '8', '0'},
                {'0', '0', '0', '4', '1', '9', '0', '0', '5'},
                {'0', '0', '0', '0', '8', '0', '0', '7', '9'}
        };

        displayBoard(board);

        sudokoSolve(board, 0, 0, n);

        displayBoard(board);
    }

    public static void displayBoard(char board[][]){

        for(char board_t[]: board){
            System.out.println(Arrays.toString(board_t));
        }

    }

    public static boolean sudokoSolve(char board[][], int row, int col, int n){
        if(col >= n){
            col = 0;
            row++;
        }
        if(row >= n && col == 0){
            System.out.println("Solved");
            return true;
        }


        if(board[row][col] == '0'){
//            Try the possible value in the board
            for(int i=1;i<=n;i++){
                if(isValid(board, row, col, (char)(i+48), n)){
                    board[row][col] = (char)(i+48);

                    if(sudokoSolve(board, row, col+1, n)){
                        return true;
                    }

                    board[row][col] = '0';
                }
            }
            return false;
        }
        else{
            return sudokoSolve(board, row, col+1, n);
        }

    }



    public static boolean isValid(char board[][], int row, int col, char key, int n){
//        Check for the whole row
        for(int i=0;i<n;i++){
            if((int)board[i][col] == key){
                return false;
            }
        }

//        Check for the whole col
        for(int j=0;j<n;j++){
            if((int)board[row][j] == key){
                return false;
            }
        }

//        Check for the perticular subblock
        int sp_x = (row) - ((row) % 3);
        int sp_y = (col) - ((col) % 3);

        for(int i=sp_x;i<sp_x+3;i++){
            for(int j =sp_y;j<sp_y+3;j++){
                if((int)board[i][j] == key){
                    return false;
                }
            }
        }


        return true;
    }
}


//package com.CP;
//
//        import java.lang.reflect.Array;
//        import java.util.Arrays;
//
//public class SudokoSolver {
//    public static void main(String[] args) {
//        int n = 9;
//
//        char board[][] = {
//                {'5', '3', '0', '0', '7', '0', '0', '0', '0'},
//                {'6', '0', '0', '1', '9', '5', '0', '0', '0'},
//                {'0', '9', '8', '0', '0', '0', '0', '6', '0'},
//                {'8', '0', '0', '0', '6', '0', '0', '0', '3'},
//                {'4', '0', '0', '8', '0', '3', '0', '0', '1'},
//                {'7', '0', '0', '0', '2', '0', '0', '0' ,'6'},
//                {'0', '6', '0', '0', '0', '0', '2', '8', '0'},
//                {'0', '0', '0', '4', '1', '9', '0', '0', '5'},
//                {'0', '0', '0', '0', '8', '0', '0', '7', '9'}
//        };
//
//        for(char temp[] : board){
//            System.out.println(Arrays.toString(temp));
//        }
//
////        System.out.println(isValid(board, 1, 1, 2, n));
//
////        for(int i=48;i<48+10;i++){
////            System.out.print((char)i+":"+i+", ");
////        }
//
//        sudokoSolve(board, 0, 0, n);
//    }
//
//    public static void displayBoard(char board[][]){
//
//        for(char board_t[]: board){
//            System.out.println(Arrays.toString(board_t));
//        }
//
//    }
//
//    public static void sudokoSolve(char board[][], int row, int col, int n){
//        if(col >= n){
//            col = 0;
//            row++;
//        }
//        if(row >= n && col == 0){
//            System.out.println("Solved");
//            displayBoard(board);
////            return;
//            System.exit(1);
//        }
//
//
//        if(board[row][col] == '0'){
////            Try the possible value in the board
//            for(int i=1;i<=n;i++){
//                if(isValid(board, row, col, i, n)){
//                    board[row][col] = (char)(i+48);
//
//                    sudokoSolve(board, row, col+1, n);
//
//                    board[row][col] = '0';
//                }
//            }
//        }
//        else{
//            sudokoSolve(board, row, col+1, n);
//        }
//
//    }
//
//
//
//    public static boolean isValid(char board[][], int row, int col, int key, int n){
////        Check for the whole row
//        for(int i=0;i<n;i++){
//            if(board[i][col] == key){
//                return false;
//            }
//        }
//
////        Check for the whole col
//        for(int j=0;j<n;j++){
//            if(board[row][j] == key){
//                return false;
//            }
//        }
//
////        Check for the perticular subblock
//        int sp_x = (row) - ((row) % 3);
//        int sp_y = (col) - ((col) % 3);
//
//        for(int i=sp_x;i<sp_x+3;i++){
//            for(int j =sp_y;j<sp_y+3;j++){
//                if(board[i][j] == key){
//                    return false;
//                }
//            }
//        }
//
//
//        return true;
//    }
//}
//
