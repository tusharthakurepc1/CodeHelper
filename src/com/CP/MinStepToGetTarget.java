package com.CP;

public class MinStepToGetTarget {
    public static void main(String[] args) {
        int arr[] = {2, 1, 4, 3, 5, 6};
        int target = 1;
        //  Expected ans: 3 (1 + 5 + 25)

        int ans = minTargetRecursive(arr, arr.length-1, target);
        if(ans == Short.MAX_VALUE){
            System.out.println("-1");
        }
        else{
            System.out.println(ans);
        }
    }


    public static int minTargetRecursive(int arr[], int ind, int target){
        if(target == 0){
            return 0;
        }
        if(ind == 0){
            if(target == arr[ind])  return 1;
            else    return Short.MAX_VALUE;
        }
        if(target < 0)  return Short.MAX_VALUE;


        int take_it = 1 + minTargetRecursive(arr, ind-1, target-arr[ind]);
        int not_take_it = minTargetRecursive(arr, ind-1, target);

        return Math.min(take_it, not_take_it);
    }


    public static int minTargetDP(int arr[], int ind, int target){
        if(ind == 0){
            if(target == arr[ind])  return 1;
            else    return Short.MAX_VALUE;
        }
        if(target == 0){
            return 0;
        }
        if(target < 0)  return Short.MAX_VALUE;


        int take_it = 1 + minTargetDP(arr, ind-1, target-arr[ind]);
        int not_take_it = minTargetDP(arr, ind-1, target);

        return Math.min(take_it, not_take_it);
    }

}
