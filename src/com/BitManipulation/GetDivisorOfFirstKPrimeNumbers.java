package com.BitManipulation;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class GetDivisorOfFirstKPrimeNumbers {
    public static void main(String[] args) {

        int n = 1000000000;
        int k = 3;

//        getAllTheDivisor(n, k);
        getAllTheDivisorOptimal(n, k);
    }

    public static void getAllTheDivisorOptimal(int n, int k){
        List<Integer> primes = getPrimesK(k);
        int count = 0;

        for(int i=1;i< (1 << k) ;i++){
            int lcm = 1;
            int parity = 0;
            for(int bit = 0;bit < k ;bit++){
                if(((i >> bit)  & 1) == 1){
                    lcm *= primes.get(bit);
                    parity++;
                }
            }

            int div = n / lcm;

            if(parity % 2 == 0){
//                Even
                count -= div;
            }
            else{
                count += div;
            }

//            System.out.println(i+ " " + lcm);
        }
        System.out.println(count);
    }

    public static void getAllTheDivisor(int n, int k){
        List<Integer> primes = getPrimesK(k);
        System.out.println("Primes are: "+ primes);
        Set<Integer> res = new LinkedHashSet<>();

        for(int i=1;i<=n;i++){
            for(int el: primes){
                if(i % el == 0){
                    res.add(i);
                }
            }
        }

        System.out.println(res);

    }

    public static List<Integer> getPrimesK(int k){
        List<Integer> res = new ArrayList<>();

        for(int num =1;;num++){
            if(res.size() >= k){
                break;
            }
            int count = 0;

            for(int i = 1;i<= num;i++){
                if(num % i == 0){
                    count ++;
                }
            }

            if(count == 2){
                res.add(num);
            }
        }

        return res;
    }
}
