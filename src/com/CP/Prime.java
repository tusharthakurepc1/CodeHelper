package com.CP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prime {
    public static void main(String[] args) {

        int primes[] = primeSeive();
//        List<Integer> prime_list = nthPrimeSeive();


        countFactors(21);
    }


    public static void countFactors(int n){
        int count = 0;

        for(int i=1;i*i<n;i++){
            if(n % i == 0){
                count+=2;
            }
        }

        System.out.println(count);
    }


    public static void countPrimeNumbers(){
        int primes[] = new int[(int)Math.pow(10, 6) * 5];
        int no_of_primes[] = new int[primes.length];
        Arrays.fill(primes, 1);
        primes[0] = primes[1] = 0;

        int count = 0;

        for(int i=2;i<primes.length;i++){
            no_of_primes[i] = count;
            if(primes[i] == 0)  continue;

            count++;
            for(int j= i*2;j<primes.length;j+=i){
                primes[j] = 0;
            }
        }

        System.out.println(no_of_primes[106543]);
    }

    /*
     * This method is returning the nth prime number from the range of 2 to 5 * 10^6
     */
    public static List<Integer> nthPrimeSeive(){
        int primes[] = new int[(int)Math.pow(10, 6) * 5];
        Arrays.fill(primes, 1);
        primes[0] = primes[1] = 0;

        List<Integer> prime_list = new ArrayList<>();

        for(int i = 2; i < primes.length;i++){
            if(primes[i] == 0)  continue;

            prime_list.add(i);
            for(int j = i*2;j < primes.length;j+=i){
                primes[j] = 0;
            }
        }

        return prime_list;
    }

    /*
     *  This method is returning if the ith number is prime of not from range of 2 to 5 * 10^6
     */
    public static int[] primeSeive(){                   //Time complexity: O(n * sqrt(n))
        int primes[] = new int[(int)Math.pow(10, 6) * 5];
        Arrays.fill(primes, 1);
        primes[0] = primes[1] = 0;

        for(int i=2;i*i<primes.length;i++){
            if(primes[i] == 0)  continue;

            for(int j= i*i; j < primes.length;j+=i){
                primes[j] = 0;
            }
        }

        return primes;
    }


    public static void primeUpToN(int n){           //Time Complexity: O(N^2)
        for(int num=2;num< n;num++){
            int count = 0;
            for(int i=1;i<=n;i++){
                if(num % i == 0){
                    count++;
                }
            }
            if(count == 2){
                System.out.print(num+" ");
            }
        }
    }


}
