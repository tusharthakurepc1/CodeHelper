package com.CP;

import java.util.Arrays;

public class PrefixSum {
    public static void main(String[] args) {
        int row = 3, col = 3;
        int arr[][] = new int[row+1][col+1];

        int data_val = 1;
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                arr[i][j] = data_val++;
            }
        }
//        display(arr);
        System.out.println(prefixSumK(arr, row, col, 1+1, 1+1, 2+1, 2+1));


    }

    /*
    This method is returning the specific portion of a 2D Matrix
    Ex: [1, 2, 3]       Prefix Sum form (1, 1) to (2, 2) is: 28
        [4, 5, 6]       Sum 28 = a(1, 1) + a(1, 2) + b(2, 1) + b(2, 2)
        [7, 8, 9]
     */
    public static int prefixSumK(int arr[][], int row, int col, int x, int y, int x2, int y2){
//        Find the prefix sum;
        int right_sum[][] = new int[row+1][col+1];
        int prefix_sum[][] = new int[row+1][col+1];

        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                right_sum[i][j] = arr[i][j] + right_sum[i][j-1];
                prefix_sum[i][j] = right_sum[i][j];
                prefix_sum[i][j] = prefix_sum[i][j] + prefix_sum[i-1][j];
            }
        }

//        Calculate the Prefix specific Matrix in the 2D Matrix

        int res = prefix_sum[x2][y2] - (prefix_sum[x-1][y2] + prefix_sum[x2][y-1]) + prefix_sum[x-1][y-1];

        return res;
    }

    /*
    This method is returning the prefix sum of a 2D Matrix
    Ex  [1, 2]      Prefix Sum: [1, 3]          :: p(0, 0) = a(0, 0)    p(0, 1) = a(0, 0) + a(0, 1)
        [3, 4]                  [4, 10]         :: p(1, 0) = a(0, 0) + a(1, 0)
                                                :: p(1, 1) = a(0, 0) + a(0, 1) + a(1, 0) + a(1, 1)
     */
    public static int[][] prefixSum(int arr[][], int row, int col){
        int res[][] = new int[row+1][col+1];

        for(int i=1;i<=row;i++){
            for(int j = 1;j<=col;j++){
                res[i][j] = arr[i][j] + res[i][j-1];
            }
        }

        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                res[i][j] = res[i][j] + res[i-1][j];
            }
        }

        return res;
    }


    public static void display(int arr[][]){
        for(int temp[]: arr){
            System.out.println(Arrays.toString(temp));
        }
    }
}
