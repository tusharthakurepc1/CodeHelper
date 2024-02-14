package com.StringDataStructure;

public class ValidSuffix {
    public static void main(String[] args) {
        String a = "xy";
        String b = "12";
        String comb = "x21y";

        System.out.println(solution(a, b, comb));
    }

    public static boolean solution(String a, String b, String comb){
        if(a.length() + b.length() != comb.length()){
            return false;
        }

        int i = 0, j = 0, k = 0;

        while(k < comb.length()){
            if(i < a.length() && comb.charAt(k) == a.charAt(i)){
                i++;
            }
            else if(j < b.length() && comb.charAt(k) == b.charAt(j)){
                j++;
            }
            else{
                return false;
            }
            k++;
        }

        return true;
    }
}
