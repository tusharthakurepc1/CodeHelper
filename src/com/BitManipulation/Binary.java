package com.BitManipulation;

public class Binary {
    public static void main(String[] args) {
        binaryNumbers(21);
        System.out.println(Integer.toBinaryString(-10));
    }

    public static void binaryNumbers(int n){
        for(int i=0;i<=n;i++){
            System.out.println(i+": " +Integer.toBinaryString(i));
        }
    }
}

/*

0: 0
1: 1
2: 10
3: 11
4: 100
5: 101
6: 110
7: 111
8: 1000
9: 1001
10: 1010
11: 1011
12: 1100
13: 1101
14: 1110
15: 1111
16: 10000
17: 10001
18: 10010
19: 10011
20: 10100

 */
