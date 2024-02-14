package com.Recursion;

import java.util.Arrays;

public class WordSearch {
    public static void main(String[] args) {
//        Not Working for some edge case...
        char arr[][] = {{'a','b','c','e'},{'s','f','e','s'},{'a','d','e','e'}};
        boolean flags[][] = new boolean[arr.length][arr[0].length];
        String target = "abceseeefs";

//        int row = 0, col = 0;

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j] == target.charAt(0)){
                    System.out.println(i+ " "+ j+ " Answer: ");
                    System.out.println(recursiveSolution(arr, flags, i, j, target, 0));
                    for(boolean temp[]: flags){
                        Arrays.fill(temp, false);
                    }
                }
            }
        }



    }

    public static boolean recursiveSolution(char arr[][], boolean flags[][], int row, int col, String target, int ind){
        if(flags[row][col] || target.charAt(ind) != arr[row][col] || ind > target.length()-1){
            flags[row][col] = false;
            return false;
        }
        System.out.println(row + " " + col + " Ind: " + ind);
        if(ind == target.length()-1){
            return true;
        }

        boolean right = false, left = false, top = false, bottom = false;
        flags[row][col] = true;

//        Move Right
        if(col < arr[0].length-1){
            right =  recursiveSolution(arr, flags, row, col+1, target, ind + 1);
        }

//        Move Left
        if(col > 0){
            left = recursiveSolution(arr, flags, row, col - 1, target, ind + 1);
        }

//        Move Top
        if(row > 0){
            top = recursiveSolution(arr, flags, row - 1, col, target, ind + 1);
        }

//        Move Bottom
        if(row < arr.length-1){
            bottom = recursiveSolution(arr, flags, row + 1, col, target, ind + 1);
        }

        return left || right || top || bottom;
    }
}
