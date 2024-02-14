package com.CP;

public class Factorial {
    public static void main(String[] args) {

        System.out.println(factorialPermetive(5));

        System.out.println("Factorial: "+factorial__TCS(5));
    }

    public static int factorialPermetive(int n){
        if(n == 0 || n == 1){
            return 1;
        }

        return n * factorialPermetive(n-1);
    }

    public static int factorial__TCS(int n){
/*
 *  Constraints: You have to find the factorial without using the * operator.
 *  Approach : 5! = 5 * 4 * 3 * 2 * 1
 *                  (5+5+5+5)
 *                  (20+20+20)
 *                  (60+60)
 *                  (120)
 */
        int res = n;
        for(int i=n;i>=1;i--){
            int temp = res;
            for(int j=i-1;j>1;j--){
                temp+=res;
            }
            res = temp;
        }
        return res;
    }
}
