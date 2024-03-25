package com.GraphDataStructure;

import java.util.ArrayList;
import java.util.List;

public class Pair {
    public int x = 0;
    public int y = 0;

    public Pair(int _x, int _y){
        this.x = _x;
        this.y = _y;
    }

    public void coordinates(){
        System.out.println("("+this.x+"  "+this.y+")");
    }
}

class GraphNode{
    public int value;
    public List<GraphNode> neighbors;

    GraphNode(){
        this.value = 0;
        neighbors = new ArrayList<>();
    }

    GraphNode(int _value){
        this.value = _value;
        neighbors = new ArrayList<>();
    }
    GraphNode(int _value, List<GraphNode> _neighbour){
        this.value = _value;
        this.neighbors = _neighbour;
    }

    public void displayGraphNode(){
        System.out.println("Node address: "+this+" Node: "+value);
        System.out.println("==>Neighbours: "+neighbors);
    }
}