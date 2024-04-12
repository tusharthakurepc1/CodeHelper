package com;

public class Pair {
    public int first;
    public int second;

    public Pair(){
        first = second = 0;
    }

    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }

    public void show(){
        System.out.println("["+first+", "+second+"]");
    }

}
