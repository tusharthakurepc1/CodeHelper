package com.ArrayDataStructure;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {

//        System.out.println(getSpecificElement(6,2));
//        System.out.println(getEntireRow(6));
//        System.out.println(getEntireRowMeth2(6));
        System.out.println(pascalTriangle(6));

    }

    public static long getSpecificElement(int row,int col){     //Time O(n^2)   Space O(1)
        long res=1;
        //row=row-1;            col=col-1;    //row C col= row! /(col)! * (row-col)!
        for(int i=0;i<col;i++){
            res=res*(row-i);
            res=res/(i+1);
        }
        return res;
    }

    public static List<Long> getEntireRow(int row){   //Time O(n^2)   Space O(1)
        List<Long> res=new ArrayList<>();
        res.add(1L);
        for(int i=0;i<row;i++){
            res.add(getSpecificElement(row,i+1));
        }

        return res;
    }

    public static List<Long> getEntireRowMeth2(int row){      //Time O(N)     Space O(1);
        List<Long> res=new ArrayList<>();
        long temp=1;
        res.add(temp);

        for(int i=1;i<=row;i++){
            temp=temp*((row+1)-i);
            temp=temp/i;
            res.add(temp);
        }
        return res;
    }

    public static List<List<Long>> pascalTriangle(int n){
        List<List<Long>> res=new ArrayList<>();

        for(int i=0;i<n;i++){
            res.add(getEntireRowMeth2(i));
        }
        return res;
    }

}
