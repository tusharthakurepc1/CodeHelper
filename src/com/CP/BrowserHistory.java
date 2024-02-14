package com.CP;

import java.util.Stack;

public class BrowserHistory {
    public static void main(String[] args) {
        BrowserHistory bh = new BrowserHistory("leetcode.com");
        bh.visit("google.com");
        bh.visit("facebook.com");
        bh.visit("youtube.com");

        System.out.println(bh.back(1));
        System.out.println(bh.back(1));
        System.out.println(bh.forward(1));
        bh.visit("linked.in");
//        System.out.println(bh.forward(2));


        System.out.println("Primary: "+ bh.stack);
        System.out.println("Secondary: "+bh.secondary);
    }

    private Stack<String> stack= null;
    private Stack<String> secondary = null;


    public BrowserHistory(String homepage) {
        stack = new Stack<>();
        secondary = new Stack<>();
        stack.push("leetcode.com");
    }

    public void visit(String url) {
        stack.push(url);
        while(!secondary.isEmpty()){
            secondary.pop();
        }
    }

    public String back(int steps) {
        int temp = steps;

        while(!stack.isEmpty() && temp > 0){
            secondary.push(stack.pop());
            temp--;
        }

        if(stack.isEmpty()){
            stack.push(secondary.pop());
        }

        return stack.peek();
    }

    public String forward(int steps) {
        if(secondary.isEmpty()){
            return stack.peek();
        }

        int temp = steps;

        while(!secondary.isEmpty() && temp > 0){
            stack.push(secondary.pop());
            temp--;
        }

        return stack.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
