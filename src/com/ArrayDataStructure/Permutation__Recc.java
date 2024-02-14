package com.ArrayDataStructure;

import com.ArrayDataStructure.ReverseArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation__Recc {
    public static void main(String[] args) {

//        int arr[]={1,5,8,4,7,6,5,3,1};
//        int arr[]={2, 1, 5, 4, 3, 0, 0};
        int arr[] = {1, 3, 2};

//        List<List<Integer>> res=new ArrayList<>();
//        List<Integer> current=new ArrayList<>();
//        boolean flag[]=new boolean[arr.length];

//        System.out.println(Arrays.toString(flag));
//        approach1(arr,current,res,flag);
        nextPermutationA2(arr);
//        System.out.println(res);

    }

    public static void approach1(int arr[],List<Integer> current,List<List<Integer>> res,boolean flag[]){
        if(current.size() == arr.length){
            List<Integer> temp=new ArrayList<>(current);
            if(!res.contains(temp)){
                res.add(temp);
            }
            return;
        }

        for(int i=0;i<arr.length;i++){
            if(!flag[i]){
                flag[i]=true;
                current.add(arr[i]);
                approach1(arr,current,res,flag);

                current.remove(current.size()-1);
                flag[i]=false;
            }
        }
    }

    public static void approach2(int arr[],int count,List<List<Integer>> res){
        if(count >=arr.length){
            List<Integer> current=new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                current.add(arr[i]);
            }
            if(!res.contains(current)){
                res.add(current);
            }
            return;
        }

        for(int i=count;i<arr.length;i++){
            int temp=arr[count];
            arr[count]=arr[i];
            arr[i]=temp;

            approach2(arr,count+1,res);

//            count--;
            temp=arr[count];
            arr[count]=arr[i];
            arr[i]=temp;

        }

    }

    public static void nextPermutation(int arr[],int nextPermu[],int count,List<List<Integer>> res){
        approach2(arr,count,res);


        List<Integer> temp=new ArrayList<>();
        for(int i=0;i<nextPermu.length;i++){
            temp.add(nextPermu[i]);
        }

        if(res.indexOf(temp) == res.size()-1){
            System.out.println(res.get(0));
        }
        else if(res.contains(temp)){
            System.out.println(res.get(res.indexOf(temp)+1));
        }
        else{
            System.out.println(res.get(0));
        }

        System.out.println(res);
    }

    public static void nextPermutationA2(int arr[]){
        int index=-1;

        for(int i=arr.length-1;i>0;i--){
            if(arr[i] > arr[i-1]){
                index=i;
                break;
            }
        }
        if(index == -1){
            ReverseArray.reversePosCount(arr,0,arr.length);
        }
        else{
            int maxi=index;
            int prev=index-1;
            for(int i=index+1;i<arr.length;i++){
                if(arr[i] > arr[prev] && arr[i] <= arr[maxi]){
                    maxi=i;
                }
            }

            int temp=arr[maxi];
            arr[maxi]=arr[prev];
            arr[prev]=temp;

            System.out.println(Arrays.toString(arr));
            ReverseArray.reversePosCount(arr,index,arr.length-index);
        }



        System.out.println(Arrays.toString(arr));
    }


}
