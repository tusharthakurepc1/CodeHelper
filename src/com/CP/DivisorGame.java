package com.CP;

public class DivisorGame {
    public static void main(String[] args) {
        int n = 2;
        helper(n);
    }

    public static void helper(int n){
        int time = 0;

        while(n > 1){
            if(n % 2 == 0){
                n--;
            }
            else{
                for(int i=1;i<10;i+=2){
                    if(n % i == 0){
                        n -= i;
                        break;
                    }
                }
            }
            time++;
        }

        System.out.println(n);
        if(time % 2 == 1){      //Odd then alice wins
            System.out.println("Alice win");
        }
        else{                   //Even then bob wins
            System.out.println("Bob win");
        }

    }
}
