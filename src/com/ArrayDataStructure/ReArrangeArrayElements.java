package com.ArrayDataStructure;

import java.util.Arrays;

public class ReArrangeArrayElements {
    public static void main(String[] args) {
        int arr[]={28,-41,22,-8,-37,46,35,-9,18,-6,19,-26,-37,-10,-9,15,14,31};

//        bruteForce(arr);
        optimalSol(arr);

    }
    public static void bruteForce(int arr[]){
        int arr_pos[]=new int[arr.length/2],a=0;
        int arr_neg[]=new int[arr.length/2],b=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] < 0){
                arr_neg[b]=arr[i];
                b++;
            }
            else{
                arr_pos[a]=arr[i];
                a++;
            }
        }
        a=0;
        b=0;
        for(int i=0;i<arr.length/2;i++){
            arr[i*2]=arr_pos[a++];
            arr[i*2+1]=arr_neg[b++];
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void optimalSol(int arr[]){
        int arr_res[]=new int[arr.length];
        int pos=0,neg=1;

        for(int i=0;i<arr.length;i++){
            if(arr[i] < 0 && neg < arr.length){
                arr_res[neg]=arr[i];
                neg+=2;
            }
            else if(arr[i] >=0 && pos < arr.length){
                arr_res[pos]=arr[i];
                pos+=2;
            }
        }

        System.out.println(Arrays.toString(arr_res));
    }

}
