package com.CP;

import com.BasicLibTCT;

public class Divisors {
    public static void main(String[] args) {
//        printDivisors(999999999);
//        System.out.println();
        printDivisorOptimal(16);
        primeDivisors(999999999);


//        System.out.println(Math.log(1024) / Math.log(2));
    }

    /*
     * Factors of 16 is: 1, 2, 4, 8, 16
     * 1 * 16
     * 2 * 8
     * 4 * 4
     * 8 * 2
     * 16 * 1
     *
     */

    public static void primeDivisors(int n){        //Time Complexity: O(sqrt(n) * n)
        /*
         *  O(sqrt(n)) is used to find all the factors and O(n) is used to check is all the factors is prime or not
         *  Time Complexity of Prime Divisor is O(sqrt(n) * n)
         */
        int i=0;
        for(i=1;i * i < n;i++){
            if(n % i == 0){
                if(BasicLibTCT.isPrime(i)){
                    System.out.print(i+" ");
                }
                if(BasicLibTCT.isPrime(n/i)){
                    System.out.println(n/i+" ");
                }
            }
        }
        if(n % i == 0){
            if(BasicLibTCT.isPrime(i)){
                System.out.println(i);
            }
        }


    }

    public static void printDivisorOptimal(int n){      //Time Complexity: O(sqrt(n))
        int i = 0;
        for(i=1;i * i < n;i++){
            if(n % i == 0){
                System.out.print(i+" "+n/i+" ");
            }
        }
        if(n % i == 0){
            System.out.println(i);
        }
    }

    public static void printDivisors(int n){            //Time Complexity: O(n)
        for(int i=1;i<=n;i++){
            if(n % i == 0){
                System.out.print(i+ " ");
            }
        }
    }
}
