package com.ArrayDataStructure;

public class MaximumSubArray {
    public static void main(String[] args) {
        int arr[]={1, 2, 3, 4};

//        bruteForce(arr);
//        betterSolution(arr);
        optimalSolutionP2(arr);

    }

    public static void bruteForce(int arr[]){       //O(N^3)
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                for(int k=i;k<=j;k++){
                    sum+=arr[k];
                }
                max=Math.max(max,sum);
                sum=0;
            }
        }
        System.out.println("Max is :"+max);

    }

    public static void betterSolution(int arr[]){           //O(N^2)
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                max=Math.max(max,sum);
            }
        }
        System.out.println("Max is :"+max);


    }

    public static void optimalSolution(int arr[]){
        int max=Integer.MIN_VALUE;
        int sum=0;
        int start=-1,ans_start=-1,end=-1;

        for(int i=0;i<arr.length;i++){
            if(sum==0){
                start = i;
            }

            sum+=arr[i];
            if(sum < 0){
                sum=0;
            }

            if(sum > max){
                max=sum;
                ans_start=start;
                end=i;
            }
//            max=Math.max(sum,max);

        }
        System.out.println(max+ " is on : "+ans_start+" "+end);
    }

    public static void optimalSolutionP2(int arr[]){
        int max=arr[0];
        int sum=0;

        for(int i=0;i<arr.length;i++){

            sum+=arr[i];
            max=Math.max(sum,max);

            if(sum < 0){
                sum=0;
            }

        }
        System.out.println(max);
    }

}
