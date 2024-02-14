package com.BitManipulation;

public class Problems {
    public static void main(String[] args) {
//        System.out.println(isEvenOrOdd(20));
//        swapNumbers(2, 5);

//        System.out.println(getUniqueNumber(new int[]{2,2,5,4,5,9,9}));

//        System.out.println(isIthBitSet(18, 1));
//        System.out.println(isSignEqual(20, -10));

//        System.out.println(addOneToNumber(20));
//        System.out.println(subOneToNumber(20));

//        System.out.println(removeKthBit(20, 2));
//        System.out.println(removeLastSetBit(20));

//        System.out.println(isPowerOfTwo(1022));
//        System.out.println(countBits(20));

//        binaryExponential(3, 5);

        toLowerCase(new StringBuilder("TUshar"));
        toUpperCase(new StringBuffer("TushAR"));
    }


    public static boolean isEvenOrOdd(int n){
        if((n & 1) == 0){
            return true;
        }
        return false;
    }

    public static boolean isSignEqual(int a, int b){
        /*
            a = 1011(11)
            b = 1011(11)   // Neg number is represent in binary by using the 2nd complement of the absolute number.
           !...10100
                  +1
            b = 0101

            a = 1011
            b = 0101
         */

        if((a & b) > 0){
            return false;
        }

        return true;
    }

    public static int addOneToNumber(int num){
        /*
        19: 10011
        20: 10100
         */
        return -(~num);
    }

    public static int subOneToNumber(int num){
        /*
        19: 10011
        20: 10100
        -20:    01011 + 1
                01100

        ~20:  (19)10011

    NOTE:   ~(~20 +1)   ~(2nd Complement of 20 or '-' of 20)
         */

        return ~(-num);
    }

    public static void swapNumbers(int a, int b){
//        Using xor
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a + " " + b);
    }

    public static int getUniqueNumber(int arr[]){
        int ans = 0;

        for(int i=0;i<arr.length;i++){
            ans = ans ^ arr[i];
        }

        return ans;
    }

    public static boolean isIthBitSet(int num, int k){
        /*
                18: 10010   k = 1       10010   num
                                      & 00010   1 << k-1
                                        00010   so bit is set
         */
        if(((1 << k-1) & num) == 0){
            return true;
        }
        return false;
    }

    public static int removeKthBit(int num, int k){
        /*
        20: 10100
        k = 2

        10100
        00100
         */

        return ~(1 << k) & num;
    }

    public static int removeLastSetBit(int num){
        return (num-1) & num;
    }

    public static boolean isPowerOfTwo(int num){
        if(((num - 1) & num) == 0){
            return true;
        }

        return false;
    }

    public static int countBits(int num){
        int count = 0;

        for(int i=0;i<=32;i++){
//            System.out.println((num & (1<<i)));
            if((num & (1<<i)) >= 1){
                count++;
            }
        }
        return count;
    }

    public static void binaryExponential(int x, int y){
        System.out.println(Math.pow(x, y));
/*
        x = 3, y = 3         3* 3 *3 = 27

        3 = 011
             21
 */

        int res = 1;

        while(y > 0){
            if((y & 1) == 1){
                res = res * x;
            }

            x= x * x;
            y>>=1;
        }
        System.out.println(res);
    }

    public static void toLowerCase(StringBuilder str){
        for(int i=0;i<str.length();i++){
            str.setCharAt(i, (char)(str.charAt(i) | ' '));
        }

        System.out.println(Integer.toBinaryString(' '));
        System.out.println(str);

    }

    public static void toUpperCase(StringBuffer str){
        for(int i=0;i<str.length();i++){
            str.setCharAt(i, (char)(str.charAt(i) & (~' ')));
        }

        System.out.println(str);
    }
}

/*
A 1000001
B 1000010
C 1000011
D 1000100
E 1000101
F 1000110
G 1000111
H 1001000
I 1001001
J 1001010
K 1001011
L 1001100
M 1001101
N 1001110
O 1001111
P 1010000
Q 1010001
R 1010010
S 1010011
T 1010100
U 1010101
V 1010110
W 1010111
X 1011000
Y 1011001
Z 1011010

 */
