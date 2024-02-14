package com.CP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits {
    public static void main(String[] args) {
        int low = 10, high = (int)Math.pow(10, 9);
        List<Integer> res = new ArrayList<>();

        for(int i=1;i<=9;i++){
            solution2(0, i, low, high, res);
        }

        Collections.sort(res);
        System.out.println(res);
    }


    public static void solution2(int value, int ind, int low, int high, List<Integer> res){
        if(low <= value && value <= high){
            res.add(value);
        }
        if(value > high || ind > 9){
            return;
        }

        solution2(value * 10 + ind, ind+1, low, high, res);

    }
}
