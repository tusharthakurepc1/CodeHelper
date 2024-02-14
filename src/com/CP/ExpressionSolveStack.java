package com.CP;

import java.util.Stack;

public class ExpressionSolveStack {
    public static void main(String[] args) {
        StringBuilder expr = new StringBuilder("2-2-1");
//        expr.setCharAt(0, '(');

        System.out.println("("+expr.substring(0, expr.length()));
//        infixSolve(expr.toString());
    }

    public static void infixSolve(String expr){
        Stack<String> operand = new Stack<>();
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<expr.length();i++){
            int temp = operator(expr.charAt(i));

            if(expr.charAt(i) == '('){
                stack.push('(');
            }
            else if(expr.charAt(i) == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    int sec = Integer.parseInt(operand.pop());
                    int first = Integer.parseInt(operand.pop());

                    char op_ch = stack.pop();

                    if(op_ch == '^') operand.push(""+(Math.pow(first, sec)));
                    else if(op_ch == '/') operand.push(""+(first/sec));
                    else if(op_ch == '*') operand.push(""+(first*sec));
                    else if(op_ch == '-') operand.push(""+(first-sec));
                    else if(op_ch == '+') operand.push(""+(first+sec));
                }
                stack.pop();
            }
            else if(temp != -1){
//                It is a operator
                while(!stack.isEmpty() && operator(stack.peek()) > temp){
                    int sec = Integer.parseInt(operand.pop());
                    int first = Integer.parseInt(operand.pop());

                    char op_ch = stack.pop();

                    if(op_ch == '^') operand.push(""+(Math.pow(first, sec)));
                    else if(op_ch == '/') operand.push(""+(first/sec));
                    else if(op_ch == '*') operand.push(""+(first*sec));
                    else if(op_ch == '-') operand.push(""+(first-sec));
                    else if(op_ch == '+') operand.push(""+(first+sec));
                }

                stack.push(expr.charAt(i));

            }
            else{
                operand.push(""+expr.charAt(i));
            }
        }
        while(!stack.isEmpty()){
            int sec = Integer.parseInt(operand.pop());
            int first = Integer.parseInt(operand.pop());

            char op_ch = stack.pop();

            if(op_ch == '^') operand.push(""+(Math.pow(first, sec)));
            else if(op_ch == '/') operand.push(""+(first/sec));
            else if(op_ch == '*') operand.push(""+(first*sec));
            else if(op_ch == '-') operand.push(""+(first-sec));
            else if(op_ch == '+') operand.push(""+(first+sec));
        }

        System.out.println(stack);
        System.out.println(operand);
    }

    public static int operator(char ch){
        if(ch == '^'){
            return 3;
        }
        else if(ch == '*' || ch == '/'){
            return 2;
        }
        else if(ch == '+' || ch == '-'){
            return 1;
        }
        return -1;
    }
}
