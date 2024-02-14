package com.CP;

public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 3;


        generateParenthesis("(", 1, 0, n);
    }

    public static void generateParenthesis(String processed, int open, int closed, int n){
        if(open < closed){
            return;
        }
        if(processed.length() == n*2){
            System.out.println(processed);
            return;
        }

//        Open Parenthesis call
        if(open < n)
            generateParenthesis(processed+"(", open+1, closed, n);

//        Closed Parenthesis call
        generateParenthesis(processed+")", open, closed+1, n);


    }
}
