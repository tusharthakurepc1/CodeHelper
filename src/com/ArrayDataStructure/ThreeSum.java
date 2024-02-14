package com.ArrayDataStructure;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int arr[]={-1,0,1,2,-1,-4};
//        List<List<Integer>> r1=bruteForce(arr);
//        System.out.println(r1);

//        bruteForceM2(arr,0);
//        betterSolution(arr);

        optimalSolution(arr,0);

    }

    public static List<List<Integer>> bruteForce(int arr[]){
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(arr);
        int sum=0;

        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                for(int k=j;k<arr.length;k++){
                    if(i == j || i == k || j == k)    continue;

                    sum=arr[i] + arr[j] + arr[k];
                    if(sum == 0){
                        List<Integer> res_sub=new ArrayList<>();
                        res_sub.add(arr[i]);
                        res_sub.add(arr[j]);
                        res_sub.add(arr[k]);
                        if(!res.contains(res_sub)){
                            res.add(res_sub);
                        }
                    }
                    sum=0;
                }
            }
        }
        return res;
    }

    public static void bruteForceM2(int arr[],int key){
        Set<Set<Integer>> res=new HashSet<>();

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                for(int k=j+1;k<arr.length;k++){
                    if(arr[i]+arr[j]+arr[k] == key){
//                        System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
                        Set<Integer> temp=new TreeSet<>();
                        temp.add(arr[i]);   temp.add(arr[j]);   temp.add(arr[k]);
                        if(temp.size() ==3)     res.add(temp);
//                    System.out.println(temp);
                    }
                }
            }
        }
        System.out.println(res);
    }

    public static void betterSolution(int arr[]){

        Set<List<Integer>> res=new HashSet<>();

        int temp_var=0;
        for(int i=0;i<arr.length;i++){
            Set<Integer> temp=new TreeSet<>();
            for(int j=i+1;j<arr.length;j++){
                temp_var=-(arr[i]+arr[j]);
                if(temp.contains(temp_var)){
                    List<Integer> res_t=new ArrayList<>();
                    res_t.add(arr[i]);  res_t.add(arr[j]);  res_t.add(temp_var);
                    Collections.sort(res_t);
                    res.add(res_t);
                }
                else{
                    temp.add(arr[j]);
                }
            }
        }
        System.out.println(res);
    }

    public static void optimalSolution(int arr[],int sum){
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(i>0 && arr[i-1] == arr[i])    continue;

            int j=i+1,k=arr.length-1;
            while(j<k){
                int temp=arr[i]+arr[j]+arr[k];
                if(temp > sum){
                    k--;
                }
                else if(temp < sum){
                    j++;
                }
                else{
                    System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
                    k--;
                    j++;
                    while(j<k && arr[k+1] == arr[k])   k--;
                    while(j<k && arr[j-1] == arr[j])   j++;
                }
            }
        }
    }
}
