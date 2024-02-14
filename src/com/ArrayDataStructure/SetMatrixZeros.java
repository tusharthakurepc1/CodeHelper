package com.ArrayDataStructure;

import java.util.Arrays;

public class SetMatrixZeros {
    public static void main(String[] args) {
        int arr[][]={{1,1,1},
                     {1,0,1},
                     {1,1,1}};

//        bruteForce(arr);
//        betterSol(arr);
        optimalSol(arr);

        for (int i=0;i<arr.length;i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static void bruteForce(int arr[][]){
        int n=arr.length;
        int m=arr[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j] == 0){
                    row_zeros(arr,i,m);
                    cols_zeros(arr,j,n);
                }

            }
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j] == -1){
                    arr[i][j]= 0;
                }
            }
        }
    }

    public static void row_zeros(int arr[][],int row,int n){
        for(int k=0;k<n;k++){
            if(arr[row][k] == 0){
                continue;
            }
            arr[row][k] = -1;
        }
    }
    public static void cols_zeros(int arr[][],int col,int m){
        for(int k=0;k<m;k++){
            if(arr[k][col] == 0){
                continue;
            }
            arr[k][col]= -1;
        }
    }

    public static void betterSol(int arr[][]){
        int n=arr.length,m=arr[0].length;
        int row_flag[]=new int[n];
        int col_flag[]=new int[m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j] == 0){
                    row_flag[i]=1;
                    col_flag[j]=1;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(row_flag[i] ==1 || col_flag[j] ==1){
                    arr[i][j]=0;
                }
            }
        }

    }


    public static void optimalSol(int arr[][]){
//        row flag array    arr[i][..]
//        col flag array    arr[..][j]
        int n=arr.length;
        int m=arr[0].length;

        int col0=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j] == 0){
                    if(j==0){
                        col0=0;
                        continue;
                    }
                    arr[i][0]= 0;
                    arr[0][j]= 0;
                }
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(arr[i][j] != 0){
                    if(arr[i][0] == 0 || arr[0][j] == 0){
                        arr[i][j]=0;
                    }
                }
            }
        }

        if(arr[0][0] == 0){
            for(int i=0;i<arr[0].length;i++){
                arr[0][i]=0;
            }
        }
        if(col0 == 0){
            for(int j=0;j<arr.length;j++){
                arr[j][0]=0;
            }
        }

    }
}
