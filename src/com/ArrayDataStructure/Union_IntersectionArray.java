package com.ArrayDataStructure;

import java.util.*;

public class Union_IntersectionArray {
    public static void main(String[] args) {
        int arr1[]={4,7,9,7,6,7};
        int arr2[]={5,0,0,6,1,6,2,2,4};

//        unionMethod1(arr1,arr2);
//        unionMethod2(arr1,arr2);
//        intersection(arr1,arr2);
        intersection_unique(arr1,arr2);

    }
    public static void unionMethod1(int arr1[],int arr2[]){
        Map<Integer,Integer> m1=new HashMap<>();

        for(int i=0;i< arr1.length;i++){
            if(m1.containsKey(arr1[i])){
                m1.put(arr1[i],m1.get(arr1[i])+1);
            }
            else{
                m1.put(arr1[i],1);
            }
        }

        for(int i=0;i< arr2.length;i++){
            if(m1.containsKey(arr2[i])){
                m1.put(arr2[i],m1.get(arr2[i])+1);
            }
            else{
                m1.put(arr2[i],1);
            }
        }


//        System.out.println(m1);
        System.out.println(m1.keySet());
    }

    public static void unionMethod2(int arr1[],int arr2[]){
        Set<Integer> s1=new TreeSet<>();

        for(int i=0;i<arr1.length;i++){
            s1.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            s1.add(arr2[i]);
        }

        System.out.println(s1);
    }

    public static void intersection(int arr1[],int arr2[]){
        Map<Integer,Integer> m1=new HashMap<>();

        for(int i=0;i<arr1.length;i++){
            if(m1.containsKey(arr1[i])){
                m1.put(arr1[i],m1.get(arr1[i])+1);
            }
            else{
                m1.put(arr1[i],1);
            }
        }
        List<Integer> res=new ArrayList<>();

        for(int i=0;i<arr2.length;i++){
            if(m1.containsKey(arr2[i])){
                m1.put(arr2[i],m1.get(arr2[i])-1);
                if(m1.get(arr2[i]) >= 0){
                    res.add(arr2[i]);
                }
            }
        }
        int arr_list[]=new int[res.size()];
        for(int i=0;i<res.size();i++){
            arr_list[i]=res.get(i);
        }


        System.out.println(Arrays.toString(arr_list));

    }

    public static void intersection_unique(int arr1[],int arr2[]){
        Map<Integer,Integer> m1=new HashMap<>();

        for(int i=0;i<arr1.length;i++){
            if(m1.containsKey(arr1[i])){
                m1.put(arr1[i],m1.get(arr1[i])+1);
            }
            else{
                m1.put(arr1[i],1);
            }
        }
        Set<Integer> res=new TreeSet<>();

        for(int i=0;i<arr2.length;i++){
            if(m1.containsKey(arr2[i])){
                m1.put(arr2[i],m1.get(arr2[i])-1);
                if(m1.get(arr2[i]) >= 0){
                    res.add(arr2[i]);
                }
            }
        }
        int arr_list[]=new int[res.size()];
        int i=0;
        for(int ele:res){
            arr_list[i++]=ele;
        }


        System.out.println(Arrays.toString(arr_list));


    }
}
