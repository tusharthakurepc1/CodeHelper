package com.Recursion;

public class NumberOfStepsToReduceNumber {
    public static void main(String[] args) {
        int num = 2;

        System.out.println(numberOfStepsToReduceANumberToZero(num));
    }

    public static int numberOfStepsToReduceANumberToZero(int num){
        if(num == 0 || num == 1){
            if(num == 1)    return 1;
            else    return 0;
        }


        if (num % 2 == 0) {
            return 1 + numberOfStepsToReduceANumberToZero(num / 2);
        }
        else{
            return 1 + numberOfStepsToReduceANumberToZero(num - 1);
        }
    }
}
