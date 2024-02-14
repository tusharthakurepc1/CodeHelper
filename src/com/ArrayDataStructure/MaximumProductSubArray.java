package com.ArrayDataStructure;

public class MaximumProductSubArray {
    public static void main(String[] args) {
        int arr[] = {3, 6, 0, 10, 2, -1};

        bruteForce(arr);
        optimalSolution(arr);
    }


    public static void bruteForce(int arr[]){
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int prod = 1;
            for(int j=i;j<arr.length;j++){
                prod = prod * arr[j];

                maxi = Math.max(maxi, prod);
            }
        }

        System.out.println(maxi);
    }

    public static void optimalSolution(int arr[]){
        int prefix_prod = 1, postfix_prod = 1;
        int maxi = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            prefix_prod = prefix_prod * arr[i];
            postfix_prod = postfix_prod * arr[arr.length - i - 1];
            if (prefix_prod == 0) {
                prefix_prod = 1;
            }
            if(postfix_prod == 0){
                postfix_prod = 1;
            }

            maxi = Math.max(maxi, Math.max(prefix_prod, postfix_prod));
        }

        System.out.println(maxi);
    }
}
