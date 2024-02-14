package com.ArrayDataStructure;

import java.util.Arrays;

public class MaxOfCol {
    public static void main(String[] args) {
        int arr[][]={
                {1,2,3,4},
                {5,2,1,1},
                {6,3,0,5}
        };

        bruteForce(arr);

    }

    public static void bruteForce(int arr[][]){
        int res[] = new int[arr[0].length];

        for(int i=0;i<arr[0].length;i++){
            int local_max = 0;
            for(int j=0;j<arr.length;j++){
                if(arr[j][i] > local_max){
                    res[i] = j;
                    local_max = arr[j][i];
                }
            }
            System.out.println(local_max);
        }
        int count = 0;
        int max = 0;
        for(int i=0;i<res.length;i++){
            if(count <= 0){
                max = res[i];
            }
            if(res[i] == max){
                count++;
            }
        }

        System.out.println("Max: "+max);


    }
}
