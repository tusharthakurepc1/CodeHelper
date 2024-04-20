package com;

public class Interview {

    public static void main(String[] args) {
        int arr[] = {1, -2, -3, 4, 5};

        System.out.println(helper(arr, 0));
    }

    public static int helper(int arr[], int ind){
        if(ind >= arr.length){
            return 0;
        }

        //take case
        int take_it = arr[ind] + helper(arr, ind + 2);

        //not take_case
        int not_take_it = helper(arr, ind+1);


        return Math.max(take_it, not_take_it);
    }

}
