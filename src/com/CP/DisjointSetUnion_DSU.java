package com.CP;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DisjointSetUnion_DSU {

    public static void main(String[] args) {

        DSU o1 = new DSU(7);
        o1.addEdge(1, 2);
        o1.addEdge(2, 3);
        o1.addEdge(3, 4);
        o1.addEdge(5, 6);
        o1.addEdge(6, 7);

        int comp1 = 1, comp2 = 4;

//        This is executed you find the connected Component at O(n)
        {
            o1.isConnected(comp1, comp2);
        }

        {
            o1.setGrandParent();
            o1.isConnectedConstant(comp1, comp2);
        }


    }

}


class DSU{
    int parent[] = null;
    DSU(int n){
        parent = new int[n+1];
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
        }
    }

    public int[] returnParent(){
        return parent;
    }

    public int getParent(int x){
        if(x == parent[x]){
            return x;
        }

        return parent[x] = getParent(parent[x]);
    }

    public void addEdge(int x, int y){
        int xPar = getParent(x);
        int yPar = getParent(y);

        parent[xPar] = parent[yPar];
    }

    public void isConnected(int x, int y){
        int xPar = getParent(x);
        int yPar = getParent(y);

        System.out.println(xPar == yPar);
    }


    public void setGrandParent(){
        for(int i=0;i<parent.length;i++){
            int temp = i;
            while(temp != parent[temp]){
                temp = parent[temp];
            }
            parent[i] = temp;
        }
    }

    public void isConnectedConstant(int x, int y){
        int superParentX = parent[x];
        int superParentY = parent[y];

        System.out.println(superParentX == superParentY);
    }

}