package com.CP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

public class SegementedSeive {
    public static boolean primes[] = new boolean[(int)Math.pow(10, 9) + 1];



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int tc = sc.nextInt();

        for(int i=0;i<tc;i++){
            int left = sc.nextInt();
            int right = sc.nextInt();

            segementedSeive(left, right);
        }
    }

    public static void segementedSeive(int left, int right){
        primeSeive();
        List<Integer> prime_list = new ArrayList<>();

        for(int i=2;i<primes.length && i*i < right;i++){
            if(primes[i])   prime_list.add(i);
        }

        boolean seive_l_r[] = new boolean[right - left + 1];
        Arrays.fill(seive_l_r, true);


        for(int el: prime_list){
            int temp = (int)(left / el) * el;
            if(temp < left) temp += el;

            for(int i=Math.max(el*el, temp); i<=right;i+=el){
                seive_l_r[i-left] = false;
            }

        }


        for(int i=left;i<=right;i++){
            if(seive_l_r[i-left] && i != 0 && i != 1){
                System.out.println(i);
            }
        }
        System.out.println();

    }

    public static void primeSeive(){
        Arrays.fill(SegementedSeive.primes, true);

        SegementedSeive.primes[0] = SegementedSeive.primes[1] = false;

        for(int i=2;i*i< SegementedSeive.primes.length;i++){
            if(!SegementedSeive.primes[i])   continue;

            for(int j = i*i;j<SegementedSeive.primes.length;j+=i){
                SegementedSeive.primes[j] = false;
            }
        }
    }
}

