package com.Recursion;

public class CountGoodStrings {
    public static void main(String[] args) {
        long n = 50;

//        System.out.println("LONG: "+Long.MAX_VALUE);
        long res = helper(n-1);
        System.out.println(res);

        helper2(n);

//        System.out.println(powCustom(4, 0));
    }

    public static void helper2(long n){
        long res = 1;

        if(n % 2 == 0){
            res = powCustom(5, n/2);
            res = res * powCustom(4, n/2);
        }
        else {
            res = (powCustom(4, (n/2) + 1) * powCustom(5, n/2));
        }

        System.out.println(Integer.MAX_VALUE);
        System.out.println(res);

    }

    public static long powCustom(long x, long n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }

        if(n % 2 == 0){
            long temp = powCustom(x, n/2);
            return temp * temp;
        }
        else{
            return x * powCustom(x, n-1);
        }
    }

    public static long helper(long ind){
        if(ind == 0) {
            return 5;
        }

        if(ind % 2 == 0){
            return 5 * helper(ind-1);
        }
        else{
            return 4 * helper(ind-1);
        }
    }
}
