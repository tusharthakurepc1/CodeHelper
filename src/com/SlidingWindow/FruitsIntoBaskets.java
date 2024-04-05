package com.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitsIntoBaskets {
    public static void main(String[] args) {
        int arr[] = {3, 3 ,3, 1, 2, 1, 1, 2, 3, 3, 4};
        int box = 2;

        bruteForce(arr, box);
        optimalSolution(arr, box);
    }

    //Time complexity: O(2n)
    //Space complexity: O(k+1)
    public static void optimalSolution(int arr[], int k){
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int max_len = 0;

        for(int right=0; right<arr.length; right++){
            if(map.containsKey(arr[right])){
                map.put(arr[right], map.get(arr[right]) + 1);
            }
            else{
                map.put(arr[right], 1);
            }

            while(map.size() > k){

                if(map.containsKey(arr[left])){
                    map.put(arr[left], map.get(arr[left]) - 1);
                }
                if(map.get(arr[left]) <= 0){
                    map.remove(arr[left]);
                }
                left++;

            }

            max_len = Math.max(max_len, right-left+1);

        }

        System.out.println(max_len);


    }

    //Time complexity: O(n^2)
    //Space complexity: O(k+1)
    public static void bruteForce(int arr[], int k){
        int box = k;
        int max_len = 0;

        for(int left=0; left<arr.length; left++){

            Set<Integer> set = new HashSet<>();
            for(int right=left; right<arr.length; right++){
                set.add(arr[right]);

                if(set.size() > k)  break;

                max_len = Math.max(max_len, right-left +1);
            }

        }
        System.out.println(max_len);


    }
}
