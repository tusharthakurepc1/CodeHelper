package com.ArrayDataStructure;

import java.lang.reflect.Array;
import java.util.Arrays;
import com.ArrayDataStructure.ReverseArray;

public class LeftRotateArray {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};

//        leftRotateOneOptimal(arr);
//        leftRotateDthElementBruteForce(arr,1);
        leftRotateDthElementOptimal(arr,0);
//        rightRotateDthElementBruteForce(arr,1);

        System.out.println(Arrays.toString(arr));
    }
    public static void leftRotateOneOptimal(int arr[]){        //Time O(n)  Space O(1)
        int temp=arr[0];

        for(int i=1;i<arr.length;i++){
            arr[i-1]=arr[i];
        }
        arr[arr.length-1]=temp;
    }

    public static void leftRotateDthElementBruteForce(int arr[],int d){     //Time O(n+d)   Space O(d)
        int temp[]=new int[d];

        for(int i=0;i<d;i++){
            temp[i]=arr[i];
        }

        for(int i=d;i<arr.length;i++){
            arr[i-d]=arr[i];
        }

        int iter=0;
        for(int i=(arr.length-temp.length);i<arr.length;i++){
            arr[i]=temp[iter];
            iter++;
        }
    }

    public static void leftRotateDthElementOptimal(int arr[],int d){        //Time O(2N)    Space O(1)
        ReverseArray.reversePosA2Optimal(arr,0,d-1);
        ReverseArray.reversePosA2Optimal(arr,d,arr.length-1);
        ReverseArray.reverse(arr);
    }

    public static void rightRotateDthElementBruteForce(int arr[],int d){
        d=d%arr.length;

        int temp[]=new int[d];
        int iter=0;
        int n=arr.length;
        for(int i=n-d;i<n;i++){
            temp[iter]=arr[i];
            iter++;
        }

        for(int j=(n-d)-1;j>=0;j--){
            arr[j+d]=arr[j];
        }

        for(int k=0;k<temp.length;k++){
            arr[k]=temp[k];
        }

    }

}
