package com.Recursion;

import java.util.ArrayList;
import java.util.List;

public class NDigitNumber {
    public static void main(String[] args) {
        int n = 3;
        List<Integer> res = new ArrayList<>();

        int start = (int)Math.pow(10, n)/10;
        int end = (int)Math.pow(10, n);

        System.out.println(end-start);
        for(int i=start;i<end;i++){
            res.add(i);
        }

        System.out.println(res);

    }
}
