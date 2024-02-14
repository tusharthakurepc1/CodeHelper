package com.ArrayDataStructure;

public class LongestSubArray {
    public static void main(String[] args) {
        int arr[]={1,2,4,4,5,5,5};

//        bruteForce(arr,10);
//        bruteForceOptimised(arr,10);
        optimalSol(arr,15);

    }

    public static void bruteForce(int arr[],int key){   //O(N^3)
        int sum=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                for(int k=i;k<=j;k++){
                    sum=sum+arr[k];
                }
                if(sum == key){
                    System.out.println("("+i+" "+j+")");
                }
                sum=0;
            }
        }
    }

    public static void bruteForceOptimised(int arr[],int key){  //O(N^2)
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum=sum+arr[j];

                if(sum == key){
                    System.out.println("("+i+" "+j+")");
                }
            }
        }
    }

    public static void optimalSol(int arr[],int key){       //O(2*N)
        int left=0,right=0;
        int sum=arr[0];

        while(right < arr.length){

            while(sum > key){
                sum-=arr[left];
                left++;
            }

            if(sum == key){
                System.out.println("Yes "+left+" "+right);
    //                return;
            }

            right++;
            if(right < arr.length){
                sum+=arr[right];
            }

        }

    }

}
