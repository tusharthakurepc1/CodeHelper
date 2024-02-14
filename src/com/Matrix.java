package com;

import java.util.ArrayList;
import java.util.List;

public class Matrix {
    public List<List<Integer>> matrix = new ArrayList<>();
    public int row = 0;
    public int col = 0;

    public Matrix(int _n){
        this.row = this.col = _n;
        for(int i=0;i<row;i++){
            matrix.add(new ArrayList<>());
            for(int j=0;j<row;j++){
                matrix.get(i).add(0);
            }
        }

    }

    public Matrix(int _n, int _m){
        this.row = _n;
        this.col = _m;
        for(int i=0;i<row;i++){
            matrix.add(new ArrayList<>());
            for(int j=0;j<col;j++){
                matrix.get(i).add(0);
            }
        }
    }

    public void identityMatrix(){
        if(row == col){
            for(int i=0;i<row;i++){
                matrix.get(i).add(i, 1);
            }
        }
    }

    public void display(){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(matrix.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
