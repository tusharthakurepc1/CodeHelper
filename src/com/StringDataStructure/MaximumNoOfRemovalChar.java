package com.StringDataStructure;

import java.util.Locale;

public class MaximumNoOfRemovalChar {
    public static void main(String[] args) {
        String s = "qobftgcueho";
        String p = "obue";
        int arr[] = {5,3,0,6,4,9,10,7,2,8};

        helper(s, p, arr);
    }

    public static void helper(String s, String p, int arr[]){

        StringBuilder sb1 = new StringBuilder(s);

        for(int counter=0;counter<arr.length;counter++){
            sb1.deleteCharAt(arr[counter]);
            System.out.println(sb1);

            int i = 0, j = 0;
            while(i < sb1.length() && j < p.length()){
                if (sb1.charAt(i) == p.charAt(j)) {
                    j++;
                }
                i++;
            }
            if(j < p.length()){
                System.out.println(counter);
                return;
            }
        }
    }

}
