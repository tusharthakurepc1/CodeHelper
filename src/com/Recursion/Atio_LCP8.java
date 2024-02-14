package com.Recursion;

public class Atio_LCP8 {
    public static void main(String[] args) {
        String number = "0032";

//        System.out.println((int)'0'+ " "+ (int)'9');
//        System.out.println((int)'-');

        System.out.println(recursiveSolution(number, 0, 0));
    }

    public static int recursiveSolution(String str, int ind, int res){
        if(ind == str.length()){
            return res;
        }

        char ch = str.charAt(ind);
        if(ch >= 48 && ch <= 57){
            int res_t = (int)ch - 48;
            res = (res * 10) + res_t;
            return recursiveSolution(str, ind + 1, res);
        }
        else if(ch == 45){
            return -recursiveSolution(str, ind + 1, res);
        }
        else{
            return recursiveSolution(str, ind + 1, res);
        }
    }
}
