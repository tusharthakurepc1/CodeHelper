package com.Recursion;

public class Power_LCP50 {
    public static void main(String[] args) {
        double x = 1.0000;
        long n = -2147483648;

        double res = recursiveSolution(x, Math.abs(n));
        if(n < 0)
            System.out.println(1/res);
        else
            System.out.println(res);
    }

    public static double recursiveSolution(double x, long n){
        if(n == 1){
            return x;
        }
        if(n % 2 == 0){
            double temp = recursiveSolution(x, n / 2);
            return temp * temp;
        }
        else{
            return x * recursiveSolution(x, n - 1);
        }
    }
}
