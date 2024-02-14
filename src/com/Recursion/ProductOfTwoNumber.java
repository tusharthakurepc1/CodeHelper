package com.Recursion;

public class ProductOfTwoNumber {
    public static void main(String[] args) {
        int a = 2, b = 4000;


        System.out.println(helper(a, b));
        System.out.println(productOptimal(a, b));
    }

    public static int helper(int a,int b){
        //Not to be good for certain case if value of b is grater then the stack space also increases.
        if(b == 1){
            return a;
        }

        return a + helper(a, b-1);
    }


    public static int productOptimal(int a, int b){
        if(b == 1){
            return a;
        }
        if(a < b){
            return b + productOptimal(b, a-1);
        }
        else{
            return a + productOptimal(a, b-1);
        }
    }
}
