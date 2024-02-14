package com.StringDataStructure;

public class StringIsRotationOfAnother {
    public static void main(String[] args) {
        String s1 = "abacd";
        String s2 = "cdaba";

        System.out.println(solution(s1,s2));
    }

    public static boolean solution(String s1,String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        String temp = s1 + s1;
        if(temp.indexOf(s2) != -1){
            return true;
        }
        else{
            return false;
        }
    }
}
