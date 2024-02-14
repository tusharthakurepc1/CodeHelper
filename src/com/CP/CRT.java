package com.CP;

import com.BasicLibTCT;

import java.util.Arrays;

public class CRT {
    public static int mod = 1000000007;

    public static void main(String[] args) {
        int primes[] = {3,4,11};
        int rem[] = {2,1, 7};

        System.out.println(chineseReminderTheorem(rem, primes));
    }

    /*
     * Chinese Remainder Theorem
     * In which you have to find the value of N where certain statement just to be satisfy. This is generally used in
     * cryptography
     * Ex: Value of n is 209/2
     * 1>   n % 7 = 3
     * 2>   n % 5 = 2
     * 3>   n % 2 = 1
     */
    public static int chineseReminderTheorem(int rem[], int primes[]){

        int lcm = findLCM(primes);
        int ans = 0;

        for(int i=0;i<primes.length;i++){
            int constant = lcm / primes[i];
            BasicLibTCT.mod = primes[i];            //IMP: In question the mod value is prime[i] which is responsible for mul and inv.
            long temp = BasicLibTCT.mulMod(rem[i], BasicLibTCT.inverse(constant)) % primes[i];

            ans += temp * constant;
        }
        System.out.println(lcm);

        return ans % lcm;
    }



    public static int findLCM(int mod[]){
        int res = 1;
        for(int i=0;i<mod.length;i++){
            res *= mod[i];

        }
        return res;
    }


}
