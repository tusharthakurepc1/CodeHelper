package com.BitManipulation;

public class Basics {
    public static void main(String[] args) {
//        bitwiseOperators();
        test();
    }

    public static void test(){
        int n=-8;

        if(n < 0){
            n=Integer.MAX_VALUE;
        }

        System.out.println(n);
        int temp=n;
        int count=0;
        while(temp != 0){
            if(temp%2 == 1) count++;
            temp=temp/2;
        }

        System.out.println(count);

    }

    public static void bitwiseOperators(){
        int a=9;        //9=  1001
        int b=7;        //7=  0111

        System.out.println(a & b);
        System.out.println(a | b);
        System.out.println(~a);
        System.out.println(a ^ b);  //Odd 1s then 1     Even 1s then 0
        System.out.println(a << 2);     //Original bits are:  1001  Output are:   100100
        System.out.println(a >> 2);     //Original bits are:  1001  Output are:   0010


    }
}
