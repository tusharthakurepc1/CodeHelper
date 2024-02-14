package com.StackDataStructure;

public class CheckBalancedParenthesis {
    public static void main(String[] args) {
        String input="]";

        System.out.println(checkParenthesis(input));
    }

    public static boolean checkParenthesis(String text){
        Stack stack=new Stack(text.length());

        for(int i=0;i<text.length();i++){
            char ch=text.charAt(i);

            if(ch == '{' || ch == '[' || ch == '('){
                stack.push(ch);
            }
            else if(ch == '}'){
                char chk=(char)stack.peek();
                stack.pop();

                if(chk == '{')  continue;
                else    return false;
            }
            else if(ch == ']'){
                char chk=(char)stack.peek();
                stack.pop();

                if(chk == '[')  continue;
                else    return false;
            }
            else if(ch == ')'){
                char chk=(char)stack.peek();
                stack.pop();

                if(chk == '(')  continue;
                else    return false;
            }
            else if (ch == ' ') {
                continue;
            }
            else {
                System.out.println("Invalid Bracket");
                return false;
            }

        }
        if(stack.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}
