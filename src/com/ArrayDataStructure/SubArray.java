package com.ArrayDataStructure;

import com.BasicLibTCT;

import java.util.*;

public class SubArray {
    public static void main(String[] args) {
        int arr[] = {1,3,1,2,2};

//        Set<Map<Integer,Integer>> set = new TreeSet<>();
//
//        Map<Integer,Integer> map = new TreeMap<>();
//        map.put(10,10);
//        map.put(20,20);
//        map.put(30,30);




//        uniqueSubArrayBruteForce(arr);
//        System.out.println(sumSubArray(arr));
        uniqueSubArrayOptimal(arr,3);

    }


    public static void uniqueSubArrayBruteForce(int arr[]){
        System.out.println("Array: "+Arrays.toString(arr));

        int left = 0, right = 1;

        while(left <= arr.length || right <= arr.length){
            while(right <= arr.length){
                System.out.println(Arrays.toString(Arrays.copyOfRange(arr,left,right)));
                right++;
            }
            left++;
            right = left + 1;
        }
    }

    public static boolean sumSubArray(int arr[]){
        System.out.println("Array: "+Arrays.toString(arr));

        int left = 0, right = 1;
        int sum = 0;
        int k = 6;
        while(left < arr.length || right < arr.length){
            right--;
            while(right < arr.length){
                sum = sum + arr[right];
                if(sum % k == 0 && (right - left) >= 1){
                    System.out.println(Arrays.toString(Arrays.copyOfRange(arr,left,right+1))+" "+sum);
                    return true;
                }
                right++;
            }

            sum = 0;
            left++;
            right = left + 1;
        }

        return false;
    }

    public static void uniqueSubArrayOptimal(int arr[],int k){
        Map<Integer,Integer> map = new TreeMap<>();
        int prefixsum = 0;
        int max_len = 0;

        for(int i=0; i<arr.length; i++){
            prefixsum += arr[i];
            if(prefixsum == k){
                max_len = Math.max(max_len,i+1);
            }

            int rem = prefixsum - k;
            if(map.containsKey(rem)){
                int temp = map.get(rem);

                temp = i - temp;
                max_len = Math.max(max_len,temp);
            }

            map.put(prefixsum, i);
        }
        System.out.println(max_len);
        System.out.println(map);


    }
}




