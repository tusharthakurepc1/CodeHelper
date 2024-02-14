package com.Recursion;

public class FibonacciNumber {
    public static void main(String[] args) {
//        int n = 10;
//        System.out.println(helper(10));
        int a = 86;
        int b = 77;
        int n = 15;


        System.out.println(specialFibonacci(a, b, n));
    }
    public static int helper(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        return helper(n-1) + helper(n-2);
    }

    public static int specialFibonacci(int a, int b, int n){
        if(n == 0){
            return a;
        }
        if(n == 1){
            return b;
        }
        return specialFibonacci(a, b, n-1) ^ specialFibonacci(a, b,n-2);
    }
}
