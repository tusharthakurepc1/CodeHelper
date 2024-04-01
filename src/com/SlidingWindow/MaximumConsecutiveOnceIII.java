package com.SlidingWindow;

public class MaximumConsecutiveOnceIII {
    public static void main(String[] args) {
        int arr[] = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        bruteForce(arr, k);
        optimalSolution(arr, k);
    }

    public static void optimalSolution(int arr[], int k){
        int left = 0;
        int zeros = k, max_len = 0;

        for(int right=0; right<arr.length; right++){
            if(arr[right] == 0){
                zeros --;
            }

            while(zeros < 0){
                if(arr[left] == 0)  zeros ++;

                left++;
            }

            max_len = Math.max(max_len, right-left + 1);
        }

        System.out.println(max_len);

    }


    //Time complexity: O(n^2)
    //Space complexity: O(1)
    public static void bruteForce(int arr[], int k){
        int max_len = 0;

        for(int left=0; left<arr.length; left++){
            int count = 0;

            for(int right=left; right<arr.length; right++){

               if(arr[right] == 0)  count++;

               if(count > k){
                   break;
               }
               max_len = Math.max(max_len, right-left + 1);
            }

        }
        System.out.println(max_len);
    }

}
