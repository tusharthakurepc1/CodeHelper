package com.ArrayDataStructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindDuplicateElement {
    public static void main(String[] args) {
        int arr[] = {1,3,4,2,2};

//        bruteForce(arr);
        optimalSolution(arr);

    }
    public static void bruteForce(int arr[]){
        Map<Integer,Integer> map = new HashMap();

        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i]) && map.get(arr[i]) == 1){
                System.out.println(arr[i]);
                break;
            }
            else{
                map.put(arr[i],1);
            }
        }
    }

    public static void optimalSolution(int arr[]){

        for(int i=0;i<arr.length;i++){
            int value = arr[Math.abs(arr[i])];

            if(value >= 0){
                arr[Math.abs(arr[i])] = -value;
            }
            else{
                System.out.println(Math.abs(arr[i]));
            }

        }
        System.out.println(Arrays.toString(arr));

    }
}
