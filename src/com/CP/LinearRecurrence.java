package com.CP;

public class LinearRecurrence {
    public static void main(String[] args) {

        System.out.println(fibo_iter(500));
//        System.out.println(f(50));

    }

    public static long fibo_iter(int n){        //O(n) times and O(1) space
        long f1 = 0, f2 = 1;
        long f3 = 0;

        for(long i=2;i<n;i++){
            f3 = f1+ f2;
            f1 = f2;
            f2 = f3;
        }

        return f3;
    }

    public static long f(long n){               //O(2^n) time complexity and O(n) space
        if(n == 0)  return 0;
        if(n == 1)  return 1;

        return f(n-1) + f(n-2);
    }

}
