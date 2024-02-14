package com.CP;

import java.util.ArrayList;
import java.util.List;

public class GCD {
    public static int count = 0;
    public static void main(String[] args) {

//        System.out.println(gcd(26, 4));
        System.out.println(gcdRecursive(1000, 1));
        System.out.println(gcdRecursiveOptimal(1000, 1));
    }
/*  Explanation of the approach
 * GCD of 26 and 4 is 2.    gcd(a, b) = gcd(b, b-a)
 *
 *
 * gcd(26, 4)
 * 4, 26
 * 4, 22
 * 4, 18 ....
 *       GCD is 4
 *
 * Optimal Solution
 * gcd(26, 4)       Just Perform the mod instead of subtraction so gcd(b%a, b) because we know we need to subtract
 *                  until the a reduced to b, In this approach the a > b in all case so there is now swap required
 * 4, 4
 * 0, 4
 *      GCD is 4
 */


    public static int gcdRecursiveOptimal(int a, int b){        //**OPTIMAL**
        if(a == 0)  return b;
        if(b == 0)  return a;

        System.out.println(a+" "+b);

        return gcdRecursiveOptimal(b % a, a);
    }

    public static int gcdRecursive(int a, int b){
        if(a == 0)  return b;
        if(b == 0)  return a;

        System.out.println(a+" "+b);

        if(a > b){
            int temp = a;
            a = b;
            b = temp;
        }

        return gcdRecursive(a, b-a);
    }

    public static int gcd(int a, int b){
        int gcd = 0;
        int length = Math.min(a, b);

        for(int i=1;i<=length;i++){
            if(a % i == 0 && b % i == 0){
                gcd = i;
            }
        }

        return gcd;
    }


}
