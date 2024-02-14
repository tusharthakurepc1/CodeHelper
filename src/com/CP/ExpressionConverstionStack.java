package com.CP;

import java.util.Stack;

public class ExpressionConverstionStack {
    public static void main(String[] args) {
        String expr_infix = "a-b/(c*d/e)";
        String expr_postfix = "abc+*";
        String expr_prefix = "*a+bc";

        infixToPostfix(expr_infix);
//        postfixToInfix(expr_postfix);
        infixToPreFix(expr_infix);
    }

    public static void infixToPreFix(String expr){
        Stack<String> stack = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for(int i=0;i<expr.length();i++){
            int op = operator(expr.charAt(i));

            if(expr.charAt(i) == '('){
                operator.push('(');
            }
            else if(expr.charAt(i) == ')'){
                while(!operator.isEmpty() && operator.peek() != '('){
                    char temp = operator.pop();
                    String b = stack.pop();
                    String a = stack.pop();

                    stack.push(""+ temp+ a+ b);
                }
                operator.pop();
            }
            else if(op != -1){
//                it is basically an operator

                while(!operator.isEmpty() && operator(operator.peek()) >= op){
                    char temp = operator.pop();
                    String b = stack.pop();
                    String a = stack.pop();

                    stack.push(""+ temp+ a+ b);
                }

                operator.push(expr.charAt(i));
            }
            else{
                stack.push(""+expr.charAt(i));
            }
        }

        while(!operator.isEmpty()){
            char temp = operator.pop();
            String b = stack.pop();
            String a = stack.pop();

            stack.push(""+ temp+ a+ b);
        }

        System.out.println(stack);

    }

    public static void postfixToInfix(String expr){
        Stack<String> stack = new Stack<>();
        String res = "";

        for(int i=0;i<expr.length();i++){

            int op = operator(expr.charAt(i));

            if(op != -1){
//                it is basically an operator
                String sec = stack.pop();
                String one = stack.pop();

                stack.push(one + expr.charAt(i) + sec);
            }
            else{
                stack.push(""+ expr.charAt(i));
            }

        }

        System.out.println(stack);

    }

    public static void infixToPostfix(String expr){
        Stack<Character> stack = new Stack<>();
        String res = "";

        for(int i=0;i<expr.length();i++){
            int temp = operator(expr.charAt(i));

            if(expr.charAt(i) == '('){
                stack.push('(');
            }
            else if(expr.charAt(i) == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    res += stack.peek();
                    stack.pop();
                }
                stack.pop();
            }
            else if(temp != -1){
//                   It is a operator
                while(!stack.isEmpty() && operator(stack.peek()) >= temp){
                    res += stack.peek();
                    stack.pop();
                }
                stack.push(expr.charAt(i));
            }
            else{
                res += expr.charAt(i);
            }
        }
        while(!stack.isEmpty()){
            res += stack.peek();
            stack.pop();
        }

        System.out.println(res);
    }

    public static int operator(char ch){
        if(ch == '^'){
            return 3;
        }
        else if(ch == '/' || ch == '*'){
            return 2;
        }
        else if(ch == '+' || ch == '-'){
            return 1;
        }
        return -1;
    }
}
