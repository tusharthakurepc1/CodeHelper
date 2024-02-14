package com.Recursion;

public class FirstUppercaseLetter {
    public static void main(String[] args) {
        System.out.println((int)'A'+ " "+(int)'Z');

        System.out.println(solution("hello",4));
    }

    public static char solution(String s, int ind){
        if(ind < 0){
            return '_';
        }

        if(s.charAt(ind) >=65 && s.charAt(ind) <= 90){
            return s.charAt(ind);
        }

        return solution(s, ind-1);
    }
}
