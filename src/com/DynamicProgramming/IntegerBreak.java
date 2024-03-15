package com.DynamicProgramming;

public class IntegerBreak {
    public static void main(String[] args) {
        int n = 3;

        System.out.println(recursiveSolution(n));
    }

    public static int recursiveSolution(int n){
        if(n <= 2){
            return 1;
        }

        //All ways to make n
        int temp = 1;
        for(int i=2;i<=n;i++){
             temp = Math.max(temp, (i * recursiveSolution(n-i)));
        }

        return temp;
    }
}
