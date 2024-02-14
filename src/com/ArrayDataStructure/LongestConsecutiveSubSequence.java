package com.ArrayDataStructure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubSequence {
    public static void main(String[] args) {
        int arr[]={0,3,7,2,5,8,4,6,0,1};
        int len=0;
        len=burteForce(arr);
//        len=bruteForceA2(arr);
//        len=betterSolution(arr);
//        len=optimalSolution(arr);


        System.out.println(len);
    }

    public static int burteForce(int arr[]){
        int max_len=1;
        int next=0;

        for(int i=0;i<arr.length;i++){
            next=arr[i]+1;
            int count=1;
            for(int j=0;j<arr.length;j++){
                if(i == j)  continue;

                if(arr[j] == next){
                    count++;
                    next=arr[j]+1;
                    j=0;
                }

            }
            if(count > max_len){
                max_len=count;
                System.out.println(i);
            }
        }


        return max_len;
    }

    public static int bruteForceA2(int arr[]){
        int max_len=1;


        for(int i=0;i<arr.length;i++){
            int count=1;
            int next=arr[i]+1;
            while(linearSearch(arr,next)){
                count++;
                next++;
            }
            if(count > max_len){
                max_len=count;
            }
        }

        return max_len;
    }

    public static boolean linearSearch(int arr[],int chk){

        for(int iter=0;iter<arr.length;iter++){
            if(arr[iter] == chk){
                return true;
            }
        }


        return false;
    }

    public static int betterSolution(int arr[]){
        int max=Integer.MIN_VALUE;
        int count=0;
        int smaller_current=Integer.MIN_VALUE;

        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
        for(int i=0;i<arr.length;i++){
            if(arr[i]-1 == smaller_current){
                count++;
                smaller_current=arr[i];
            }
            else if(arr[i] != smaller_current){
                count=1;
                smaller_current=arr[i];
            }
            if(count > max){
                max=count;
            }
        }
        return max;
    }

    public static int optimalSolution(int arr[]){
        int max=Integer.MIN_VALUE;
        int grater_current=Integer.MIN_VALUE;
        int count=0;

        Set<Integer> s1=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            s1.add(arr[i]);
        }

        for(int i:s1){

            if(s1.contains(i-1)){
                continue;
            }
            grater_current=i;
            while(s1.contains(grater_current)){
                count++;
                grater_current++;
            }

            if(count > max){
                max = count;
            }
        }



        return max;
    }
}
