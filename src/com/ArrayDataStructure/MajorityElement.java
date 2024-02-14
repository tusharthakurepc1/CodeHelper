package com.ArrayDataStructure;

import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        int arr[]={1,1,1,3,3,2,2,2};


//        bruteForceDivBy2(arr);
//        betterSolDivBy2(arr);
//        optimisedSolDivBy2(arr);

        optimalSolutionDivBy3(arr);

    }
    public static void bruteForceDivBy2(int arr[]){
        for(int i=0;i<arr.length;i++){
            int count=0;
            for(int j=i;j<arr.length;j++){
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(count > arr.length/2){
                System.out.println(arr[i]);
            }
        }
    }

    public static void betterSolDivBy2(int arr[]){
        Map<Integer,Integer> m1=new HashMap<>();

        for(int i=0;i<arr.length;i++){
            if(m1.containsKey(arr[i])){
                m1.put(arr[i],m1.get(arr[i])+1);
            }
            else{
                m1.put(arr[i],1);
            }
        }

        Set<Integer> keys=m1.keySet();
        for(int iter:keys){
            if(m1.get(iter) > arr.length/2){
                System.out.println(iter);
            }
        }

        System.out.println(m1);
    }

    public static void optimisedSolDivBy2(int arr[]){
        int maj=0;
        int count=0;

        for(int i=0;i<arr.length;i++){
            if(count == 0){
                maj=arr[i];
                count++;
            }
            else if(maj == arr[i])
                count++;
            else
                count--;
        }

        int a=0;
        for(int i=0;i<arr.length;i++){
            if(maj == arr[i])   a++;
        }

        if(a > arr.length/2){
            System.out.println(maj);
        }
    }


    public static void optimalSolutionDivBy3(int arr[]){
        int max_ele1=Integer.MIN_VALUE,max_ele2=Integer.MIN_VALUE;
        int count1=0,count2=0;

        for(int i=0;i<arr.length;i++){
            if(count1==0 && max_ele2!=arr[i]){
                max_ele1=arr[i];
                count1=1;
            }
            else if(count2==0 && max_ele1!=arr[i]){
                max_ele2=arr[i];
                count2=1;
            }
            else if(arr[i] == max_ele1)     count1++;
            else if(arr[i] == max_ele2)     count2++;
            else{
                count1--;
                count2--;
            }
        }
//        System.out.println(max_ele1+" "+max_ele2);

        count1=0;   count2=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==max_ele1)    count1++;
            if(arr[i]==max_ele2)    count2++;
        }

        if(count1 > arr.length/3) System.out.println(max_ele1);
        if(count2 > arr.length/3) System.out.println(max_ele2);
    }
}
