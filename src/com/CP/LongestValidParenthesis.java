package com.CP;

import java.util.Stack;

public class LongestValidParenthesis {
    public static void main(String[] args) {
        String s = ")((()))";


//        logic(s);
        optimalSolution(s);

    }

//  Brute Force
    public static void logic(String s){
        String res = "";
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){

            if(s.charAt(i) == '('){
                stack.push('(');
            }
            else if(s.charAt(i) == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    res += "()";
                    stack.pop();
                }
            }
        }
        int len = res.length();

        while(!stack.isEmpty()){
            len -= 2;
            stack.pop();
        }

        System.out.println(len);
    }

    public static void optimalSolution(String s){
        Stack<Integer> index = new Stack<>();
        Stack<Character> stack = new Stack<>();
        index.push(-1);

        int max_length = 0;

        for(int i=0;i<s.length();i++){

            if(s.charAt(i) == '('){
                index.push(i);
                stack.push('(');
            }
            else{
                if(stack.isEmpty()){
                    index.push(i);
                }
                else{
                    stack.pop();
                    index.pop();
                }
                max_length = Math.max(max_length, i - index.peek());
            }

            System.out.println("Stack: "+stack+" , Index: "+index);

        }

        System.out.println(max_length);

    }
}
