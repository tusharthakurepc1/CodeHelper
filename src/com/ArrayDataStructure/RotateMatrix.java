package com.ArrayDataStructure;

import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int arr[][]={{1 , 2, 3, 4},
                     {5 , 6, 7, 8},
                     {9 ,10,11,12},
                     {13,14,15,16}};

//        bruteForce(arr);
//        bruteForceM2(arr);
        optimalSol(arr);

        for(int i=0;i<arr.length;i++){
            System.out.println(Arrays.toString(arr[i]));
        }

    }

    public static void bruteForce(int arr[][]){     //Time O(N^2)   Space O(N^2)
        int n=arr.length;
        int m=arr[0].length;

        int res[][]=new int[n][m];
        int i_main=0;
        int j_main=m-1;

        for(int i=n-1;i>=0;i--){          //Col
            for(int j=m-1;j>=0;j--){      //Row
                res[j][i]=arr[i_main][j_main];
                j_main--;
            }
            i_main++;
            j_main=m-1;
        }

        for(int i=0;i<res.length;i++){
            System.out.println(Arrays.toString(res[i]));
        }
//        System.out.println("Done");
    }

    public static void bruteForceM2(int arr[][]){
        int n=arr.length;
        int m=arr[0].length;

        int res[][]=new int[n][m];


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res[j][(n-1)-i]=arr[i][j];
            }
        }


        for(int iter[]:res){
            System.out.println(Arrays.toString(iter));
        }
    }

    public static void optimalSol(int arr[][]){

        int n=arr.length;
        int m=arr[0].length;


        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<m;j++){
                if(i==j)    continue;
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
        for(int i=0;i<n;i++){
            ReverseArray.reverse(arr[i]);
        }
    }
}
