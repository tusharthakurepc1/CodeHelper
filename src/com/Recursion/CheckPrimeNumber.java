package com.Recursion;

public class CheckPrimeNumber {
    public static void main(String[] args) {
        int num = 1;

        if(checkPrime(num, 1) == 2){
            System.out.println("Prime");
        }
        else{
            System.out.println("Not Prime");
        }

        if(checkPrimeOptimal(num, 1) == 2){
            System.out.println("Prime");
        }
        else{
            System.out.println("Not Prime");
        }
    }

    public static int checkPrime(int num, int ind){ //Complexity O(n)
        if(ind == num) {
            return 1;
        }

        if(num % ind == 0){
            return 1 + checkPrime(num, ind+1);
        }
        else{
            return checkPrime(num, ind+1);
        }
    }

    public static int checkPrimeOptimal(int num, int ind){
        if(ind * ind >= num){
            if(ind * ind == num)    return 1;
            else    return 0;
        }

        if(num % ind == 0){
            return 2 + checkPrimeOptimal(num, ind + 1);
        }
        else{
            return checkPrimeOptimal(num, ind + 1);
        }
    }
}
