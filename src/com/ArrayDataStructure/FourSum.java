package com.ArrayDataStructure;

import com.sun.corba.se.impl.orbutil.graph.GraphImpl;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int arr[]={2,2,2,2,2};

//        bruteForce(arr,0);
//        System.out.println(betterSol(arr,8));
        optimalSol(arr,8);

    }
    public static void bruteForce(int arr[],int key){   //Time O(n^4)   Space O(1)
        Arrays.sort(arr);
        int sum=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                for(int k=j+1;k<arr.length;k++){
                    for(int l=k+1;l<arr.length;l++){
                        sum=arr[i]+arr[j]+arr[k]+arr[l];
                        if(sum==key){
                            System.out.println(arr[i]+" "+arr[j]+" "+arr[k]+" "+arr[l]);
                        }
                    }
                }
            }
        }
    }

    public static List<List<Integer>> betterSol(int arr[],int sum){

        List<List<Integer>> res=new ArrayList<>();

        int temp=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                Set<Integer> temp_st=new HashSet<>();
                for(int k=j+1;k<arr.length;k++){
                    temp=sum-(arr[i]+arr[j]+arr[k]);
                    if(temp_st.contains(temp)){
                        List<Integer> res_t=new ArrayList<>();
                        res_t.add(arr[i]);  res_t.add(arr[j]);  res_t.add(arr[k]);  res_t.add(temp);
                        Collections.sort(res_t);
                        if(!res.contains(res_t))
                            res.add(res_t);
//                        System.out.println(arr[i]+" "+arr[j]+" "+arr[k]+" "+temp);
                    }
                    else{
                        temp_st.add(arr[k]);
                    }
                }
            }
        }

        return res;
    }

//    For optimal solution array need to be sorted : Array gonna modified.
    public static void optimalSol(int arr[],int key){
        Arrays.sort(arr);
        int sum=0;
        for(int i=0;i<arr.length;i++){
            if(i>0 && arr[i-1] == arr[i])  continue;
            for(int j=i+1;j<arr.length;j++){
                if(j>i+1 && arr[j-1] == arr[j])  continue;
                int k=j+1,l=arr.length-1;
                while(k < l){
                    sum=arr[i]+arr[j]+arr[k]+arr[l];
                    if(sum < key){
                        k++;
                    }
                    else if(sum > key){
                        l--;
                    }
                    else{
                        System.out.println(arr[i]+" "+arr[j]+" "+arr[k]+" "+arr[l]);
                        k++;
                        l--;
                        while(l<k && arr[k-1] == arr[k])    k++;
                        while(l<k && arr[l+1] == arr[k])    l--;
                    }
                }
            }
        }
    }
}
