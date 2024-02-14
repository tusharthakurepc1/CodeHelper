package com.CP;

import java.util.Arrays;
import java.util.Stack;

public class SimplifyPathStack {
    public static void main(String[] args) {
        String str = "/a/./b/../../c/";


        simplifyPath(str);
    }

    public static void simplifyPath(String str){
        Stack<String> stack = new Stack<>();
        String str_arr[] = str.split("[/]");
        System.out.println(Arrays.toString(str_arr));

        for(String st: str_arr){
            if(st.equals(""))   continue;
            else if(st.contains(".")){
                if(!stack.isEmpty())    stack.pop();
            }
            else{
                stack.push(st);
            }
        }

        String path = "";

        while(!stack.isEmpty()){
            path = "/" + stack.pop() +path;
        }

        System.out.println(path);
    }
}
