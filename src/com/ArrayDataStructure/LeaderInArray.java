package com.ArrayDataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeaderInArray {
    public static void main(String[] args) {
//        Leader in Array : return the element which having all the right most elements smaller.
        int arr[]={1,2,5,3,1};
        List<Integer> res=new ArrayList<>();
//        bruteForce(arr,res);
        optimalSol(arr,res);

        System.out.println(res);
    }

    public static void bruteForce(int arr[],List<Integer> res){ //Time O(N^2)

        for(int i=0;i<arr.length;i++){
            boolean leader=true;
            for(int j=i;j<arr.length;j++){
                if(arr[i] < arr[j]){
                    leader=false;
                }
            }
            if(leader){
                res.add(arr[i]);
            }
        }
    }

    public static void optimalSol(int arr[],List<Integer> res){    //Time O(N)
        int max=Integer.MIN_VALUE;

        for(int i=arr.length-1;i>=0;i--){
            if(arr[i] > max){
                max=arr[i];
                res.add(arr[i]);
            }
        }
        Collections.reverse(res);

    }
}
