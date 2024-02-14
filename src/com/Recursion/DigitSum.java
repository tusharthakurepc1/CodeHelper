package com.Recursion;

public class DigitSum {
    public static void main(String[] args) {
        int digit = 12345;

        System.out.println(digitSum(digit));
    }
    public static int digitSum(int digit){
        if(digit == 0){
            return 0;
        }
        return (digit % 10) + digitSum(digit / 10);
    }
}
