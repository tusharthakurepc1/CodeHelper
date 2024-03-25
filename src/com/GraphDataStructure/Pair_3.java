package com.GraphDataStructure;

public class Pair_3{
    public int a = 0;
    public int b = 0;
    public int c = 0;

    public Pair_3(int _a, int _b, int _c){
        this.a = _a;
        this.b = _b;
        this.c = _c;
    }

    public void coordinates(){
        System.out.println("("+this.a+" "+this.b+ " " +this.c+")");
    }
}