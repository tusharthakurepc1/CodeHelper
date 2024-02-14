package com.CP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.CP.DSU;

public class KruskalsAlgorithmMST {
    public static void main(String[] args) {
        int v = 5;
        int e = 6;

        List<List<Integer>> edges = new ArrayList<>();

        // (x, y, weight)
        edges.add(new ArrayList<>(Arrays.asList(0, 1, 2)));
        edges.add(new ArrayList<>(Arrays.asList(0, 3, 6)));
        edges.add(new ArrayList<>(Arrays.asList(1, 3, 8)));
        edges.add(new ArrayList<>(Arrays.asList(1, 4, 5)));
        edges.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        edges.add(new ArrayList<>(Arrays.asList(2, 4, 7)));



        getParentDSU(edges, v);

    }

    public static void getParentDSU(List<List<Integer>> edges, int v){
        DSU dsu = new DSU(v-1);

        for(int i=0;i<edges.size();i++){
            dsu.addEdge(edges.get(i).get(0), edges.get(i).get(1));
        }
//        dsu.setGrandParent();

        int parent[] = dsu.returnParent();

        dsu.isConnected(4, 2);

        System.out.println(Arrays.toString(parent));


    }

    public static void makeMST(){

    }

}
