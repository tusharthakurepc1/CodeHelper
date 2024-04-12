package com.SlidingWindow;

public class BinarySubArrayWithSum {
    public static void main(String[] args) {
        int arr[] = {1,0,1,0,1};
        int target = 2;

        bruteForce(arr, target);
        optimalSolution(arr, target);
    }

    public static void optimalSolution(int arr[], int target){
        int sum = 0;
        int left = 0;
        int count = 0;

        for(int right=0; right<arr.length; right++){

            if(arr[right] == 1){
                //for value is one

                if(sum < target){
                    //increase the window to the right side
                    sum += arr[right];
                    if(sum == target){
                        count++;
                        System.out.println(left+" "+right);
                    }
                }
                else{
                    sum += arr[right];

                    //shrink the window to the left side and count ans when equals to the target
                    while(left <= right && sum >= target){
                        if(sum == target){
                            count++;
                            System.out.println(left+" "+right);
                        }
                        sum -= arr[left];

                        left++;
                    }

                }

            }
            else{
                //for value in zero
                if(sum == target){
                    count++;
                    System.out.println(left+" "+right);
                }
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
