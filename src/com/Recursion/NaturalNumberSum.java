package com.Recursion;

public class NaturalNumberSum {
    public static void main(String[] args) {
        int n = 6;

        System.out.println(naturalSum(n));
    }

    public static int naturalSum(int ind){
        if(ind == 0){
            return 0;
        }

        return ind + naturalSum(ind - 1);
    }
}
