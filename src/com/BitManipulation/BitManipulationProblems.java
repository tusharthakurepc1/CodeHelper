package com.BitManipulation;

public class BitManipulationProblems {
    public static void main(String[] args) {
        int a=45;
        int b=90;

//        swapUsingBitManipulation(a,b);
//        printXORFromOneToNBruteForce(5);
//        System.out.println(printXORFromOneToNOptimal(5));
//        System.out.println(printXORFromRangeNToMOptimal(2,4));
//        System.out.println(evenOrOddOptimal(100));
//        chkIthBitIsSet(7,4);
//        setIthBit(8,1);
//        clearIthBit(11,1);
        countBits1s(-3);
    }

    public static void swapUsingBitManipulation(int a,int b){
        System.out.println("Before Swap: "+a+" "+b);
//                    a=45 b=90
        a = a ^b;          // a= 45 ^ 90
        b = a ^b;          // b= 45 ^ 90 ^ 90      so b= 45    why? 90 got cancel because it occurrence is even
        a = a ^b;          // a= 45 ^ 90 ^ 45      so a= 90    why? 45 got cancel because it occurrence is even

        System.out.println("After Swap: "+a+" "+b);
    }

    public static void printXORFromOneToNBruteForce(int n){
        //n=5       1 ^ 2 ^ 3 ^ 4 ^ 5
        int res=0;
        for(int i=1;i<=n;i++){
            res = res ^ i;
        }

        System.out.println(res);
    }

    public static int printXORFromOneToNOptimal(int n){
        if(n % 4 == 0){
//            System.out.println(n);
            return n;
        }
        else if (n % 4 == 1) {
//            System.out.println(1);
            return 1;
        }
        else if(n % 4 == 2){
//            System.out.println(n+1);
            return n+1;
        }
        else{
//            System.out.println(0);
            return 0;
        }
    }

    public static int printXORFromRangeNToMOptimal(int n,int m){
        int a=printXORFromOneToNOptimal(m);
        int b=printXORFromOneToNOptimal(n-1);

        return b ^ a;
    }

    public static boolean evenOrOddOptimal(int val){
//        Use Bitwise Operator is more optimal and faster as compare to mod, division, etc.

//        Using And Bitwise Operator    NOTE: All even binary number having right 1st bit is always 0.
//                                      NOTE: All odd binary number having right 1st bit is always 1.
//        IF we perform AND operation with number and 1 value the result is 0 then odd otherwise even.
//        Binary of 5 is: 0101 perform AND with 1   Result is 1     So it is odd.
//        Binary of 6 is: 0110 perform AND with 1   Result is 0     So is is even.

        int ans=val & 1;
        if(ans != 0){       //Check for the odd case
            return false;
        }

        return true;    //Remaining case was even.
    }

    public static void chkIthBitIsSet(int a,int k){
        int mask=0;
        mask=1<<(k-1);
        int res= a & mask;
//        System.out.println(a+" "+mask+" "+res);

        if(res != 0){
            System.out.println("Set");
        }
        else{
            System.out.println("Not Set");
        }
    }

    public static void setIthBit(int a,int k){
        int mask=1<< (k-1);
        int res=a | mask;

        System.out.println(res);
    }

    public static void clearIthBit(int a,int k){
        int mask=~(1<<(k-1));
        int res=a & mask;
        System.out.println(res);
    }

    public static void countBits1s(int a){
        int count=0;

        while(a != 0){
            if((a & 1) != 0){
                count++;
            }
            if(a < 0){
                a=a >>> 1;
            }
            else{
                a=a>>1;
            }
        }

        System.out.println(count);
    }
}
