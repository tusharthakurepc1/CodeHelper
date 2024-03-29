package com.Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak_II {
    public static void main(String[] args) {

        String str = "catsandog";
        String wordDict[] = {"cats","dog","sand","and","cat"};

        Map<String, Boolean> keys = new HashMap<>();
        for(int i=0;i<wordDict.length;i++)  keys.put(wordDict[i], true);


        List<String> res = new ArrayList<>();
        recursiveSolution(str, "", 0, keys, res);
    }

    public static void recursiveSolution(String str, String processed, int ind, Map<String, Boolean> keys, List<String> res){
        if(ind == str.length()){
            res.add(processed.substring(0, processed.length()-1));
//            System.out.println(processed);
            return;
        }
        if(ind > str.length()){
            return;
        }


        //try all the possible substring
        for(int i=ind + 1;i<=str.length();i++){
            String temp = str.substring(ind, i);

            if(keys.containsKey(temp)){
                String temp_p = processed + temp + " ";
                recursiveSolution(str, temp_p, i, keys, res);
            }

        }


    }


}
