package com.Recursion;

import java.util.ArrayList;
import java.util.List;

public class RestoreIP {
    public static void main(String[] args) {
//        String str = "25525511135";
        String str = "101023";


        List<String> res = new ArrayList<>();
        recursiveSolution(str, "", 0, 4, res);

        System.out.println(res);

    }

    public static void recursiveSolution(String str, String buffer, int ind, int len, List<String> res){
        if(len == 0 && ind == str.length()){
            res.add(buffer.substring(0, buffer.length()-1));
            return;
        }
        if(ind > str.length() || len < 0){
            return;
        }

        //one length
        if(ind + 1 <= str.length()){
            String one = str.substring(ind, ind + 1);
            if(one.charAt(0) == '0' && one.length() > 1){}
            else{
                String temp = buffer + one + ".";
                recursiveSolution(str, temp, ind + 1, len - 1, res);
//            System.out.println(one);
            }
        }

        //two len
        if(ind + 2 <= str.length()){
            String two = str.substring(ind, ind + 2);
            if(two.charAt(0) == '0' && two.length() > 1){}
            else{
                String temp = buffer + two + ".";
                recursiveSolution(str, temp, ind + 2, len - 1, res);
//            System.out.println(two);
            }
        }

        if(ind + 3 <= str.length()){
            //three len
            String three = str.substring(ind, ind + 3);
            if(three.charAt(0) == '0' && three.length() > 1){}
            else{
                if(Integer.parseInt(three) <= 255){
                    String temp = buffer + three + ".";
                    recursiveSolution(str, temp, ind + 3, len - 1, res);
//            System.out.println(three);
                }
            }
        }

    }
}
