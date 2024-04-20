package com.Recursion;

public class ValidSudoku {
    public static void main(String[] args) {
        char arr[][] ={
            {'8','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        int n = 9;

        System.out.println(solution(arr, 0, 0));
//        System.out.println(isValidPosition(arr, 0, 0, arr[0][0]));
    }

    public static boolean solution(char arr[][], int row, int col){
        if(row == arr.length-1 && col == arr.length){
            return true;
        }
        if(col >= 9){
            col = 0;
            row = row + 1;
        }
        if(row >= 9){
            return false;
        }

        //check block
        if(arr[row][col] != '.'){
            boolean temp = isValidPosition(arr, row, col, arr[row][col]);
            if(temp)    return solution(arr, row, col + 1);
            else    return false;
        }
        else{
            return solution(arr, row, col + 1);
        }
    }

    public static boolean isValidPosition(char arr[][], int row, int col, char val){
        //try for the row
        for(int i=0; i<row; i++){
            if(i == row)    continue;
            if(arr[i][col] == val){
                return false;
            }
        }

        //check the column
        for(int j=0; j<col; j++){
            if(j == col)    continue;
            if(arr[row][j] == val){
                return false;
            }
        }

        //check the grid
        int start_x = row - (row % 3);
        int start_y = col - (col % 3);

        for(int i=start_x; i<start_x + 3; i++){
            for(int j=start_y; j<start_y + 3; j++){
                if(i == row && j == col)    continue;
                if(arr[i][j] == val){
                    return false;
                }
            }
        }


        return true;
    }
}
