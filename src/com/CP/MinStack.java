package com.CP;

import java.util.Stack;

class Pair{
    int first, second;
    Pair(int first_, int second_){
        this.first = first_;
        this.second = second_;
    }
}

public class MinStack {
    public static Pair[] stack = new Pair[30001];
    public static int sp = -1;

    public static void main(String[] args) {

    }

    public void push(int val) {
        sp++;
        if(sp == 0){
            stack[sp] = new Pair(val, val);
        }
        else{
            stack[sp] = new Pair(val, Math.min(val, stack[sp-1].second));
        }
    }

    public void pop() {
        stack[sp] = null;
        sp--;
    }

    public int top() {
        return stack[sp].first;
    }

    public int getMin() {
        return stack[sp].second;
    }

}
