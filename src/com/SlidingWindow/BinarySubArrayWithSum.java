package com.SlidingWindow;

public class BinarySubArrayWithSum {
    public static void main(String[] args) {
        int arr[] = {1,0,1,0,1};
        int target = 2;

        bruteForce(arr, target);
        optimalSolution(arr, target);
    }

    public static void optimalSolution(int arr[], int target){
        int left = 0;
        int count = 0;
        int ones = 0;

        for(int right=0; right<arr.length; right++){

            if(arr[right] == 1){
                ones += 1;
            }

            while(ones > target){
                if(arr[left] == 1){
                    ones -= 1;
                    break;
                }
                left++;
            }

            if(target == ones){
                count++;
            }

        }


        System.out.println(count);
    }


    //Time complexity: O(n^2)
    //Space complexity: O(1)
    public static void bruteForce(int arr[], int target){
        int count = 0;

        for(int left=0; left<arr.length; left++){
            int once = 0;
            for(int right=left; right<arr.length; right++){

                if(arr[right] == 1){
                    once++;
                }

                if(target == once){
                    count++;
                }
                else if(once > target){
                    break;
                }

            }
        }

        System.out.println(count);
    }

}
