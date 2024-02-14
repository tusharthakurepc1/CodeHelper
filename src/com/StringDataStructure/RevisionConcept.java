package com.StringDataStructure;

import java.util.Arrays;

public class RevisionConcept {
    public static void main(String[] args) {
        int n = 10;
        String s1 = "abb", s2= "24", comb = "A24C";

        System.out.println(solution(s1));
    }

//    ORG:  ddaaabbaac
//    REV:  caabbaaadd
    public static int solution(String str){
        String rev = new StringBuilder(str).reverse().toString();
        int dp_arr[][] = new int[str.length()+1][rev.length()+1];
        int maxi = 0;

        for(int i=1;i<=str.length();i++){
            for(int j=1;j<=rev.length();j++){
                if(str.charAt(i - 1) == rev.charAt(j - 1)){
                    dp_arr[i][j] = 1 + dp_arr[i - 1][j - 1];

                    maxi = Math.max(maxi, dp_arr[i][j]);
                }
                else{
                    dp_arr[i][j] = 0;
                }
            }
        }

        for(int temp[]:dp_arr){
            System.out.println(Arrays.toString(temp));
        }
        System.out.println(maxi);

        return 0;
    }


}
