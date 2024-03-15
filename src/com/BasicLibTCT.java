package com;

import java.util.Arrays;

public class BasicLibTCT {
    public static int mod = 1000000007;          //This mod is defined in the question otherwise default 10^7 + 7 and 10e7+7(CPP)

    public static int max(int a,int b){
        if(a > b)   return a;
        else    return b;
    }

    public static int min(int a,int b){
        if(a < b)   return a;
        else    return b;
    }

    public static void swap(int arr[],int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public static void rotateArray(int arr[],int st,int end){
        while(st <= end){
            int temp=arr[st];
            arr[st]=arr[end];
            arr[end]=temp;

            st++;
            end--;
        }
    }

    public static void rotateColumn2D(int arr[][],int col_no){
        int st=0,end=arr[0].length-1;
        while (st <= end) {
            int temp=arr[st][col_no];
            arr[st][col_no]=arr[end][col_no];
            arr[end][col_no]=temp;
            st++;
            end--;
        }
    }

    public static boolean isPrime(long num){
        int count = 0;
        for(long i = 1;i<= num ;i++){
            if(num % i == 0){
                count ++;
            }
        }
        if(count == 2){
            return true;
        }
        return false;
    }

    public static long addMod(long a, long b){
        return (a % mod + b % mod) % mod;
    }

    public static long subMod(long a, long b){
        return ((a % mod - b % mod) + mod) % mod;
    }

    public static long mulMod(long a, long b){
        return (a % mod * b % mod) % mod;
    }

    public static long inverse(long a){
        return power(a, mod-2);
    }

    public static double divMod(long a, long b){
        long inverse = power(b, mod-2);             //Fermat's little theorem
        return mulMod(a, inverse);
    }

    public static long power(long a, long b){           //Binary Exponential..
        long res = 1;

        while(b != 0){
            if((b & 1) == 1){
                res = mulMod(res, a);
            }

            a = mulMod(a, a);
            b >>= 1;
        }

        return res;
    }

    public static int[] factorial(int n){
        int factorials[] = new int[n+1];
        factorials[0] = factorials[1] = 1;

        for(int i=2;i<=n;i++){
            factorials[i] = factorials[i-1] * i;
        }

        return factorials;
    }

    public static long combinations(int n, int r){
/*
 * nCr = n!/ r!+ (n-r)!
 * nCr = n! * r!^-1 * (n-r)!^-1     So how this is achieve this
 * Constraints: Make sure that the n >= r otherwise give the ArrayOutOfBoundException
 */
        if(n < 0 || r < 0)  return 0;

        int factorials[] = factorial(Math.max(n, r));
        int fn = factorials[n];
        int fr = factorials[r];
        int fn_r = factorials[n-r];

        long combinations = mulMod(fn , inverse(fr));
        combinations = mulMod(combinations, inverse(fn_r));

        return combinations;
    }

    public static void permutations(int arr[], int ind){
        if(ind >= arr.length){
            System.out.println(Arrays.toString(arr));
            return;
        }

        //Go for all the possibilities
        for(int i=ind;i<arr.length;i++){
            swap(arr, i, ind);

            permutations(arr, ind + 1);

            swap(arr, i, ind);
        }
    }


    public static void main(String[] args) {

    }
}
